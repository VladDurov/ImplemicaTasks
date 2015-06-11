package second;

import java.util.*;

/**
 *  Class based on Dijkstra algorithm to find shortest way
 */
public class Dijkstra {

    private Set<Vertex> vertexes = new HashSet<Vertex>();

    public void addVertex(Vertex vertex) {
        vertexes.add(vertex);
    }

    public Vertex getVertex(int vertexId) {
        for (Vertex v : vertexes) {
            if (v.getId() == vertexId) {
                return v;
            }
        }
        return new Vertex("");
    }

    public Vertex getVertex(String vertexName) {
        for (Vertex v : vertexes) {
            if (v.getName().equalsIgnoreCase(vertexName)) {
                return v;
            }
        }
        return new Vertex("");
    }

    private Vertex getVertexWithMinDistance(List<Vertex> vertxs) {
        Collections.sort(vertxs);
        return vertxs.get(0);
    }

    /**
     * This metod realise Dijkstra algorithm:
     *
     * At the beginning of the algorithm for the initial vertex distance is assumed to be zero,
     * and all other distances are filled with a large positive number (greater than the maximum possible way).
     * At each step of the cycle we are looking for the top with a minimum distance.
     * If their distance is greater than the sum of the distance from the current vertex and edge length, then reduce it.
     * The cycle ends when all vertices passed.
     *
     * @param from start vertex
     * @param to end vertex
     * @return returns the shortest path from vertex 'from' to vertex 'to'
     */
    public int searchMinDistance(Vertex from, Vertex to) {

        for (Vertex vertex : vertexes) {
            vertex.distance = Integer.MAX_VALUE;
        }

        from.setDistance(0);

        ArrayList<Vertex> vertxs = new ArrayList<Vertex>(vertexes);

        while (!vertxs.isEmpty()) {

            Vertex vertexWithMinDist = getVertexWithMinDistance(vertxs);

            for (Integer vertexId : vertexWithMinDist.getKeysNeighbours()) {

                Vertex vertexNeighbour = getVertex(vertexId);

                int minSumDist = vertexWithMinDist.getDistance() + vertexWithMinDist.getDistanceToNeighbour(vertexId);

                if (minSumDist < vertexNeighbour.getDistance()) {

                    vertexNeighbour.setDistance(minSumDist);

                }
            }

            vertxs.remove(vertexWithMinDist);

        }

        return to.getDistance();

    }


    public static class Vertex implements Comparable<Vertex> {

        private static int countVertex;
        private int id;
        private String name;
        private int distance;
        private HashMap<Integer, Integer> neighboursVertexes;

        public Vertex(String name) {
            this.name = name;
            this.id = ++countVertex;
            this.neighboursVertexes = new HashMap<Integer, Integer>();
        }

        public void addNeighbour(int vertexId, int distance) {
            neighboursVertexes.put(vertexId, distance);
        }

        public void deleteNeighbour(int id) {
            neighboursVertexes.remove(id);
        }

        public int getDistanceToNeighbour(int id) {
            return neighboursVertexes.get(id);
        }

        public int compareTo(Vertex v) {
            return this.distance - v.distance;
        }

        public Set<Integer> getKeysNeighbours() {
            return neighboursVertexes.keySet();
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Vertex vertex = (Vertex) o;

            return id == vertex.id;

        }

        @Override
        public int hashCode() {
            return id;
        }

        public void setDistance(int distance) {
            this.distance = distance;

        }

    }

}
