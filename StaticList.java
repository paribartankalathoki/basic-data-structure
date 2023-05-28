/**
 * @author:- Paribartan Kalathoki
 * @created on:- 28 May, 2023 at 10:01 PM
 */
public class StaticList {
    private int[] elements;
    private int size;
    private int capacity;

    public StaticList(int capacity) {
        this.elements = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public void add(int element) {
        if (size < capacity) {
            elements[size] = element;
            size++;
        } else {
            System.out.println("List is full. Cannot add more elements.");
        }
    }

    public void remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
        } else {
            System.out.println("Invalid index. Cannot remove element.");
        }
    }

    public int get(int index) {
        if (index >= 0 && index < size) {
            return elements[index];
        } else {
            System.out.println("Invalid index. Cannot get element.");
            return -1; // Or throw an exception or throw new IndexOutOfBoundsException();
        }
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        // Create a static list with a capacity of 5
        StaticList list = new StaticList(5);

        // Add elements to the list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        // Try adding more elements (exceeding the capacity)
        list.add(60);

        // Remove an element from the list
        list.remove(2);

        // Get an element from the list
        int element = list.get(1);
        System.out.println("Element at index 1: " + element);

        // Print the size and capacity of the list
        System.out.println("Size: " + list.getSize());
        System.out.println("Capacity: " + list.getCapacity());

        // Check if the list is empty or full
        System.out.println("Is empty: " + list.isEmpty());
        System.out.println("Is full: " + list.isFull());
    }
}
