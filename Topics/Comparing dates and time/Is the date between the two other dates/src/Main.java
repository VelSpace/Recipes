import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] dateStrings = input.split(" ");

        LocalDate x = LocalDate.parse(dateStrings[0]);
        LocalDate m = LocalDate.parse(dateStrings[1]);
        LocalDate n = LocalDate.parse(dateStrings[2]);

        boolean isBetween = (x.isAfter(m) && x.isBefore(n)) || (x.isAfter(n) && x.isBefore(m));

        System.out.println(isBetween);
    }
}