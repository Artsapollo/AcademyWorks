package Lesson9;

public class UncheckException extends RuntimeException {
    public UncheckException(String message) {
        super(message);
        System.out.println("Unchecked Exception");
    }
}
