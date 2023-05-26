import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputDate = scanner.nextLine();

        // Parse the input date string into a LocalDate object
        LocalDate date = LocalDate.parse(inputDate);

        // Get the day of year
        int dayOfYear = date.getDayOfYear();

        // Get the day of month
        int dayOfMonth = date.getDayOfMonth();

        // Output the information
        System.out.println(dayOfYear+" "+dayOfMonth);

        // Close the scanner
        scanner.close();
    }
}