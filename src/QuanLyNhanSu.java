import java.io.*; // Import tat ca cac lop trong java.io
import java.util.ArrayList;

public class QuanLyNhanSu {

    private ArrayList<NhanVien> danhSach;

    public QuanLyNhanSu() {
        this.danhSach = new ArrayList<>();
    }

    public void themNhanVien(NhanVien nv) {
        this.danhSach.add(nv);
    }

    public void inDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }
        for (NhanVien nv : this.danhSach) {
            System.out.println("Ten: " + nv.getTen() + ", Luong: " + nv.tinhLuong());
        }
    }

    // TODO 2: Tao phuong thuc 'public void luuFile(String tenFile)'
    public void luuFile(String tenFile) {
        // Su dung try-with-resources de tu dong dong file
        try (FileOutputStream fos = new FileOutputStream(tenFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            // TODO 3: Goi phuong thuc 'writeObject()' de luu
            // TOAN BO doi tuong 'danhSach' (ArrayList) xuong file
            oos.writeObject(this.danhSach);

            System.out.println("Luu file thanh cong!");

        } catch (IOException e) {
            System.out.println("Loi khi luu file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // TODO 4: Tao phuong thuc 'public void docFile(String tenFile)'
    public void docFile(String tenFile) {
        // Su dung try-with-resources de tu dong dong file
        try (FileInputStream fis = new FileInputStream(tenFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // TODO 5: Goi phuong thuc 'readObject()' de doc doi tuong len
            // Va EP KIEU (cast) no ve 'ArrayList<NhanVien>'
            // roi gan vao 'this.danhSach'
            this.danhSach = (ArrayList<NhanVien>) ois.readObject();

            System.out.println("Doc file thanh cong!");

        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file de doc! Tao danh sach moi.");
            this.danhSach = new ArrayList<>(); // Khoi tao danh sach rong
        } catch (IOException | ClassNotFoundException e) {
            // Bat 2 loai Exception cung luc
            System.out.println("Loi khi doc file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
