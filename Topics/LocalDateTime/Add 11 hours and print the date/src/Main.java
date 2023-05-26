import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateTimeString = scanner.nextLine();
       // System.out.println(dateTimeString.length());
        DateTimeFormatter formatter = null;
        if(dateTimeString.length() <= 16) formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        else formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);

        LocalDateTime resultDateTime = dateTime.plusHours(11);

        String resultDateString = resultDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(resultDateString);
    }
}