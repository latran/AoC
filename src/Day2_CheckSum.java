import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The spreadsheet consists of rows of
 * apparently-random numbers. To make sure the recovery
 * process is on the right track, they need you to calculate the spreadsheet's
 * checksum. For each row, determine the difference between the largest value and the
 * smallest value; the checksum is the sum of all of these differences.
 */
public class Day2_CheckSum {
    public static void main(String[] args) throws Exception {
        File file = new File("./resources/Day 2.txt");
        Scanner fileScanner = new Scanner(file);
        ArrayList list = new ArrayList();
        ArrayList list2 = new ArrayList();
        ArrayList sumList = new ArrayList();

        //Part 1 variables
        int low = 0;
        int high = 0;
        int sum;

        //Part 2 variables
        int sum2;

        while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);

            while(lineScanner.hasNext()) {
                int token = lineScanner.nextInt();
                //Part 1
                //Logic for assigning low and high numbers based on number flowing in
                if (token > high) {
                    high = token;
                    if (low == 0) {
                        low = token;
                    }
                } else if (token < low) {
                    low = token;
                }

                //part 2
                list2.add(token);
            }
            lineScanner.close();
            //Part 1
            list.add(lineDif(low, high));
            //Resetting the hgih and low for next row in file
            low = 0;
            high = 0;

            //Part 2
            sumList.add(checkDiv(list2));
        }
        sum = sumCalc(list);
        sum2 = sumCalc(sumList);

        System.out.println("Part 1: " + sum);
        System.out.println("Part 2: " + sum2);
    }

    /**
     * Checks the num coming in and does a comparison between low and high and assigns accordingly
     * @param low
     * @param high
     * @return
     */
    public static int lineDif(int low, int high) {
        return high - low;
    }

    public static int checkDiv(ArrayList numList) {
        int result = 0;

        //Loop through the entire numList. Break when divisibility between 2 numbers are reached
        for (int i = 0; i < numList.size(); i++) {
            //inner loop that goes through each proceeding number after the first number
            for (int j = i + 1; j < numList.size(); j++) {
                int a = (int) numList.get(i);
                int b = (int) numList.get(j);

                //checks which number is larger to perform positive division
                if (a > b) {
                    //checks if the 2 numbers divide evenly
                    if (a % b == 0) {
                        result = a / b;
                        break;
                    }
                } else {
                    if (b % a == 0) {
                        result = b / a;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static int sumCalc(ArrayList num) {
        int sum = 0;
        for (int i = 0; i < num.size(); i++) {
            sum += (int) num.get(i);
        }

        return sum;
    }
}
