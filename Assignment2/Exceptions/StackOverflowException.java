package Assignments.Assignment2.Exceptions;

public class StackOverflowException extends Exception {
    public StackOverflowException() {
        super("Stack Overflow Exception");
    }

    public StackOverflowException(String message) {
        super(message);
    }

}
