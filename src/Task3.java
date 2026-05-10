import java.util.*;

public class Task3 {

    private final Map<String, List<String>> graph = new HashMap<>();

    public Task3() {

        graph.put("A", Arrays.asList("C", "B", "D"));
        graph.put("B", Arrays.asList("A", "C", "E", "G"));
        graph.put("C", Arrays.asList("A", "B", "D"));
        graph.put("D", Arrays.asList("C", "A"));
        graph.put("E", Arrays.asList("G", "F", "B"));
        graph.put("F", Arrays.asList("G", "E"));
        graph.put("G", Arrays.asList("F", "B"));
    }

    public void runDFS(String start) {

        Set<String> visited = new HashSet<>();

        dfs(start, visited);

        System.out.println();
    }

    private void dfs(String current, Set<String> visited) {

        visited.add(current);

        System.out.print(current + " ");

        List<String> neighbors = graph.get(current);

        for (String next : neighbors) {

            if (!visited.contains(next)) {
                dfs(next, visited);
            }
        }
    }

    public void runBFS(String start) {

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {

            String current = queue.poll();

            System.out.print(current + " ");

            List<String> neighbors = graph.get(current);

            for (String next : neighbors) {

                if (!visited.contains(next)) {

                    visited.add(next);
                    queue.offer(next);
                }
            }
        }

        System.out.println();
    }
}
