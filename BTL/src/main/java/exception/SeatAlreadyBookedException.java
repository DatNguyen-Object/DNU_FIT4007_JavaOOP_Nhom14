package exception;

public class SeatAlreadyBookedException extends Exception {
    private static final long serialVersionUID = 1L;

    public SeatAlreadyBookedException(String message) {
        super(message);
    }
}