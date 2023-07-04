/**
 * @author:- Paribartan Kalathoki
 * @created on:- 04 Jul, 2023 at 10:22 PM
 */
public class FibonacciSeries {

    public static int fibonacciRecursive(int n) {
        // Base cases: fibonacci(0) = 0, fibonacci(1) = 1
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            // Recursive case: fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci Series (Recursive):");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }
    }

}
