/**
 * @author:- Paribartan Kalathoki
 * @created on:- 06 Jul, 2023 at 10:30 PM
 */
public class PrimeNumberChecker {

    public static boolean isPrimeRecursive(int n, int divisor) {
        // Base cases:
        // If the number is less than 2, it is not prime
        if (n < 2) {
            return false;
        }
        // If the divisor becomes equal to n, the number is prime
        if (divisor == n) {
            return true;
        }
        // If the number is divisible by the current divisor, it is not prime
        if (n % divisor == 0) {
            return false;
        }

        // Recursive case: check divisibility with the next divisor
        return isPrimeRecursive(n, divisor + 1);
    }


    public static boolean isPrime(int number) {
        // Check if the number is less than 2
        if (number < 2) {
            return false;
        }

        // Check for divisibility from 2 to the square root of the number
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int number = 29;

        /**
         * using normal iterative solution.
         */

        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

        /**
         * using recursive function
         */

        if (isPrimeRecursive(number, number - 1)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }

}
