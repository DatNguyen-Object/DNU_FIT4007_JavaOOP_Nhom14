package service;

import model.Ticket;
import repository.TicketRepository;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportService {
    private TicketRepository ticketRepo;

    // Constructor (Dependency Injection)
    public ReportService(TicketRepository ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    // 1. Báo cáo tổng doanh thu
    public void printRevenue() {
        System.out.println("\n--- BÁO CÁO DOANH THU ---");
        double total = ticketRepo.getAll().stream()
                .filter(t -> "BOOKED".equals(t.getStatus()))
                .mapToDouble(Ticket::getPrice)
                .sum();
        System.out.printf(">>> TỔNG DOANH THU THỰC TẾ: %,.0f VND\n", total);
    }

    // 2. Top 3 chuyến bay bán chạy nhất
    public void printTopFlights() {
        System.out.println("\n--- TOP 3 CHUYẾN BAY BÁN CHẠY ---");

        // Nhóm vé theo FlightID và đếm số lượng
        Map<String, Long> counts = ticketRepo.getAll().stream()
                .filter(t -> "BOOKED".equals(t.getStatus()))
                .collect(Collectors.groupingBy(Ticket::getFlightId, Collectors.counting()));

        if (counts.isEmpty()) {
            System.out.println("(Chưa có dữ liệu bán vé)");
            return;
        }

        // Sắp xếp giảm dần và lấy top 3
        counts.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(3)
                .forEach(e -> System.out.printf("Chuyến bay %s: Đã bán %d vé\n", e.getKey(), e.getValue()));
    }
}