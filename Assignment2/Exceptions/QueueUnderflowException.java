package Assignments.Assignment2.Exceptions;

public class QueueUnderflowException extends Exception {
    public QueueUnderflowException() {
        super("Queue Underflow");
    }

    public QueueUnderflowException(String message) {
        super(message);
    }
}
