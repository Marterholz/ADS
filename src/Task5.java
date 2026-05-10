import java.util.*;

class Road {

    String city;
    int distance;

    public Road(String city, int distance) {
        this.city = city;
        this.distance = distance;
    }
}

public class Task5 {

    private final Map<String, List<Road>> roads = new HashMap<>();

    public Task5() {

        roads.put("Edinburgh", new ArrayList<>());
        roads.put("Glasgow", new ArrayList<>());
        roads.put("Stirling", new ArrayList<>());
        roads.put("Perth", new ArrayList<>());
        roads.put("Dundee", new ArrayList<>());

        connect("Glasgow", "Stirling", 50);
        connect("Glasgow", "Edinburgh", 70);
        connect("Stirling", "Perth", 40);
        connect("Stirling", "Edinburgh", 50);
        connect("Perth", "Edinburgh", 100);
        connect("Perth", "Dundee", 60);
    }

    private void connect(String from, String to, int weight) {

        roads.get(from).add(new Road(to, weight));
        roads.get(to).add(new Road(from, weight));
    }

    public void findShortestPath(String start, String end) {

        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();

        for (String city : roads.keySet()) {
            distances.put(city, Integer.MAX_VALUE);
        }

        distances.put(start, 0);

        PriorityQueue<Road> pq =
                new PriorityQueue<>(Comparator.comparingInt(r -> r.distance));

        pq.offer(new Road(start, 0));

        while (!pq.isEmpty()) {

            Road currentRoad = pq.poll();

            String currentCity = currentRoad.city;

            for (Road nextRoad : roads.get(currentCity)) {

                int newDistance =
                        distances.get(currentCity) + nextRoad.distance;

                if (newDistance < distances.get(nextRoad.city)) {

                    distances.put(nextRoad.city, newDistance);

                    previous.put(nextRoad.city, currentCity);

                    pq.offer(new Road(nextRoad.city, newDistance));
                }
            }
        }

        List<String> path = new ArrayList<>();

        String current = end;

        while (current != null) {

            path.add(current);

            current = previous.get(current);
        }

        Collections.reverse(path);

        for (String city : path) {
            System.out.print(city + " ");
        }

        System.out.println();
        System.out.println("Distance: " + distances.get(end));
    }
}
