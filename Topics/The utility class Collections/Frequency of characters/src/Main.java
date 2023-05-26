import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine();
        char targetChar = scanner.nextLine().charAt(0);


        int frequency = 0;

        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == targetChar) {
                frequency++;
            }
        }

        System.out.println(frequency);
    }
}