package Assignments.Assignment3;

import java.util.*;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
    Comparator<T> comparator;

    /**
     * Constructor that sets the comparator
     * 
     * @param comparator used to sort LinkedList
     */
    public SortedDoubleLinkedList(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * adds the data to the list in sorted order based on the comparator
     * 
     * @param data to be added
     */
    public void add(T data) {
        Node newNode = new Node(data);
        Node current = head;
        if (size == 0) {
            head = newNode;
            tail = newNode;
            size++;
        } else if (comparator.compare((T)current.data, data) > 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
        } else {
            while (current.next != null && comparator.compare((T)current.next.data, data) < 0) {
                current = current.next;
            }
            if (current.next == null) {
                current.next = newNode;
                newNode.prev = current;
                tail = newNode;
                size++;
            } else {
                newNode.next = current.next;
                current.next.prev = newNode;
                current.next = newNode;
                newNode.prev = current;
                size++;
            }
        }
    }

    /**
     * @throws UnsupportedOperationException
     */
    public void addToEnd(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    /**
     * @throws UnsupportedOperationException
     */
    public void addToFront(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }
}
