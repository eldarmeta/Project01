
import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        // Example graph represented as an adjacency list
        int numVertices = 6;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges to the graph
        adjList.get(5).add(2);
        adjList.get(5).add(0);
        adjList.get(4).add(0);
        adjList.get(4).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(1);

        // Perform topological sort
        List<Integer> topoOrder = topologicalSort(numVertices, adjList);

        // Print the topological order
        System.out.println("Topological Sort:");
        for (int node : topoOrder) {
            System.out.print(node + " ");
        }
    }

    public static List<Integer> topologicalSort(int numVertices, List<List<Integer>> adjList) {
        int[] inDegree = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int neighbor : adjList.get(i)) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numVertices; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);

            for (int neighbor : adjList.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (topoOrder.size() != numVertices) {
            throw new RuntimeException("Graph has a cycle, topological sort not possible.");
        }

        return topoOrder;
    }
}
