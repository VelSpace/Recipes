import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        String[] nums1 = input1.split(" ");
        String[] nums2 = input2.split(" ");

        List<Integer> sequence1 = new ArrayList<>();
        List<Integer> sequence2 = new ArrayList<>();

        for (String num : nums1) {
            sequence1.add(Integer.parseInt(num));
        }

        for (String num : nums2) {
            sequence2.add(Integer.parseInt(num));
        }

        int firstIndex = -1;
        int lastIndex = -1;

        for (int i = 0; i <= sequence1.size() - sequence2.size(); i++) {
            if (sequence1.get(i).equals(sequence2.get(0))) {
                boolean match = true;
                for (int j = 1; j < sequence2.size(); j++) {
                    if (!sequence1.get(i + j).equals(sequence2.get(j))) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    if(firstIndex == -1 )firstIndex = i;
                    lastIndex = i ;
                }
            }
        }

        System.out.println(firstIndex + " " + lastIndex);
    }
}