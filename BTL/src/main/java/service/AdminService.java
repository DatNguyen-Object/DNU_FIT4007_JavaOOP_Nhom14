package service;

import model.*;
import repository.*;
import common.DateUtils;
import java.time.LocalDateTime;

public class AdminService {
    private FlightRepository fRepo;
    private PlaneRepository pRepo;
    private SeatRepository sRepo;
    private CustomerRepository cRepo;

    public AdminService(FlightRepository f, PlaneRepository p, SeatRepository s, CustomerRepository c) {
        this.fRepo = f;
        this.pRepo = p;
        this.sRepo = s;
        this.cRepo = c;
    }

    // --- MÁY BAY ---
    public void addPlane(String id, String model, int cap) throws Exception {
        if (pRepo.findById(id) != null) {
            throw new Exception("Trùng mã máy bay");
        }
        pRepo.add(new Plane(id, model, cap));
    }

    public void updatePlane(String id, String model, int cap) throws Exception {
        Plane p = pRepo.findById(id);
        if (p == null) {
            throw new Exception("Không tìm thấy máy bay");
        }
        p.setModel(model);
        p.setCapacity(cap);
        pRepo.update(p);
    }

    public void deletePlane(String id) throws Exception {
        Plane p = pRepo.findById(id);
        if (p == null) {
            throw new Exception("Không tìm thấy máy bay");
        }
        pRepo.delete(p);
    }

    // --- CHUYẾN BAY ---
    public void addFlight(String id, String route, String timeStr, double price, String pid) throws Exception {
        if (fRepo.findById(id) != null) {
            throw new Exception("Trùng mã chuyến");
        }
        if (pRepo.findById(pid) == null) {
            throw new Exception("Mã máy bay không tồn tại");
        }

        LocalDateTime time = DateUtils.fromString(timeStr);
        // Check trùng lịch (4 tiếng)
        for (Flight f : fRepo.getAll()) {
            if (f.getPlaneId().equals(pid)) {
                LocalDateTime existTime = f.getDepartureTime();
                if (time.isAfter(existTime.minusHours(4)) && time.isBefore(existTime.plusHours(4))) {
                    throw new Exception("Máy bay bận (Trùng lịch)");
                }
            }
        }

        fRepo.add(new DomesticFlight(id, route, time, price, pid));
        sRepo.generateSeats(id);
    }

    public void updateFlight(String id, String route, String timeStr, double price, String pid) throws Exception {
        Flight f = fRepo.findById(id);
        if (f == null) {
            throw new Exception("Chuyến bay không tồn tại");
        }

        // Logic update
        f.setRoute(route);
        f.setDepartureTime(DateUtils.fromString(timeStr));
        f.setBasePrice(price);
        f.setPlaneId(pid);

        fRepo.update(f);
    }

    public void deleteFlight(String id) throws Exception {
        Flight f = fRepo.findById(id);
        if (f == null) {
            throw new Exception("Chuyến bay không tồn tại");
        }
        fRepo.delete(f);
    }

    // --- KHÁCH HÀNG ---
    public void addCustomer(String id, String name, String phone, String email) {
        cRepo.add(new Customer(id, name, phone, email));
    }

    public void updateCustomer(String id, String name, String phone) throws Exception {
        Customer c = cRepo.findById(id);
        if (c == null) {
            throw new Exception("Khách không tồn tại");
        }
        c.setName(name);
        c.setPhone(phone);
        cRepo.update(c);
    }

    public void deleteCustomer(String id) throws Exception {
        Customer c = cRepo.findById(id);
        if (c == null) {
            throw new Exception("Khách không tồn tại");
        }
        cRepo.delete(c);
    }
}