import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numStores = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        LocalTime targetTime = LocalTime.of(19, 30);

        for (int i = 0; i < numStores; i++) {
            String storeInfo = scanner.nextLine();
            String[] storeData = storeInfo.split(" ");
            String storeName = storeData[0];
            LocalTime closingTime = LocalTime.parse(storeData[1]);

            LocalTime reachTime = targetTime.plusMinutes(30);
            if (closingTime.isAfter(reachTime)) {
                System.out.println(storeName);
            }
        }
    }
}