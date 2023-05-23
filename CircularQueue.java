public class CircularQueue {
    private int maxSize;       // maximum size of the circular queue
    private int[] queueArray;  // array to store elements
    private int front;         // index of the front element
    private int rear;          // index of the rear element
    private int currentSize;   // current number of elements in the queue

    // Constructor to initialize the circular queue
    public CircularQueue(int size) {
        maxSize = size + 1;   // Increase size by 1 to account for the circular nature
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    // Method to check if the circular queue is empty
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Method to check if the circular queue is full
    public boolean isFull() {
        return currentSize == maxSize - 1;
    }

    // Method to enqueue an element
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Circular queue is full. Cannot enqueue element.");
            return;
        }

        rear = (rear + 1) % maxSize; // Circularly increment rear index
        queueArray[rear] = data;
        currentSize++;
        System.out.println(data + " enqueued to the circular queue.");
    }

    // Method to dequeue an element
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Circular queue is empty. Cannot dequeue element.");
            return -1;
        }

        int dequeuedElement = queueArray[front];
        front = (front + 1) % maxSize; // Circularly increment front index
        currentSize--;
        System.out.println(dequeuedElement + " dequeued from the circular queue.");
        return dequeuedElement;
    }

    // Method to get the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Circular queue is empty.");
            return -1;
        }

        return queueArray[front];
    }

    // Method to display the elements of the circular queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Circular queue is empty.");
            return;
        }

        System.out.print("Circular Queue: ");
        int count = 0;
        int i = front;
        while (count < currentSize) {
            System.out.print(queueArray[i] + " ");
            i = (i + 1) % maxSize; // Circularly traverse the array
            count++;
        }
        System.out.println();
    }

    // Test the implementation
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display(); // Output: Circular Queue: 10 20 30

        queue.dequeue();
        queue.display(); // Output: Circular Queue: 20 30

        System.out.println("Front element: " + queue.peek()); // Output: Front element: 20
    }
}
