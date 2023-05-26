import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        String[] range1 = input1.split(" ");
        String[] range2 = input2.split(" ");

        LocalTime earlier1 = LocalTime.parse(range1[0]);
        LocalTime later1 = LocalTime.parse(range1[1]);

        LocalTime earlier2 = LocalTime.parse(range2[0]);
        LocalTime later2 = LocalTime.parse(range2[1]);

        boolean intersect = (earlier1.isBefore(later2) || earlier1.equals(later2)) &&
                (later1.isAfter(earlier2) || later1.equals(earlier2));

        System.out.println(intersect);
    }
}