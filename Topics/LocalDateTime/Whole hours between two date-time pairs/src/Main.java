import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        LocalTime time = LocalTime.of(22, 10);
        System.out.println(time.isAfter(LocalTime.of(22, 0, 10)));
        System.out.println(time.isBefore(LocalTime.of(22, 10)));
        System.out.println(time.isBefore(LocalTime.of(22, 10, 10)));
        System.out.println(time.isAfter(LocalTime.of(22, 10, 10)));
    }
}