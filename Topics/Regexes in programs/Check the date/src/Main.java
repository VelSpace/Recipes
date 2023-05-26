import java.util.*;
import java.util.regex.Pattern;

class Date {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String date = scn.nextLine();
        System.out.println(checkValidDate(date));
    }
    public static String checkValidDate(String dateString) {
        // Regular expression for yyyy-mm-dd format
        String regex1 = "^(19|20)\\d{2}[-/.](0[1-9]|1[0-2])[-/.](0[1-9]|1\\d|2[0-9]|3[0-1])$";

        // Regular expression for dd-mm-yyyy format
        String regex2 = "^(0[1-9]|1\\d|2[0-9]|3[0-1])[-/.](0[1-9]|1[0-2])[-/.](19|20)\\d{2}$";

        if (Pattern.matches(regex1, dateString) || Pattern.matches(regex2, dateString)) {
            return "Yes";
        } else {
            return "No";
        }
    }

}