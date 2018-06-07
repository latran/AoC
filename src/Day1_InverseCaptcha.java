import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * The captcha requires you to review a sequence of digits (your puzzle input) and
 * find the sum of all digits that match the next digit in the list. The list is circular,
 * so the digit after the last digit is the first digit in the list.
 *
 * For example:

 1122 produces a sum of 3 (1 + 2) because the first digit (1) matches the second digit and the third digit (2) matches the fourth digit.
 1111 produces 4 because each digit (all 1) matches the next.
 1234 produces 0 because no digit matches the next.
 91212129 produces 9 because the only digit that matches the next one is the last digit, 9.
 */
public class Day1_InverseCaptcha {

    public static void main(String[] args) throws Exception {
        File file = new File("./resources/Day 1.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        ArrayList numList = new ArrayList();

        int c = 0;
        int sum = 0;
        int digit, nextDigit, first;

        while ((c = reader.read()) != -1) {
            char outer = (char) c;

            numList.add(Character.getNumericValue(outer));
        }

        for (int i = 0; i <= numList.size() - 1; i++) {
            first = (int) numList.get(0);
            digit = (int) numList.get(i);

            if (i != numList.size() - 1) {
                nextDigit = (int) numList.get(i+1);
                if (digit == nextDigit) {
                    sum += nextDigit;
                }
            } else {
                if (digit == first) {
                    sum += first;
                }
            }
        }
        System.out.println(sum);
    }
}
