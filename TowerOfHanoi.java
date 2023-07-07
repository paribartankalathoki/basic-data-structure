import java.util.Stack;

/**
 * @author:- Paribartan Kalathoki
 * @created on:- 06 Jul, 2023 at 10:41 PM
 */
public class TowerOfHanoi {

    /**
     * Desc: Using simple technique (iterative solution)
     *
     * @param numDisks
     * @param source
     * @param auxiliary
     * @param destination
     */
    static void towerOfHanoi(int numDisks, char source, char auxiliary, char destination) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        int totalMoves = (int) (Math.pow(2, numDisks) - 1);

        // Initialize source stack with disks in decreasing order
        for (int i = numDisks; i >= 1; i--) {
            stack1.push(i);
        }

        char temp;

        // If the number of disks is even, swap the auxiliary and destination pegs
        if (numDisks % 2 == 0) {
            temp = auxiliary;
            auxiliary = destination;
            destination = temp;
        }

        for (int move = 1; move <= totalMoves; move++) {
            if (move % 3 == 1) {
                moveDisk(stack1, stack3, source, destination);
            } else if (move % 3 == 2) {
                moveDisk(stack1, stack2, source, auxiliary);
            } else if (move % 3 == 0) {
                moveDisk(stack2, stack3, auxiliary, destination);
            }
        }
    }

    static void moveDisk(Stack<Integer> sourceStack, Stack<Integer> destinationStack, char source, char destination) {
        int disk = sourceStack.pop();
        destinationStack.push(disk);
        System.out.println("Move disk " + disk + " from " + source + " to " + destination);
    }


    /**
     * Desc: using recursive function
     *
     * @param numDisks
     * @param source
     * @param auxiliary
     * @param destination
     */
    static void towerOfHanoiUsingRecursiveFunction(int numDisks, char source, char auxiliary, char destination) {
        if (numDisks == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        towerOfHanoiUsingRecursiveFunction(numDisks - 1, source, destination, auxiliary);
        System.out.println("Move disk " + numDisks + " from " + source + " to " + destination);
        towerOfHanoiUsingRecursiveFunction(numDisks - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        int numDisks = 3;
        char source = 'A';
        char auxiliary = 'B';
        char destination = 'C';

        towerOfHanoi(numDisks, source, auxiliary, destination);
        towerOfHanoiUsingRecursiveFunction(numDisks, source, auxiliary, destination);
    }

}
