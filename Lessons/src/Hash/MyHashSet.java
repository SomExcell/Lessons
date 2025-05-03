package Hash;

import static java.lang.Math.abs;

public class MyHashSet {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Node[] table;
    private int size;

    public MyHashSet() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    private static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public boolean add(int value) {
        if (contains(value)) {
            return false;
        }

        if (size >= table.length * LOAD_FACTOR) {
            resize();
        }

        var index = getHash(value);
        table[index] = new Node(value, table[index]);
        size++;
        return true;
    }

    public boolean remove(int value) {
        var index = getHash(value);
        var current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.value == value) {
                if (prev == null)
                {
                    table[index] = current.next;
                }
                else
                {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false;
    }

    public boolean contains(int value) {
        var index = getHash(value);
        var current = table[index];

        while (current != null) {
            if (current.value == value)
            {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    private int getHash(int value)
    {
        return (Math.abs(value * 601)) % table.length;
    }

    private void resize() {
        Node[] oldBuckets = table;
        table = new Node[oldBuckets.length * 2];
        size = 0;

        for (Node node : oldBuckets) {
            while (node != null) {
                add(node.value);
                node = node.next;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}