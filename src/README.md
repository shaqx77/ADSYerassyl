# Assignment 1: Recursion
### Name: Altynbayev Yerassyl
### Group: IT-2504

Work Process Summary
In this assignment, I implemented 10 recursive functions in Java without using any loops (for, while).
Each solution focuses on a base case to stop recursion and a recursive step to solve the problem.
---
Part 1: Numbers
Task 1: Print Digits
Output check:
[Task 1 Screen](../screens/task1.png)

Task 2: Average of Elements
Output check:
[Task 2 Screen](../screens/task2.png)

Task 3: Prime Number Check
Output check:
[Task 3 Screen](../screens/task3.png)

Task 4: Factorial
Output check:
![Task 4 Screen](../screens/task4.png)
---
Part 2: Sequences

Task 5: Fibonacci Number
Output check:
![Task 5 Screen](../screens/task5.png)

Task 6: Power Function
Output check:
![Task 6 Screen](../screens/task6.png)

Task 7: Reverse Output
Output check:
![Task 7 Screen](../screens/task7.png)
---
Part 3: Strings and GCD

Task 8: Check Digits in String
Output check:
![Task 8 Screen](../screens/task8.png)

Task 9: Count Characters
Output check:
![Task 9 Screen](../screens/task9.png)

Task 10: Greatest Common Divisor
Output check:
![Task 10 Screen](../screens/task10.png)

## Part 1: Numbers

### Task 1: Print Digits of a Number
**Description:** A function that receives an integer and prints its digits one by one on new lines.
* **Logic:** The function calls itself with n / 10 to reach the most significant digit first. The print statement is placed after the recursive call so that digits are displayed in the correct order as the stack unwinds.

### Task 2: Average of Elements
**Description:** Calculates the mean value of elements in an array.
* **Logic:** One recursive method fills the array, while another calculates the total sum by adding the current index element to the sum of the rest. The final result is the total sum divided by the array length.

### Task 3: Prime Number Check
**Description:** Determines if a positive integer is a prime number.
* **Logic:** A helper function checks for divisors starting from 2. It recursively increments the divisor; if it reaches the number without finding a divisor, the number is Prime.

### Task 4: Factorial
**Description:** Computes the factorial of $n$.
* **Logic:** Uses the standard recurrence $n \times (n-1)!$ with the base case where $1! = 1$.

---

##  Part 2: Sequences

### Task 5: Fibonacci Number
**Description:** Returns the $n$-th element of the Fibonacci sequence.
* **Logic:** Implemented by summing the results of two recursive calls: $F(n-1) + F(n-2)$.

### Task 6: Power Function
**Description:** Calculates $a$ raised to the power of $n$ ($a^n$).
* **Logic:** The base $a$ is multiplied by the result of the function with the exponent reduced by 1 until the exponent hits 0.

### Task 7: Reverse Output
**Description:** Reads $n$ integers and prints them in reverse order.
* **Logic:** The program reads a number and immediately calls itself. The System.out.println is executed only after the recursive call returns, utilizing the LIFO (Last-In-First-Out) nature of the stack.

---

##  Part 3: Strings and GCD

### Task 8: Check Digits in String
**Description:** Validates if a string contains only numeric characters.
* **Logic:** The function checks the character at the current index. If it's a digit, it moves to the next; otherwise, it returns "No".

### Task 9: Count Characters
**Description:** Returns the total length of a string.
* **Logic:** Calculated as $1 + \text{length}$ of the remaining substring. The base case is an empty string (length 0).

### Task 10: Greatest Common Divisor
**Description:** Finds the GCD using the Euclidean Algorithm.
* **Logic:** The function recursively calls itself with (b, a % b) until the second parameter becomes 0.
