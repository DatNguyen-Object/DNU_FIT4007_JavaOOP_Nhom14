package service;

import model.Flight;
import exception.FlightConflictException;
import java.time.LocalDateTime;
import java.util.List;

public class FlightService {
    private List<Flight> flightList; // Giả sử list này đã load dữ liệu từ file

    public FlightService(List<Flight> flightList) {
        this.flightList = flightList;
    }

    // Hàm kiểm tra trùng lịch cho 1 máy bay cụ thể
    public void checkFlightConflict(String planeId, LocalDateTime newStart, LocalDateTime newEnd) 
            throws FlightConflictException {
        
        // Duyệt qua tất cả chuyến bay hiện có
        for (Flight f : flightList) {
            // Chỉ kiểm tra các chuyến bay của cùng máy bay đó
            if (f.getPlaneId().equals(planeId)) {
                
                // Logic giao nhau của 2 khoảng thời gian: (StartA < EndB) && (EndA > StartB)
                boolean isOverlapping = newStart.isBefore(f.getEndTime()) && 
                                        newEnd.isAfter(f.getStartTime());

                if (isOverlapping) {
                    throw new FlightConflictException(
                        "Máy bay " + planeId + " đã có lịch bay từ " + 
                        f.getStartTime() + " đến " + f.getEndTime()
                    );
                }
            }
        }
    }
    
    // Hàm đặt vé (Demo logic trạng thái ghế)
    public void bookTicket(String flightId, String seatId) throws Exception {
         // Logic tìm chuyến bay và ghế...
         // Nếu tìm thấy seat:
         // if (seat.isBooked()) throw new SeatAlreadyBookedException(seatId);
         // seat.setBooked(true);
         // saveChangesToFile();
    }
}