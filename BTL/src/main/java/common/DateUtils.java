package common;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static String toString(LocalDateTime date) {
        if (date == null) return "";
        return date.format(FORMATTER);
    }

    public static LocalDateTime fromString(String dateStr) {
        try {
            return LocalDateTime.parse(dateStr, FORMATTER);
        } catch (Exception e) {
            return null;
        }
    }
}