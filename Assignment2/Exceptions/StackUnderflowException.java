package Assignments.Assignment2.Exceptions;

public class StackUnderflowException extends Exception {

    public StackUnderflowException() {
        super("Stack Underflow Exception");
    }

    public StackUnderflowException(String message) {
        super(message);
    }

}
