package Assignments.Assignment2;

import java.util.ArrayList;

import Assignments.Assignment2.Exceptions.*;

/**
 * Class for Stack Data Structure
 * 
 * @param <T> data type
 */
public class MyStack<T> implements StackInterface<T> {

    private int size;
    private ArrayList<T> arr;

    /**
     * Default constructor for a stack of size 5
     */
    public MyStack() {
        size = 5;
        arr = new ArrayList<>();
    }

    /**
     * Constructor for a stack of a specified size
     * 
     * @param size
     */
    public MyStack(int size) {
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
     * Takes out the top elemenet of the stack
     * 
     * @throws StackUnderflowExceptions if the stack is empty
     * @return top element of the stack
     */
    public T pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException();
        } else {
            return arr.remove(arr.size() - 1);
        }
    }

    /**
     * Returns the top element of the stack, but doesn't take it out
     * 
     * @throws StackUnderflowException if the stack is empty
     * @return top element of the stack
     */
    public T top() throws StackUnderflowException {
        return arr.get(arr.size() - 1);
    }

    /**
     * @return the number of elements in the stack
     */
    public int size() {
        return arr.size();
    }

    /**
     * Adds an element to the top of the stack
     * 
     * @param e
     * @return true if the push was successful
     * @throws StackOverflowException if the stack is full
     */
    public boolean push(T e) throws StackOverflowException {
        if (isFull()) {
            throw new StackOverflowException();
        } else {
            arr.add(e);
            return true;
        }
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
    public void fill(ArrayList<T> list) throws StackOverflowException {
        for (T e : list) {
            push(e);
        }
    }

}
