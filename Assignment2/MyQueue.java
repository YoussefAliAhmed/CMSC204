package Assignments.Assignment2;

import java.util.ArrayList;

import Assignments.Assignment2.Exceptions.*;

/**
 * Class for a Queue data structure
 * 
 * @param <T>
 */
public class MyQueue<T> implements QueueInterface<T> {
    private int size = 5;
    private ArrayList<T> arr;

    /**
     * Default constructor for a queue of size 5
     */
    public MyQueue() {
        arr = new ArrayList<>();
    }

    /**
     * Constructor for a queue of a specified size
     * 
     * @param size of the queue
     */
    public MyQueue(int size) {
        this();
        this.size = size;

    }

    /**
     * Checks if the stack is empty
     * 
     * @return boolean True if empty, false if not
     */
    public boolean isEmpty() {
        return arr.size() == 0;
    }

    /**
     * Checks if the stack is full
     * 
     * @return boolean True if full, false if not
     */
    public boolean isFull() {
        return arr.size() == size;
    }

    /**
     * Adds an element to the end of the Queue
     * 
     * @param ele to add to the end of the Queue
     * @return true if the add was successful, false otherwise
     * @throws QueueOverflowException if queue is full
     */
    @Override
    public boolean enqueue(T ele) throws QueueOverflowException {

        if (isFull()) {
            throw new QueueOverflowException();
        } else {
            arr.add(ele);
            return true;
        }
    }

    /**
     * Deletes and returns the element at the front of the Queue
     * 
     * @return T the element at the front of the Queue
     * @throws QueueUnderflowException if the queue is empty
     */
    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            return arr.remove(0);
        }

    }

    /**
     * @return the number of elements in the stack
     */
    public int size() {
        return arr.size();
    }

    /**
     * @return string representation of the stack with elements
     */
    public String toString() {
        return toString("");
    }

    /**
     * @return string representation of the stack with elements separated by a delimiter
     * @paramters delimiter to add in the string representation
     */
    public String toString(String delimiter) {
        String str = arr.get(0).toString();
        for (int i = 1; i < arr.size(); i++) {
            str += delimiter + arr.get(i);
        }
        return str;
    }

    /**
     * fills the stack with the elements of the list parameter
     * 
     * @param list
     */
    public void fill(ArrayList<T> list) throws QueueOverflowException {
        for (int i = 0; i < list.size(); i++) {
            enqueue(list.get(i));
        }

    }

}
