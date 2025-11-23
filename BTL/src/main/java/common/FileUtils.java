package common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static List<String> read(String path) {
        List<String> lines = new ArrayList<>();
        File file = new File(path);

        if (!file.exists()) {
            return lines;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void write(String path, List<String> lines) {
        try {
            File file = new File(path);

            if (!file.exists()) {
                file.getParentFile().mkdirs(); // Tạo thư mục cha (data)
                file.createNewFile();          // Tạo file csv
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                for (String line : lines) {
                    bw.write(line);
                    bw.newLine(); // Xuống dòng
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}