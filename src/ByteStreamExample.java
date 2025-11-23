import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamExample {
    public static void main(String[] args) {
        String filename = "vi-text.txt";

        // Su dung try-with-resources de tu dong dong stream
        try (FileInputStream fis = new FileInputStream(filename)) {

            System.out.println("Doc file bang Byte Stream (gia tri byte thuc su):");
            int byteData;

            // doc() tra ve 1 byte (duoi dang int 0-255), hoac -1 neu het file
            while ((byteData = fis.read()) != -1) {
                // In gia tri byte (so) va ky tu (neu co the)
                System.out.printf("Byte: %-5d (Hex: %s)%n",
                        byteData,
                        Integer.toHexString(byteData));
            }

        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }
}