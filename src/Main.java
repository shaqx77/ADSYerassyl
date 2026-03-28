import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Task 1: Digits of 5481");
        printDigits(5481);
        System.out.println();

        System.out.print("Task 2: Enter number of elements: ");
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Enter " + n2 + " numbers:");
        fillArray(sc, arr2, 0);
        System.out.println("Average: " + findAverage(arr2));


        System.out.print("Task 3: Enter number to check if prime: ");
        int n3 = sc.nextInt();
        System.out.println(isPrime(n3, 2));


        System.out.print("Task 4: Enter n for factorial: ");
        int n4 = sc.nextInt();
        System.out.println("Factorial: " + factorial(n4));


        System.out.print("Task 5: Enter n for Fibonacci: ");
        int n5 = sc.nextInt();
        System.out.println("Fibonacci: " + fibonacci(n5));


        System.out.print("Task 6: Enter base (a) and exponent (n): ");
        int a6 = sc.nextInt();
        int n6 = sc.nextInt();
        System.out.println("Result: " + power(a6, n6));


        System.out.print("Task 7: Enter n and then numbers: ");
        int n7 = sc.nextInt();
        reverseOutput(sc, n7);
        System.out.println();


        System.out.print("Task 8: Enter string: ");
        String s8 = sc.next();
        System.out.println("Only digits: " + isAllDigits(s8));


        System.out.print("Task 9: Enter string: ");
        String s9 = sc.next();
        System.out.println("Count: " + countChars(s9));

        // Task 10
        System.out.print("Task 10: Enter two numbers: ");
        int a10 = sc.nextInt();
        int b10 = sc.nextInt();
        System.out.println("GCD: " + gcd(a10, b10));

        sc.close();
    }


    public static void printDigits(int n) {
        if (n < 10) {
            System.out.println(n);
            return;
        }
        printDigits(n / 10);
        System.out.println(n % 10);
    }


    public static double findSum(int[] arr, int n) {
        if (n <= 0) return 0;
        return findSum(arr, n - 1) + arr[n - 1];
    }
    public static double findAverage(int[] arr) {
        if (arr.length == 0) return 0;
        return findSum(arr, arr.length) / arr.length;
    }
    public static void fillArray(Scanner sc, int[] arr, int i) {
        if (i == arr.length) return;
        arr[i] = sc.nextInt();
        fillArray(sc, arr, i + 1);
    }


    public static String isPrime(int n, int divisor) {
        if (n <= 2) return (n == 2) ? "Prime" : "Composite";
        if (n % divisor == 0) return "Composite";
        if (divisor * divisor > n) return "Prime";
        return isPrime(n, divisor + 1);
    }


    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }


    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    public static int power(int a, int n) {
        if (n == 0) return 1;
        return a * power(a, n - 1);
    }


    public static void reverseOutput(Scanner sc, int n) {
        if (n == 0) return;
        int num = sc.nextInt();
        reverseOutput(sc, n - 1);
        System.out.print(num + " ");
    }


    public static String isAllDigits(String s) {
        if (s.isEmpty()) return "Yes";
        if (!Character.isDigit(s.charAt(0))) return "No";
        return isAllDigits(s.substring(1));
    }


    public static int countChars(String s) {
        if (s.isEmpty()) return 0;
        return 1 + countChars(s.substring(1));
    }


    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}