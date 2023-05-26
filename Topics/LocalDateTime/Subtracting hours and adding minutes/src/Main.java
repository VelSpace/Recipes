import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateTimeString = scanner.nextLine();

        int hoursToSubtract = scanner.nextInt();
        int minutesToAdd = scanner.nextInt();

        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString);

        LocalDateTime modifiedDateTime = dateTime.minusHours(hoursToSubtract).plusMinutes(minutesToAdd);

        System.out.println(modifiedDateTime);
    }
}