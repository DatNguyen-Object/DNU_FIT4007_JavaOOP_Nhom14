package service;

public interface RefundPolicy {
    double calculateRefund(double price, long hoursBefore);
}