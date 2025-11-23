package service;
import repository.TicketRepository;
import model.Ticket;

public class ReportService {
    private TicketRepository ticketRepo = new TicketRepository();

    public void printRevenue() {
        double total = 0;
        for (Ticket t : ticketRepo.getAll()) {
            if (t.getStatus().equals("BOOKED")) {
                total += t.getPrice();
            }
        }
        System.out.println("Revenue: " + total);
    }
}