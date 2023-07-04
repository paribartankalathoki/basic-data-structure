/**
 * @author:- Paribartan Kalathoki
 * @created on:- 04 Jul, 2023 at 10:14 PM
 */
public class FactorialOfNumber {

    /**
     * Desc: using recursive function
     *
     * @param n
     * @return
     */
    public static int factorialRecursive(int n) {
        // Base case: factorial of 0 or 1 is 1
        if (n == 0 || n == 1) {
            return 1;
        }

        // Recursive case: multiply n with factorial of (n-1)
        return n * factorialRecursive(n - 1);
    }

    /**
     * Desc: Using normal iteration
     *
     * @param n
     * @return
     */
    public static int factorialIterative(int n) {
        int factorial = 1;

        // Multiply numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        return factorial;
    }


    public static void main(String[] args) {

        System.out.println(factorialRecursive(5)); // using recursive call stack

        System.out.println(factorialIterative(5)); // using normal iterative call
    }
}
