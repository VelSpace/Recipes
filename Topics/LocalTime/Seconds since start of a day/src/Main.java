import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateTimeString = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);

        LocalDateTime resultDateTime = dateTime.plusHours(11);

        String resultDateString = resultDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(resultDateString);
    }
}