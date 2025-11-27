# QUẢN LÝ BÁN VÉ MÁY BAY NỘI ĐỊA (NHÓM 14)

> **Bài tập lớn môn Lập trình Hướng đối tượng (Java)**
> **Giảng viên hướng dẫn:** ThS. Kiều Tuấn Dũng

---

## Thành viên nhóm
| STT | Mã SV | Họ và Tên | Vai trò | Email |
|:---|:---|:---|:---|:---|
| 1 | **18710400...** | **Ngô Việt Anh** | Nhóm trưởng (Leader) | vietanh190806@gmail.com |
| 2 | 18710400... | Nguyễn Tấn Đạt | Thành viên (Data) | dat3008a08@gmail.com |
| 3 | 1871040027 | Nguyễn Ngọc Quyết | Thành viên (View) | quyet.nguyen@email.com |

---

## Giới thiệu Đề tài
Hệ thống xây dựng một ứng dụng **Java Console** hỗ trợ các đại lý vé máy bay quản lý quy trình nghiệp vụ khép kín:
- **Quản lý danh mục:** Máy bay, Chuyến bay (có kiểm tra trùng lịch), Khách hàng.
- **Nghiệp vụ vé:** Đặt vé (Booking), Hủy vé (Cancel), Tính giá vé linh hoạt theo hạng ghế.
- **Báo cáo:** Thống kê doanh thu, Tỷ lệ lấp đầy, Top chuyến bay bán chạy.
- **Lưu trữ:** Dữ liệu được lưu bền vững trên hệ thống tệp tin **CSV**, đảm bảo không mất dữ liệu khi tắt ứng dụng.

---

## Công nghệ sử dụng
- **Ngôn ngữ:** Java (JDK 17+)
- **IDE:** IntelliJ IDEA
- **Quản lý phiên bản:** Git & GitHub
- **Kiến trúc:** Layered Architecture (View - Service - Repository - Model)
- **Kỹ thuật:** OOP (Encapsulation, Inheritance, Polymorphism, Abstraction), Exception Handling, File I/O.

---

## Hướng dẫn cài đặt & Chạy
1.  **Clone dự án:**
    ```bash
    git clone [https://github.com/DatNguyen-Object/DNU_FIT4007_JavaOOP_Nhom14.git](https://github.com/DatNguyen-Object/DNU_FIT4007_JavaOOP_Nhom14.git)
    ```
2.  **Mở bằng IntelliJ IDEA:**
    - Chọn `File` -> `Open` -> Chọn thư mục dự án.
3.  **Kiểm tra Dữ liệu:**
    - Đảm bảo thư mục `src/main/resources/data/` có đủ 7 file `.csv` (`flights.csv`, `customers.csv`...).
4.  **Chạy ứng dụng:**
    - Mở file `src/main/java/Main.java`.
    - Nhấn nút **Run**.

---

## Kịch bản Kiểm thử (Auto Test)
Hệ thống tích hợp sẵn module kiểm thử tự động tại **Menu chức năng số 6**, bao gồm:
- [x] Thêm mới Máy bay, Chuyến bay, Khách hàng.
- [x] Kiểm tra ràng buộc trùng lịch bay (Conflict Check).
- [x] Đặt vé thành công & Thất bại (Trùng ghế).
- [x] Tính giá vé Thương gia/Phổ thông.
- [x] Hủy vé và tính tiền hoàn lại theo chính sách 48h.
- [x] Xuất báo cáo và File CSV.

---

**© 2025 Nhóm 14 - KHMT 18-01 - Đại học Đại Nam**