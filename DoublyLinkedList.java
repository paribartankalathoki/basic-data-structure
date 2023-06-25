/**
 * @author:- Paribartan Kalathoki
 * @created on:- 22 Jun, 2023 at 5:32 AM
 *
 * Algorithm Behind the Implementation
 *
 * class DoublyLinkedList
 *     class Node
 *         data
 *         prev
 *         next
 *
 *     head
 *     tail
 *
 *     method insertAtBeginning(data)
 *         newNode = create Node with data
 *         if head is null
 *             set head and tail to newNode
 *         else
 *             set newNode's next reference to head
 *             set head's prev reference to newNode
 *             set head to newNode
 *
 *     method insertAtEnd(data)
 *         newNode = create Node with data
 *         if head is null
 *             set head and tail to newNode
 *         else
 *             set newNode's prev reference to tail
 *             set tail's next reference to newNode
 *             set tail to newNode
 *
 *     method delete(data)
 *         if head is null
 *             return
 *         if head's data is equal to data
 *             set head to head's next
 *             if head is not null
 *                 set head's prev reference to null
 *             else
 *                 set tail to null
 *             return
 *         current = head
 *         while current is not null and current's data is not equal to data
 *             set current to current's next
 *         if current is null
 *             return
 *         if current's next is not null
 *             set current's next's prev reference to current's prev
 *         else
 *             set tail to current's prev
 *         if current's prev is not null
 *             set current's prev's next reference to current's next
 *         else
 *             set head to current's next
 *
 *     method displayForward()
 *         current = head
 *         while current is not null
 *             print current's data
 *             set current to current's next
 *
 *     method displayBackward()
 *         current = tail
 *         while current is not null
 *             print current's data
 *             set current to current's prev
 *
 */
public class DoublyLinkedList {
    private Node head; // Reference to the first node in the doubly linked list
    private Node tail; // Reference to the last node in the doubly linked list

    // Nested Node class to represent the nodes in the doubly linked list
    private static class Node {
        int data; // Data stored in the node
        Node prev; // Reference to the previous node
        Node next; // Reference to the next node

        // Constructor to create a new node with the given data
        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Method to insert a new node at the beginning of the doubly linked list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data); // Create a new node
        if (head == null) {
            head = newNode;
            tail = newNode; // If the list is empty, make the new node as both the head and tail
        } else {
            newNode.next = head; // Set the next reference of the new node to the current head
            head.prev = newNode; // Set the previous reference of the current head to the new node
            head = newNode; // Update the head to point to the new node
        }
    }

    // Method to insert a new node at the end of the doubly linked list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data); // Create a new node
        if (head == null) {
            head = newNode;
            tail = newNode; // If the list is empty, make the new node as both the head and tail
        } else {
            newNode.prev = tail; // Set the previous reference of the new node to the current tail
            tail.next = newNode; // Set the next reference of the current tail to the new node
            tail = newNode; // Update the tail to point to the new node
        }
    }

    // Method to delete a node with the given data from the doubly linked list
    public void delete(int data) {
        if (head == null) {
            return; // If the list is empty, return
        }
        if (head.data == data) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // If the list becomes empty after deleting the head, update the tail as well
            }
            return;
        }
        Node current = head;
        while (current != null && current.data != data) {
            current = current.next; // Traverse to find the node to be deleted
        }
        if (current == null) {
            return; // If the node is not found, return
        }
        if (current.next != null) {
            current.next.prev = current.prev; // Set the previous reference of the next node to skip the current node
        } else {
            tail = current.prev; // If the node to be deleted is the tail, update the tail
        }
        if (current.prev != null) {
            current.prev.next = current.next; // Set the next reference of the previous node to skip the current node
        } else {
            head = current.next; // If the node to be deleted is the head, update the head
        }
    }

    // Method to display the elements of the doubly linked list in forward direction
    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to display the elements of the doubly linked list in backward direction
    public void displayBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
}
