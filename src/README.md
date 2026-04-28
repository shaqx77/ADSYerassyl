***

# **Assignment 3: Sorting and Searching Algorithm Analysis System**

## **A. Project Overview**
This project is an algorithm analysis system designed to implement and compare fundamental sorting and searching techniques. The primary goal is to measure and analyze performance using execution time in nanoseconds across different array sizes and structures.

## **B. Algorithm Descriptions**

### **1. Insertion Sort (Basic Sorting)**
* **Description**: A simple sorting algorithm that builds the final sorted array one item at a time by repeatedly taking the next element and inserting it into the correct position among those already sorted.
* **Complexity**: **$O(n^2)$** for average and worst cases.

### **2. Merge Sort (Advanced Sorting)**
* **Description**: An efficient, stable, divide-and-conquer algorithm that recursively divides the array into halves, sorts them, and merges them back together.
* **Complexity**: **$O(n \log n)$** for all cases.

### **3. Binary Search (Searching)**
* **Description**: An efficient search algorithm that finds the position of a target value within a **sorted** array by repeatedly dividing the search interval in half.
* **Complexity**: **$O(\log n)$**.

---

## **C. Experimental Results**
The following performance data was collected using `System.nanoTime()` on a Windows-based Java environment.

### **Sorting Performance (Execution Time in ns)**
| Array Size | Insertion Sort (ns) | Merge Sort (ns) |
| :--- | :--- | :--- |
| **Small (10)** | 7,000 | 7,300 |
| **Medium (100)** | 69,800 | 52,100 |
| **Large (1000)** | 2,532,400 | 164,000 |

### **Searching Performance (Binary Search)**
| Array Size | Execution Time (ns) |
| :--- | :--- |
| **Small (10)** | 3,100 |
| **Medium (100)** | 1,500 |
| **Large (1000)** | 1,900 |

---


## **D. Screenshots**
![img_1.png](img_1.png)
![img.png](img.png)
---

## **E. Reflection**
This assignment demonstrated that algorithm efficiency is the most critical factor in software performance. For small datasets, the difference between basic and advanced sorting is negligible, but for 1000+ elements, Merge Sort is nearly 15 times faster than Insertion Sort. I also improved my skills in object-oriented design by separating logic into `Sorter`, `Searcher`, and `Experiment` classes.