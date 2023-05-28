public class LinearQueue {
    private int maxSize;     // maximum size of the queue
    private int[] queueArray; // array to store elements
    private int front;       // index of the front element
    private int rear;        // index of the rear element
    private int currentSize; // current number of elements in the queue

    // Constructor to initialize the queue
    public LinearQueue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return currentSize == maxSize;
    }

    // Method to enqueue an element
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue element.");
            return;
        }

        rear = (rear + 1) % maxSize; // Circularly increment rear index
        queueArray[rear] = data;
        currentSize++;
        System.out.println(data + " enqueued to the queue.");
    }

    // Method to dequeue an element
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1;
        }

        int dequeuedElement = queueArray[front];
        front = (front + 1) % maxSize; // Circularly increment front index
        currentSize--;
        System.out.println(dequeuedElement + " dequeued from the queue.");
        return dequeuedElement;
    }

    // Method to get the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }

        return queueArray[front];
    }

    // Method to display the elements of the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue: ");
        for (int i = 0; i < currentSize; i++) {
            int index = (front + i) % maxSize; // Circularly traverse the array
            System.out.print(queueArray[index] + " ");
        }
        System.out.println();
    }

    // Test the implementation
    public static void main(String[] args) {
        LinearQueue queue = new LinearQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(60);
		
        queue.display(); // Output: Queue: 10 20 30 40

        queue.dequeue();
        queue.display(); // Output: Queue: 20 30 40

        System.out.println("Front element: " + queue.peek()); // Output: Front element: 20
    }
}
