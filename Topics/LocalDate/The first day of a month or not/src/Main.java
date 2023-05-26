import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year = scanner.nextInt();
        int dayOfYear = scanner.nextInt();

        // Check if the day is the last day of a month
        boolean isLastDayOfMonth = isLastDayOfMonth(year, dayOfYear);

        // Print the result
        System.out.println(isLastDayOfMonth);

        scanner.close();
    }

    public static boolean isLastDayOfMonth(int year, int dayOfYear) {
        LocalDate date = LocalDate.ofYearDay(year, dayOfYear);

        return date.getDayOfMonth() == 1;

    }
}