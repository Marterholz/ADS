public class Main {

    public static void main(String[] args) {

        Task3 task3 = new Task3();

        System.out.println("DFS:");
        task3.runDFS("A");

        System.out.println();

        System.out.println("BFS:");
        task3.runBFS("A");

        System.out.println();

        Task5 task5 = new Task5();

        System.out.println("Shortest path:");
        task5.findShortestPath("Edinburgh", "Dundee");
    }
}
