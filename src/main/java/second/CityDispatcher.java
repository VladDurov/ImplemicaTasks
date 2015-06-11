package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CityDispatcher {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите количество тестов:");

        int countTests = getAnInt(br);

        for (int test = 0; test < countTests; test++) {

            System.out.println("Данные для теста №" + (test + 1));
            System.out.println("Введите количество городов:");

            int countCities = getAnInt(br);

            Dijkstra dijkstra = new Dijkstra();

            for (int numberCity = 0; numberCity < countCities; numberCity++) {

                System.out.println("Введите название города №" + (numberCity + 1) + ":");

                City city = new City(getTrim(br));

                System.out.println("Введите количество близжайших городов для " + city.getName() + ":");

                int countNeighbours = getAnInt(br);

                for (int neighbour = 0; neighbour < countNeighbours; neighbour++) {
                    System.out.println("Введите ID города и стоимость пути к " + (neighbour + 1) + " близжайшему через пробел:");

                    String[] params = getTrim(br).split(" ");
                    if (params.length == 2) {
                        city.addNeighbour(Integer.valueOf(params[0]), Integer.valueOf(params[1]));
                    }

                }

                dijkstra.addVertex(city);

            }

            System.out.println("Введите количество запросов нахождения минимальной стоимости:");

            int countQuery = getAnInt(br);

            List<String[]> citiesForSearch = new ArrayList<String[]>();
            for (int query = 0; query < countQuery; query++) {

                System.out.println("Введите город-отправления и город-назначения через пробел:");

                String[] params = getTrim(br).split(" ");

                if (params.length == 2) {
                    citiesForSearch.add(params);
                }

            }

            System.out.println("Результат: ");

            for (String[] params : citiesForSearch) {

                int minCost = dijkstra.searchMinDistance(dijkstra.getVertex(params[0]), dijkstra.getVertex(params[1]));

                System.out.println("Минимальная стоимость из " + params[0] + " в " + params[1] + " составляет " + minCost);

            }

        }

    }

    private static String getTrim(BufferedReader br) {
        String param;
        try {
            param = br.readLine().trim();
        } catch (IOException e) {
            param = getTrim(br);
        }
        if (param.equalsIgnoreCase("")) {
            System.out.println("Пустая строка. Повторите ввод!");
            param = getTrim(br);
        }
        return param;
    }

    private static int getAnInt(BufferedReader br) {
        int n;
        try {
            n = Integer.valueOf(getTrim(br)).intValue();
        } catch (NumberFormatException e) {
            n = getAnInt(br);
        }
        if (n <= 0) {
            System.out.println("Введите число > 0");
            n = getAnInt(br);
        }
        return n;
    }

    static class City extends Dijkstra.Vertex {

        public City(String name) {
            super(name);

        }
    }
}








