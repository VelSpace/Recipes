import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateTimeString = scanner.nextLine();

        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString);

        LocalDateTime startOfYear = LocalDateTime.of(dateTime.getYear(), 1, 1, 0, 0, 0);
        long hoursPassed = startOfYear.until(dateTime, ChronoUnit.HOURS);

        System.out.println(hoursPassed);
    }
}
