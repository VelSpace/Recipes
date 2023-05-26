import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputDate = scanner.nextLine();

        // Parse the input date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(inputDate, formatter);

        // Add 2 weeks to the date
        LocalDate dateTwoWeeksAfter = date.plusWeeks(2);

        // Print the resulting date
        String outputDate = dateTwoWeeksAfter.format(formatter);
        System.out.println(outputDate);

        scanner.close();
    }
}