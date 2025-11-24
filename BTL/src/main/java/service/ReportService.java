package service;

import model.*;
import repository.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class ReportService {
    private TicketRepository tRepo;
    private FlightRepository fRepo;
    private SeatRepository sRepo;
    private CustomerRepository cRepo;
    private PlaneRepository pRepo;

    public ReportService(TicketRepository t, FlightRepository f, SeatRepository s, CustomerRepository c, PlaneRepository p) {
        this.tRepo = t;
        this.fRepo = f;
        this.sRepo = s;
        this.cRepo = c;
        this.pRepo = p;
    }

    public void printRevenue() {
        double total = 0;
        for (Ticket t : tRepo.getAll()) {
            if ("BOOKED".equals(t.getStatus())) {
                total += t.getPrice();
            }
        }
        System.out.printf("Tổng doanh thu: %.0f VND\n", total);
    }

    public void printOccupancyRate() {
        System.out.println("--- TỶ LỆ LẤP ĐẦY ---");
        for (Flight f : fRepo.getAll()) {
            List<Seat> seats = sRepo.getByFlightId(f.getId());
            long booked = seats.stream().filter(Seat::isBooked).count();
            double rate = 0;
            if (seats.size() > 0) {
                rate = (double) booked / seats.size() * 100;
            }
            System.out.printf("Chuyến %s: %.1f%%\n", f.getId(), rate);
        }
    }

    public void printTopFlights() {
        System.out.println("--- TOP 3 CHUYẾN BAY ---");
        Map<String, Integer> counts = new HashMap<>();
        for (Ticket t : tRepo.getAll()) {
            if ("BOOKED".equals(t.getStatus())) {
                String fid = t.getFlightId();
                counts.put(fid, counts.getOrDefault(fid, 0) + 1);
            }
        }
        counts.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(3)
                .forEach(e -> {
                    Flight f = fRepo.findById(e.getKey());
                    String route = (f != null) ? f.getRoute() : "Unknown";
                    System.out.printf("%s (%s): %d vé\n", e.getKey(), route, e.getValue());
                });
    }

    public void printQuarterlyRevenue() {
        System.out.println("--- DOANH THU THEO QUÝ ---");
        Map<String, Double> map = new HashMap<>();
        for (Ticket t : tRepo.getAll()) {
            if ("BOOKED".equals(t.getStatus())) {
                Flight f = fRepo.findById(t.getFlightId());
                if (f != null) {
                    int q = (f.getDepartureTime().getMonthValue() - 1) / 3 + 1;
                    String key = f.getDepartureTime().getYear() + "-Q" + q;
                    map.put(key, map.getOrDefault(key, 0.0) + t.getPrice());
                }
            }
        }
        map.forEach((k, v) -> System.out.printf("[%s]: %.0f VND\n", k, v));
    }

    public void exportTicket(String tid) {
        Ticket t = tRepo.findById(tid);
        if (t == null) {
            System.out.println("Vé không tồn tại");
            return;
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter("src/main/resources/data/ticket_" + tid + ".csv"))) {
            pw.println("ID,FLIGHT,SEAT,CUSTOMER,PRICE,STATUS");
            pw.println(t.toCsv());
            System.out.println("Xuất vé thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}