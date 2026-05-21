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

    public void addEdge(int from, int to, int weight) {
        if (adjList.containsKey(from) && adjList.containsKey(to)) {
            adjList.get(from).add(new Edge(from, to, weight));
        }
    }

    public void printGraph() {
        for (int id : adjList.keySet()) {
            System.out.print("Vertex " + id + " connected to: ");
            for (Edge edge : adjList.get(id)) {
                System.out.print("[" + edge.getDestination() + "|w:" + edge.getWeight() + "] ");
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

    public void dijkstra(int start) {
        if (!vertices.containsKey(start)) {
            System.out.println("Starting vertex not found in graph.");
            return;
        }

        int maxId = 0;
        for (int id : vertices.keySet()) {
            if (id > maxId) {
                maxId = id;
            }
        }

        int[] distances = new int[maxId + 1];
        boolean[] visited = new boolean[maxId + 1];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        for (int i = 0; i < vertices.size(); i++) {
            int currentVertex = -1;
            int minDistance = Integer.MAX_VALUE;

            for (int v : vertices.keySet()) {
                if (!visited[v] && distances[v] < minDistance) {
                    minDistance = distances[v];
                    currentVertex = v;
                }
            }

            if (currentVertex == -1) {
                break;
            }

            visited[currentVertex] = true;

            for (Edge edge : adjList.getOrDefault(currentVertex, new ArrayList<>())) {
                int neighbor = edge.getDestination();
                if (!visited[neighbor] && distances[currentVertex] != Integer.MAX_VALUE) {
                    int newDist = distances[currentVertex] + edge.getWeight();
                    if (newDist < distances[neighbor]) {
                        distances[neighbor] = newDist;
                    }
                }
            }
        }

        System.out.println("\n--- Dijkstra's Shortest Paths from Vertex " + start + " ---");
        for (int v : vertices.keySet()) {
            if (distances[v] == Integer.MAX_VALUE) {
                System.out.println("To Vertex " + v + " -> Unreachable");
            } else {
                System.out.println("To Vertex " + v + " -> Total Distance: " + distances[v]);
            }
        }
    }
}