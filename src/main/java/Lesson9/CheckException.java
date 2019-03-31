package Lesson9;

public class CheckException extends Exception {
    public CheckException(String message) {
        super(message);
        System.out.println("Checked Exception");
    }
}
