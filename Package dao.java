package dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvHelper {
    
    private static final String COMMA_DELIMITER = ",";

    // Hàm đọc file generic: Trả về danh sách các dòng, mỗi dòng là mảng String
    public static List<String[]> readFile(String filePath) {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // Bỏ qua dòng trống
                String[] values = line.split(COMMA_DELIMITER);
                records.add(values);
            }
        } catch (IOException e) {
            System.err.println("Lỗi đọc file: " + filePath + " - " + e.getMessage());
        }
        return records;
    }

    // Hàm ghi file (append hoặc overwrite)
    public static void writeFile(String filePath, List<String> lines, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, append))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Lỗi ghi file: " + filePath);
        }
    }
}