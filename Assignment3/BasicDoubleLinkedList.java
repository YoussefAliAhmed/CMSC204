package Assignments.Assignment3;

import java.lang.Iterable;
import java.util.*;

/**
 * A double linked list implementation
 * 
 * @author Youssef Ali Ahmed
 */
public class BasicDoubleLinkedList<T> implements Iterable<T> {
    protected Node head, tail;
    protected int size;

    /**
     * @return number of elements in list
     */
    public int getSize() {
        return size;
    }

    /**
     * adds node with data to the end of the linked list
     * 
     * @param data to be added
     */
    public void addToEnd(T data) {
        Node add = new Node(data);
        if (size == 0) {
            tail = add;
            head = tail;
            size++;
        } else {
            add.setPrev(tail);
            tail.setNext(add);
            tail = add;
            size++;
        }
    }

    /**
     * adds node with data to the front of the linked list
     * 
     * @param data to be added
     */
    public void addToFront(T data) {
        Node add = new Node(data);
        if (size == 0) {
            head = add;
            tail = head;
            size++;
        } else {
            add.setNext(head);
            head.setPrev(add);
            head = add;
            size++;
        }
    }

    /**
     * @return head of the linked list
     */
    public T getFirst() {
        return head.data;
    }

    /**
     * @return tail of the linked list
     */
    public T getLast() {
        return tail.data;
    }

    /**
     * creates an iterator for the instance
     * 
     * @return DoubleLinkedListIterator
     */
    public DoubleLinkedListIterator iterator() {
        return new DoubleLinkedListIterator();
    }

    /**
     * Removes specified element in linked list
     * 
     * @param targetData data to be added
     * @param comparator means to compare data in linked list
     * @return the Node removed
     */
    public Node remove(T targetData, Comparator<T> comparator) {
        DoubleLinkedListIterator it = iterator();
        while (it.hasNext()) {
            it.next();
            Node current = it.current;
            if (comparator.compare(targetData, current.data) == 0) {
                if (current == head) {
                    current.next.setPrev(null);
                    head = current.next;
                    size--;
                    return current;
                } else if (current == tail) {
                    current.prev.setNext(null);
                    tail = current.prev;
                    size--;
                    return current;
                } else {
                    current.prev.setNext(current.next);
                    current.next.setPrev(current.prev);
                    size--;
                    return current;
                }
            }
        }
        System.out.println("No such Node exists.");
        return null;
    }

    /**
     * @return first data element of Linked list
     */
    public T retrieveFirstElement() {
        if (head == null) {
            System.out.println("Empty List");
            return null;
        } else {
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }
    }

    /**
     * @return last data element of Linked list
     */
    public T retrieveLastElement() {
        if (tail == null) {
            System.out.println("Empty List");
            return null;
        } else {
            T data = tail.data;
            tail = tail.prev;
            size--;
            return data;
        }
    }

    /**
     * Creates linked list into ArrayList
     * 
     * @return ArrayList representations of linked list
     */
    public ArrayList<T> toArrayList() {
        ArrayList<T> arr = new ArrayList<>();
        DoubleLinkedListIterator it = iterator();

        while (it.hasNext()) {
            arr.add(it.next());
        }

        return arr;
    }

    /**
     * Node class for the linked list
     */
    class Node {
        protected T data;
        protected Node next, prev;

        /**
         * Default Constructor
         */
        public Node() {
            data = null;
            next = null;
            prev = null;
        }

        /**
         * Constructor for data node
         * 
         * @param dataNode
         */
        public Node(T dataNode) {
            this();
            data = dataNode;
        }

        /**
         * @return data of the node
         */
        public T getData() {
            return data;
        }

        /**
         * @return next node
         */
        public Node getNext() {
            return next;
        }

        /**
         * @return previous node
         */
        public Node getPrev() {
            return prev;
        }

        /**
         * @param next node that is getting pointed to
         */
        public void setNext(Node next) {
            this.next = next;
        }

        /**
         * @param prev node that is getting pointed to
         */
        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    /**
     * Internal iterator for the linked list
     */
    class DoubleLinkedListIterator implements ListIterator<T> {
        protected Node current;
        protected boolean start;

        /**
         * Default Constructor
         */
        public DoubleLinkedListIterator() {
            current = head;
            start = true;
        }

        /**
         * @return true if node points next to another one.
         */
        public boolean hasNext() {
            if (start) {
                return current != null;
            }
            return (current.next != null && current != null);
        }

        /**
         * points to the next node
         * 
         * @throws NoSuchElementException if there is no next node
         * @return next node's data
         */
        public T next() throws NoSuchElementException {
            if (start) {
                start = false;
                return current.data;
            } else if (hasNext()) {
                current = current.next;

                return current.data;
            } else {
                throw new NoSuchElementException();
            }
        }

        /**
         * @return true if node points to previous node
         */
        public boolean hasPrevious() {
            if (start) {
                return false;
            }
            return current.prev != null && current != null;
        }

        /**
         * points to the previous node
         * 
         * @throws NoSuchElementException if there is no previous node
         * @return previous node's data
         */
        public T previous() throws NoSuchElementException {
            if (hasPrevious()) {
                current = current.prev;
                return current.next.data;
            } else {
                throw new NoSuchElementException();
            }
        }

        /**
         * @return Node that is currently being pointed to
         */
        public Node getCurrent() {
            return current;
        }

        /**
         * @throws UnsupportedOperationException
         */
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        /**
         * @throws UnsupportedOperationException
         */
        public int nextIndex() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        /**
         * @throws UnsupportedOperationException
         */
        public int previousIndex() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        /**
         * @throws UnsupportedOperationException
         */
        public void set(T arg0) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        /**
         * @throws UnsupportedOperationException
         */
        public void add(T arg0) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
    }

}
