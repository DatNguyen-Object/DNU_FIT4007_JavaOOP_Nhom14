package main;

import model.*;
import service.FlightService;
import dao.CsvHelper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AirlineApp {
    public static void main(String[] args) {
        // 1. Load dữ liệu từ CSV khi khởi động
        List<String[]> rawFlights = CsvHelper.readFile("data/flights.csv");
        List<Flight> flights = new ArrayList<>();
        
        // (Giả sử có code parse từ String[] sang Object Flight ở đây...)
        
        // 2. Khởi tạo Service
        FlightService flightService = new FlightService(flights);

        // 3. Demo chức năng thêm chuyến bay có kiểm tra trùng lặp
        try {
            System.out.println("--- Đang cố gắng tạo chuyến bay mới ---");
            String planeId = "VN-A321";
            
            // Giả sử định dạng input: 2025-11-25 08:00
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime start = LocalDateTime.parse("2025-11-25 08:00", formatter);
            LocalDateTime end = LocalDateTime.parse("2025-11-25 10:00", formatter);

            // Kiểm tra trùng
            flightService.checkFlightConflict(planeId, start, end);

            // Nếu không ném Exception thì tạo chuyến bay thành công
            System.out.println("Tạo chuyến bay thành công! Đang lưu vào file...");
            
            // Lưu xuống file
            List<String> dataToSave = new ArrayList<>();
            dataToSave.add("FL999," + planeId + ",Hanoi,DaNang,2025-11-25T08:00,2025-11-25T10:00");
            CsvHelper.writeFile("data/flights.csv", dataToSave, true);

        } catch (Exception e) {
            // Bắt lỗi logic (trùng lịch) hoặc lỗi hệ thống
            System.err.println("THẤT BẠI: " + e.getMessage());
        }
    }
}