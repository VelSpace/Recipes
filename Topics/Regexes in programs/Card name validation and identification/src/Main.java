import java.util.*;

class BankCard {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String numbers = scn.nextLine();
        String card = numbers.replaceAll("\\s", "");
          String visaRegex = "^4\\d{15}$";
        String mastercardRegex = "^(5[1-5]\\d{14}|222[1-9]\\d{12}|22[3-9][0-9]{13}|2[3-6][0-9]{14}|27[0-1][0-9]{13}|2720\\d{12})$";
        String amexRegex = "^3[47]\\d{13}$";
        if (card.matches(visaRegex)) {
            System.out.println("Visa");
        } else if (card.matches(mastercardRegex)) {
            System.out.println("MasterCard");
        } else if (card.matches(amexRegex)) {
            System.out.println("AmericanExpress");
        } else {
            System.out.println("Card number does not exist");
        }
    }
}
