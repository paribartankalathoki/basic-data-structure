/**
 * @author:- Paribartan Kalathoki
 * @created on:- 22 Jun, 2023 at 5:38 AM
 *
 * Algorithm behind the implementation
 *
 * class Node
 *     data
 *     next
 *
 * class CircularLinkedList
 *     head
 *
 *     method insertAtBeginning(data)
 *         newNode = create Node with data
 *         if head is null
 *             set head to newNode
 *             set newNode's next reference to head
 *         else
 *             set newNode's next reference to head
 *             set last to head
 *             while last's next is not equal to head
 *                 set last to last's next
 *             set last's next to newNode
 *             set head to newNode
 *
 *     method insertAtEnd(data)
 *         newNode = create Node with data
 *         if head is null
 *             set head to newNode
 *             set newNode's next reference to head
 *         else
 *             set last to head
 *             while last's next is not equal to head
 *                 set last to last's next
 *             set last's next to newNode
 *             set newNode's next reference to head
 *
 *     method delete(data)
 *         if head is null
 *             return
 *         set curr to head
 *         set prev to null
 *         while curr's data is not equal to data
 *             if curr's next is equal to head
 *                 return
 *             set prev to curr
 *             set curr to curr's next
 *         if curr is equal to head
 *             set last to head
 *             while last's next is not equal to head
 *                 set last to last's next
 *             set last's next to head's next
 *             set head to head's next
 *         else
 *             set prev's next to curr's next
 *
 *     method display()
 *         if head is null
 *             print "Circular linked list is empty."
 *             return
 *         set temp to head
 *         loop
 *             print temp's data
 *             set temp to temp's next
 *         until temp is equal to head
 *
 */
class Node {
    int data;
    Node next;

    // Constructor to create a new node
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;

    // Method to insert a new node at the beginning of the circular linked list
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            // If the list is empty, make the new node as the head
            head = newNode;
            newNode.next = head;
        } else {
            // If the list is not empty, find the last node and update the next references
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    // Method to insert a new node at the end of the circular linked list
    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            // If the list is empty, make the new node as the head
            head = newNode;
            newNode.next = head;
        } else {
            // If the list is not empty, find the last node and update the next references
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = newNode;
            newNode.next = head;
        }
    }

    // Method to delete a node with the given data from the circular linked list
    void delete(int data) {
        if (head == null) {
            // If the list is empty, return
            return;
        }
        Node curr = head, prev = null;
        while (curr.data != data) {
            if (curr.next == head) {
                // If the entire list has been traversed and the data is not found, return
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        if (curr == head) {
            // If the node to be deleted is the head node, update the next references
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = head.next;
            head = head.next;
        } else {
            // If the node to be deleted is not the head node, update the next references
            prev.next = curr.next;
        }
    }

    // Method to display the elements of the circular linked list
    void display() {
        if (head == null) {
            // If the list is empty, print a message
            System.out.println("Circular linked list is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}

public class CircularLinkedListImpl {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        // Insert nodes at the beginning of the list
        list.insertAtBeginning(5);
        list.insertAtBeginning(10);
        list.insertAtBeginning(15);

        // Insert nodes at the end of the list
        list.insertAtEnd(20);
        list.insertAtEnd(25);

        // Delete a node from the list
        list.delete(10);

        // Display the elements of the list
        list.display();
    }
}
