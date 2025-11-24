package common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static List<String> read(String path) {
        List<String> lines = new ArrayList<>();
        File file = new File(path);

        if (!file.exists()) {
            try {
                if (file.getParentFile() != null) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Lỗi tạo file: " + path);
            }
            return lines;
        }

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
        return lines;
    }

    public static void write(String path, List<String> lines) {
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }
}