package technicalTest.bgc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class to determine whether two cities are connected in a given graph.
 *
 * @author Elvis Leung
 * @date 27 June 2020
 */
@SuppressWarnings("unchecked")
public class Connected<T> {
    private final T start;
    private final T end;
    private final Map<T, List<T>> map;
    private final Map<T, Boolean> visited;

    Connected(final T start, final T end) {
        this.start = start;
        this.end = end;
        map = new HashMap<>();
        visited = new HashMap<>();
    }

    /**
     * Construct a map of adjacent cities from the given cities pairs txt file.
     *
     * @param path
     */
    public void buildConnectedMap(final String path) {
        BufferedReader reader;
        try {
            reader = new BufferedReader((new FileReader(path)));
            String line;

            while ((line = reader.readLine()) != null) {
                T[] cities = tokenize(line);
                T cityA = cities[0];
                T cityB = cities[1];

                // Undirected graph
                // A -> B
                if (!map.containsKey(cityA)) {
                    List list = new ArrayList<>();
                    list.add(cityB);
                    map.put(cityA, list);
                } else
                    map.get(cityA).add(cityB);

                // B -> A
                if (!map.containsKey(cityB)) {
                    List list = new ArrayList<>();
                    list.add(cityA);
                    map.put(cityB, list);
                } else
                    map.get(cityB).add(cityA);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check whether the starting city is connected to the ending city.
     *
     * @return boolean
     */
    public boolean isConnected() {
        return canReachFrom(start);
    }

    private T[] tokenize(final String line) {
        String[] tokens = line.split(",");
        tokens[0] = tokens[0].trim();
        tokens[1] = tokens[1].trim();
        return (T[]) tokens;
    }

    private boolean canReachFrom(final T start) {
        List<T> adjacent = map.get(start);

        if (adjacent == null || adjacent.size() == 0)
            return false;

        for (int i = 0; i < adjacent.size(); i++) {
            T adj = adjacent.get(i);

            if (end.equals(adj))
                return true;
            else if (!visited.containsKey(adj)) {
                visited.put(adj, true);
                if (canReachFrom(adj))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String path = args[0];
        String startCity = args[1];
        String endCity = args[2];

        Connected<String> connected = new Connected<>(startCity, endCity);
        connected.buildConnectedMap(path);

        System.out.println(connected.isConnected() == true ? "yes" : "no");
    }
}
