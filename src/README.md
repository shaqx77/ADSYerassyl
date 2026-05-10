# Assignment 4: Graph Traversal and Representation System

---

##  A. Project Overview

This project implements a comprehensive graph management system in Java, focusing on fundamental data structures and traversal algorithms.

* **Graph Structure**: A mathematical structure used to model pairwise relations between objects.
* **Vertices and Edges**: The graph consists of **Vertices** (nodes representing data points) and **Edges** (connections representing the relationships).
* **Traversal Overview**: The system implements two primary methods for exploring these structures: **Breadth-First Search (BFS)** and **Depth-First Search (DFS)**.

---

##  B. Class Descriptions

The project follows a modular Object-Oriented Programming (OOP) design:

* **Vertex**: Represents a node with a unique integer `id`.
* **Edge**: Represents a directed connection between a `source` and a `destination` vertex.
* **Graph**: The core class that manages the structure using an **Adjacency List**.
* **Adjacency List Representation**: This representation stores a list of neighbors for each vertex using a `Map<Integer, List<Edge>>`. It is efficient for sparse graphs and allows $O(1)$ access to a vertex's neighbors.

---

## ️ C. Algorithm Descriptions

### 1. Breadth-First Search (BFS)

* **Step-by-Step**:
    1. Start from a source vertex and mark it as visited.
    2. Add the source vertex to a **Queue**.
    3. While the queue is not empty, dequeue a vertex and visit all its unvisited neighbors.
    4. Mark neighbors as visited and enqueue them.

* **Use Cases**: Finding the shortest path in unweighted graphs and peer-to-peer networks.

* **Time Complexity**: $O(V + E)$, where $V$ is vertices and $E$ is edges.

### 2. Depth-First Search (DFS)

* **Step-by-Step**:
    1. Start from a source vertex and mark it as visited.
    2. Recursively (or using a stack) visit an unvisited neighbor of the current vertex.
    3. Continue moving as deep as possible along each branch before backtracking.

* **Use Cases**: Topological sorting, detecting cycles, and solving puzzles like mazes.

* **Time Complexity**: $O(V + E)$.

---

##  D. Experimental Results

Performance was evaluated by measuring execution time in nanoseconds using `System.nanoTime()`.

### Execution Time Comparison:

| Graph Size | BFS Time (ns) | DFS Time (ns) |
| :--- |:--------------|:--------------|
| **10 Vertices (Small)** | 1096000       | 131700        |
| **30 Vertices (Medium)** | 454600              | 283800        |
| **100 Vertices (Large)** | 519800       | 533500              |

**Observations**:
* As the number of vertices increases, the execution time grows linearly, confirming $O(V+E)$ complexity.
* DFS typically shows lower overhead in smaller graphs compared to Queue management in BFS.

---

##  E. Screenshots

* **Graph Structure Output**: ![img_5.png](img_5.png)
* **BFS Traversal Output**: ![img_1.png](img_1.png)
* **DFS Traversal Output**: ![img_3.png](img_3.png)
* **Performance Results**: ![img_4.png](img_4.png)

---

##  F. Reflection Section

During this assignment, I learned how abstract graph concepts are translated into concrete data structures like adjacency lists. Implementing both BFS and DFS highlighted their fundamental differences: BFS explores level-by-level using a queue, while DFS explores path-by-path using recursion.

The primary challenge was ensuring the `Edge` class was properly integrated within the `Graph` class's adjacency list while maintaining clean code. Observing the real-world performance confirmed the practical application of Big-O notation.

***