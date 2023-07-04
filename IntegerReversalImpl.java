/**
 * @author:- Paribartan Kalathoki
 * @created on:- 04 Jul, 2023 at 10:20 PM
 */
public class IntegerReversalImpl {

    // Recursive method to reverse an integer
    public static int reverseRecursive(int num) {
        if (num < 10) {
            return num; // Base case: single-digit number, its reverse is the number itself
        } else {
            int lastDigit = num % 10;
            int remainingNum = num / 10;
            int reversedNum = reverseRecursive(remainingNum);
            return Integer.parseInt(reversedNum + "" + lastDigit);
        }
    }

    // Iterative method to reverse an integer
    public static int reverseIterative(int number) {
        int reversedNumber = 0;

        while (number != 0) {
            int lastDigit = number % 10;
            reversedNumber = (reversedNumber * 10) + lastDigit;
            number /= 10;
        }

        return reversedNumber;
    }

    public static void main(String[] args) {
        int number = 12345;

        // Reverse using recursive method
        int reversedRecursive = reverseRecursive(number);
        System.out.println("Reversed number (Recursive): " + reversedRecursive);

        // Reverse using iterative method
        int reversedIterative = reverseIterative(number);
        System.out.println("Reversed number (Iterative): " + reversedIterative);
    }
}
