import junit.framework.TestCase;
import org.junit.Test;
import second.Dijkstra;

public class DijkstraTest extends TestCase {

    Dijkstra.Vertex v1;
    Dijkstra.Vertex v2;
    Dijkstra.Vertex v3;
    Dijkstra.Vertex v4;
    Dijkstra dijkstra;

    @Override
    public void setUp() {

        dijkstra = new Dijkstra();

        v1 = new Dijkstra.Vertex("gdansk");
        v1.addNeighbour(2, 1);
        v1.addNeighbour(3, 3);

        v2 = new Dijkstra.Vertex("bydgoszcz");
        v2.addNeighbour(1, 1);
        v2.addNeighbour(3, 1);
        v2.addNeighbour(4, 4);

        v3 = new Dijkstra.Vertex("torun");
        v3.addNeighbour(1, 3);
        v3.addNeighbour(2, 1);
        v3.addNeighbour(4, 1);

        v4 = new Dijkstra.Vertex("warszawa");
        v4.addNeighbour(2, 4);
        v4.addNeighbour(3, 1);

        dijkstra.addVertex(v1);
        dijkstra.addVertex(v2);
        dijkstra.addVertex(v3);
        dijkstra.addVertex(v4);

    }

    @Test
    public void testSearchMinPath() {

        assertEquals(dijkstra.searchMinDistance(v1, v2), 1);
        assertEquals(dijkstra.searchMinDistance(v1, v3), 2);
        assertEquals(dijkstra.searchMinDistance(v2, v4), 2);
        assertEquals(dijkstra.searchMinDistance(v3, v4), 1);
        assertEquals(dijkstra.searchMinDistance(v1, v4), 3);


    }

}
