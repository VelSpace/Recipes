import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static int calculateTimeDifferenceInSeconds(LocalTime startTime, LocalTime endTime) {
        int startSeconds = startTime.toSecondOfDay();
        int endSeconds = endTime.toSecondOfDay();
        return endSeconds - startSeconds;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String time1 = sc.next();
        String time2 = sc.next();
        LocalTime startTime = LocalTime.parse(time1);
        LocalTime endTime = LocalTime.parse(time2);
        int seconds1 = calculateTimeDifferenceInSeconds(startTime, endTime);
        System.out.println(Math.abs(seconds1)); // Output: 4
    }
}