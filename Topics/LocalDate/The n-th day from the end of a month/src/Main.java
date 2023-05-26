import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int year = scanner.nextInt();

        int month = scanner.nextInt();

        int remainingDays = scanner.nextInt();

        // Calculate the date of the n-th day from the end of the month
        LocalDate date = calculateNthDayFromEndOfMonth(year, month, remainingDays);

        // Print the result
        System.out.println(date);

        scanner.close();
    }

    public static LocalDate calculateNthDayFromEndOfMonth(int year, int month, int remainingDays) {
        LocalDate lastDayOfMonth = LocalDate.of(year, month, 1).plusMonths(1).minusDays(1);
        LocalDate nthDayFromEndOfMonth = lastDayOfMonth.minusDays(remainingDays - 1);
        return nthDayFromEndOfMonth;
    }
}