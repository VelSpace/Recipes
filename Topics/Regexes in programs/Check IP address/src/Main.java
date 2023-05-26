import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine();
        System.out.println(validateIPAddress(ip));
    }
    public static String validateIPAddress(String ip) {
        String[] segments = ip.split("\\.");

        if (segments.length != 4 || ip.charAt(ip.length()-1) == '.') {
            return "NO";
        }

        for (String segment : segments) {
            if (!segment.matches("\\d+")) {
                return "NO";
            }

            int num = Integer.parseInt(segment);
            if (num < 0 || num > 255) {
                return "NO";
            }
        }

        return "YES";
    }

}