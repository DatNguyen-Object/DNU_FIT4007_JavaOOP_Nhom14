package common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static String toString(LocalDateTime date) {
        return date.format(FORMATTER);
    }

    public static LocalDateTime fromString(String dateStr) {
        return LocalDateTime.parse(dateStr, FORMATTER);
    }
}