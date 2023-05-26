import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputParts = input.split(" ");
        String dateTimeString = inputParts[0];
        int daysToAdd = Integer.parseInt(inputParts[1]);
        int hoursToSubtract = Integer.parseInt(inputParts[2]);

        // Parse input date-time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);

        // Perform manipulation
        LocalDateTime resultDateTime = dateTime.plusDays(daysToAdd).minusHours(hoursToSubtract);

        // Format and print output
        String output = resultDateTime.format(formatter);
        System.out.println(output);
    }
}