import java.util.Random;

public class Experiment {
    public void runTraversals(Graph g, String sizeLabel, int startVertex) {
        System.out.println("\n==================================");
        System.out.println("--- Testing " + sizeLabel + " Graph ---");

        if (sizeLabel.contains("10")) {
            g.printGraph();
        }

        System.out.print("\nBFS: ");
        long startBfs = System.nanoTime();
        g.bfs(startVertex);
        long endBfs = System.nanoTime();

        System.out.print("\nDFS: ");
        long startDfs = System.nanoTime();
        g.dfs(startVertex);
        long endDfs = System.nanoTime();
        System.out.println();

        g.dijkstra(startVertex);

        printResults(sizeLabel, (endBfs - startBfs), (endDfs - startDfs));
    }

    public Graph createRandomGraph(int numVertices, int numEdges) {
        Graph g = new Graph();
        for (int i = 0; i < numVertices; i++) {
            g.addVertex(new Vertex(i));
        }

        Random rand = new Random();
        for (int i = 0; i < numEdges; i++) {
            int from = rand.nextInt(numVertices);
            int to = rand.nextInt(numVertices);
            int weight = rand.nextInt(20) + 1;
            g.addEdge(from, to, weight);
        }
        return g;
    }

    public void runMultipleTests() {
        runTraversals(createRandomGraph(10, 15), "Small (10 v)", 0);
        runTraversals(createRandomGraph(30, 60), "Medium (30 v)", 0);
        runTraversals(createRandomGraph(100, 300), "Large (100 v)", 0);
    }

    public void printResults(String size, long bfsTime, long dfsTime) {
        System.out.println("\nExecution Time for " + size + ":");
        System.out.println("BFS: " + bfsTime + " ns");
        System.out.println("DFS: " + dfsTime + " ns");
    }
}