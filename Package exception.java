package exception;

public class SeatAlreadyBookedException extends Exception {
    public SeatAlreadyBookedException(String seatId) {
        super("Lỗi: Ghế " + seatId + " đã có người đặt, vui lòng chọn ghế khác.");
    }
}

public class FlightConflictException extends Exception {
    public FlightConflictException(String message) {
        super(message);
    }
}