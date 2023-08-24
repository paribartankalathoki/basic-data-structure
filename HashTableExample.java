/**
 * @author:- Paribartan Kalathoki
 * @created on:- 22 Aug, 2023 at 09:52 PM
 */

import java.util.LinkedList;

class KeyValuePair {
    String key;
    int value;

    public KeyValuePair(String key, int value) {
        this.key = key;
        this.value = value;
    }
}

class HashTable {
    private int size;
    private LinkedList<KeyValuePair>[] table;

    public HashTable(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % size;
    }

    public void put(String key, int value) {
        int index = hash(key);
        table[index].add(new KeyValuePair(key, value));
    }

    public int get(String key) {
        int index = hash(key);
        for (KeyValuePair pair : table[index]) {
            if (pair.key.equals(key)) {
                return pair.value;
            }
        }
        return -1;  // Not found
    }
}

public class HashTableExample {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.put("one", 1);
        hashTable.put("two", 2);

        int value = hashTable.get("one");
        System.out.println("Value for key 'one': " + value);
    }
}

