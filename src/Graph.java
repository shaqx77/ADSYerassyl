import java.util.*;

public class Graph {
    private final Map<Integer, List<Edge>> adjList;
    private final Map<Integer, Vertex> vertices;

    public Graph() {
        this.adjList = new HashMap<>();
        this.vertices = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        vertices.put(v.getId(), v);
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        if (adjList.containsKey(from) && adjList.containsKey(to)) {
            adjList.get(from).add(new Edge(from, to));
        }
    }

    public void printGraph() {
        for (int id : adjList.keySet()) {
            System.out.print("Vertex " + id + " connected to: ");
            for (Edge edge : adjList.get(id)) {
                System.out.print(edge.getDestination() + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int start) {
        if (!adjList.containsKey(start)) return;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (Edge edge : adjList.getOrDefault(vertex, new ArrayList<>())) {
                if (!visited.contains(edge.getDestination())) {
                    visited.add(edge.getDestination());
                    queue.add(edge.getDestination());
                }
            }
        }
    }

    public void dfs(int start) {
        if (!adjList.containsKey(start)) return;
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(start, visited);
    }

    private void dfsRecursive(int current, Set<Integer> visited) {
        visited.add(current);
        System.out.print(current + " ");

        for (Edge edge : adjList.getOrDefault(current, new ArrayList<>())) {
            if (!visited.contains(edge.getDestination())) {
                dfsRecursive(edge.getDestination(), visited);
            }
        }
    }
}