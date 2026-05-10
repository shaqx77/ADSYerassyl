import java.util.Random;

public class Experiment {
    public void runTraversals(Graph g, String sizeLabel, int startVertex) {
        System.out.println("\n--- Testing " + sizeLabel + " Graph ---");

        if (sizeLabel.contains("10")) {
            g.printGraph();
        }

        System.out.print("BFS: ");
        long startBfs = System.nanoTime();
        g.bfs(startVertex);
        long endBfs = System.nanoTime();
        System.out.println();

        System.out.print("DFS: ");
        long startDfs = System.nanoTime();
        g.dfs(startVertex);
        long endDfs = System.nanoTime();
        System.out.println();

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
            g.addEdge(from, to);
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
        System.out.println("---------------------------------");
    }
}