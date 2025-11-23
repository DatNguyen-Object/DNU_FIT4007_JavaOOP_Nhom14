package common;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    public static List<String> readFile(String path) {
        List<String> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader(path);
            Scanner sc = new Scanner(fr);
            while(sc.hasNextLine()) {
                list.add(sc.nextLine());
            }
            fr.close();
        } catch (Exception e) {
            System.out.println("Lỗi đọc file");
        }
        return list;
    }

    public static void writeFile(String path, List<String> data) {
        try {
            FileWriter fw = new FileWriter(path);
            for (String s : data) {
                fw.write(s + "\n");
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
