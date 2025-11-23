package service;

import model.Ticket;
import repository.TicketRepository;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportService {
    private TicketRepository ticketRepo;

    public ReportService(TicketRepository ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    public void printRevenue() {
        double total = ticketRepo.getAll().stream()
                .filter(t -> "BOOKED".equals(t.getStatus()))
                .mapToDouble(Ticket::getPrice)
                .sum();
        System.out.printf(">>> TỔNG DOANH THU THỰC TẾ: %,.0f VND\n", total);
    }

    // Tính năng mới: Top chuyến bay bán chạy
    public void printTopFlights() {
        System.out.println("--- TOP 3 CHUYẾN BAY BÁN CHẠY ---");
        Map<String, Long> counts = ticketRepo.getAll().stream()
                .collect(Collectors.groupingBy(Ticket::getFlightId, Collectors.counting()));

        counts.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue())) // Sắp xếp giảm dần
                .limit(3)
                .forEach(e -> System.out.printf("Chuyến bay %s: %d vé\n", e.getKey(), e.getValue()));
    }
}