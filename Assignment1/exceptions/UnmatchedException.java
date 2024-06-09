package Assignments.Assignment1.exceptions;

public class UnmatchedException extends Exception {
    public UnmatchedException() {
        super("The passwords do not match");
    }
}
