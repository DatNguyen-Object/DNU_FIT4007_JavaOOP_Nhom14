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
                if (!line.trim().isEmpty()) lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
        }
        return lines;
    }
    public static void write(String path, List<String> lines) {
        File file = new File(path);

        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Cannot create file: " + path);
                return;
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Write Error: " + e.getMessage());
        }
    }
}