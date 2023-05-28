import java.util.ArrayList;
import java.util.List;

/**
 * @author:- Paribartan Kalathoki
 * @created on:- 28 May, 2023 at 10:22 PM
 */
public class ListQueue {
    private List<Integer> elements;

    public ListQueue() {
        this.elements = new ArrayList<>();
    }

    public void enqueue(int element) {
        elements.add(element);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        return elements.remove(0);
    }

    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        return elements.get(0);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    public static void main(String[] args) {
     ListQueue listQueue = new ListQueue();

     listQueue.enqueue(10);
    }
}
