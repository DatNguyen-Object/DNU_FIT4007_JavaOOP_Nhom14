package service;

public interface RefundPolicy {
    /**
     * Tính số tiền hoàn trả dựa trên chính sách hủy vé.
     * @param price Giá vé gốc
     * @param hoursBefore Số giờ trước khi bay
     * @return Số tiền được hoàn lại
     */
    double calculateRefund(double price, long hoursBefore);
}