package Assignments.Assignment2.Exceptions;

public class InvalidNotationFormatException extends Exception {

    public InvalidNotationFormatException(String message) {
        super(message);
    }

    public InvalidNotationFormatException() {
        super("Invalid Notation Format");
    }
}
