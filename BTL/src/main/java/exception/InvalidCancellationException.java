package exception;

public class InvalidCancellationException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidCancellationException(String message) {
        super(message);
    }
}