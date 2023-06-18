/**
 * @author:- Paribartan Kalathoki
 * @created on:- 18 Jun, 2023 at 9:49 PM
 */

public class LinkedList {
    private Node head; // Reference to the first node in the linked list

    // Method to insert a new node at the beginning of the linked list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data); // Create a new node
        newNode.next = head; // Set the next reference of the new node to the current head
        head = newNode; // Update the head to point to the new node
    }

    // Method to insert a new node at the end of the linked list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data); // Create a new node
        if (head == null) {
            head = newNode; // If the list is empty, make the new node as the head
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next; // Traverse to the last node
            }
            current.next = newNode; // Set the next reference of the last node to the new node
        }
    }

    /**
     * Method to delete data from the linkedList
     * @param data
     *
     * Explain:
     * The delete method is used to delete a node with the given data from the linked list.
     * If the list is empty (head == null), there is nothing to delete, so the method returns.
     * If the node to be deleted is the head node (head.data == data), we update the head reference to point to the next node, effectively removing the head node from the list.
     * If the node to be deleted is not the head node, we traverse the linked list using two pointers: current and previous.
     * The current pointer is used to iterate through the list until either the end of the list is reached (current == null) or the node with the given data is found (current.data == data).
     * The previous pointer keeps track of the previous node while traversing.
     * If the node with the given data is found (current != null), we update the next reference of the previous node to skip the current node. This effectively removes the current node from the list.
     * If the node with the given data is not found (current == null), it means the data doesn't exist in the list, so no deletion is performed.
     * Note that the deletion operation only removes the first occurrence of the node with the given data. If there are multiple nodes with the same data, only the first one encountered will be deleted.
     *
     */

    // Method to delete a node with the given data from the linked list
    public void delete(int data) {
        if (head == null) {
            return; // If the list is empty, return
        }
        if (head.data == data) {
            head = head.next; // If the node to be deleted is the head, update the head
            return;
        }
        Node current = head;
        Node previous = null;
        while (current != null && current.data != data) {
            previous = current;
            current = current.next; // Traverse to find the node to be deleted
        }
        if (current == null) {
            return; // If the node is not found, return
        }
        previous.next = current.next; // Update the next reference of the previous node to skip the current node
    }

    // Method to display the elements of the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next; // Traverse and print each node's data
        }
        System.out.println();
    }

    // Nested Node class to represent the nodes in the linked list
    private static class Node {
        int data; // Data stored in the node
        Node next; // Reference to the next node

        // Constructor to create a new node with the given data
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertAtBeginning(10);

        linkedList.display();

    }
}

