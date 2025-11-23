package repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// 👇 QUAN TRỌNG: Phải có từ khóa "abstract" ở đây
public abstract class CsvRepository<T> implements Persistable<T> {
    protected String filePath;
    protected List<T> items;

    public CsvRepository(String filePath) {
        this.filePath = filePath;
        this.items = load();
    }

    // Các hàm trừu tượng để lớp con định nghĩa
    protected abstract T fromCsv(String line);
    protected abstract String toCsv(T entity);

    // Hàm đọc file (Logic chung)
    public List<T> load() {
        List<T> list = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    try {
                        T obj = fromCsv(line);
                        if (obj != null) list.add(obj);
                    } catch (Exception e) {
                        // Bỏ qua dòng lỗi
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Hàm ghi file (Logic chung)
    public void save(List<T> data) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                for (T item : data) {
                    bw.write(toCsv(item));
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Implement các hàm của Interface Persistable
    @Override
    public List<T> getAll() {
        return items;
    }

    @Override
    public void add(T item) {
        items.add(item);
        save(items);
    }

    // 👇 QUAN TRỌNG: Khai báo lại hàm này dưới dạng abstract để hết lỗi
    @Override
    public abstract void update(T item);
}