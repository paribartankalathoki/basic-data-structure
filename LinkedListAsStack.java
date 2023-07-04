import java.util.Stack;

/**
 * @author:- Paribartan Kalathoki
 * @created on:- 29 Jun, 2023 at 10:29 PM
 */

class Nodes {

    int data;
    Nodes next;

    // Constructor to create a new node
    Nodes(int data) {
        this.data = data;
        this.next = null;
    }

}

class LinkedListUsingStack {
    Stack<Nodes> stack;

    // Constructor to initialize the stack
    LinkedListUsingStack() {
        stack = new Stack<>();
    }

    // Method to insert a new node at the beginning of the linked list
    void insertAtBeginning(int data) {
        Nodes newNode = new Nodes(data);
        if (stack.isEmpty()) {
            newNode.next = null;
        } else {
            newNode.next = stack.peek();
        }
        stack.push(newNode);
    }

    // Method to delete the first node of the linked list
    void deleteAtBeginning() {
        if (stack.isEmpty()) {
            System.out.println("Linked list is empty. Cannot delete.");
        } else {
            stack.pop();
        }
    }

    // Method to display the elements of the linked list
    void display() {
        if (stack.isEmpty()) {
            System.out.println("Linked list is empty.");
        } else {
            System.out.println("Elements of the linked list:");
            for (Nodes node : stack) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }
}

public class LinkedListAsStack {
    public static void main(String[] args) {
        LinkedListUsingStack linkedList = new LinkedListUsingStack();

        // Insert nodes at the beginning of the linked list
        linkedList.insertAtBeginning(5);
        linkedList.insertAtBeginning(10);
        linkedList.insertAtBeginning(15);

        // Display the elements of the linked list
        linkedList.display();

        // Delete the first node of the linked list
        linkedList.deleteAtBeginning();

        // Display the elements of the linked list
        linkedList.display();
    }
}
