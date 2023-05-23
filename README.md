# Basic Data Structure Implementation:

## Linear Queue Implementation Explanation

``` 
In this implementation, we use an array queueArray to store the elements, and front and rear indices to keep track of the front and rear positions of the queue. The currentSize variable keeps track of the number of elements currently in the queue.

The circular increment of the front and rear indices allows the queue to wrap around when it reaches the end of the array, enabling efficient space utilization. The % operator is used to ensure the indices stay within the valid range.

The enqueue() method adds an element to the rear of the queue, the dequeue() method removes and returns the element from the front, and the peek() method retrieves the front element without removing it. The isEmpty() and isFull() methods check if the queue is empty or full, respectively.

The display() method prints the elements of the queue.

In the main() method, we create an instance of LinearQueue, enqueue some elements, dequeue an element, display the queue, and peek at the front element for demonstration purposes.

Feel free to modify the implementation or add additional functionality as per your requirements.

```
