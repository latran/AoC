import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day6_MemReallocation {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("./resources/Day 6.txt");
        Scanner scan = new Scanner(file);

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> loopList = new ArrayList<>();

        int n;
        int count = 0;
        int count2 = 0;

        while (scan.hasNextLine()) {
            n = scan.nextInt();
            list.add(n);
        }
        scan.close();

        loopList.add(list.toString());

        memAllocation(list, loopList);
        count = calcSteps(loopList);
        count2 = calcLoop(loopList, list);

        System.out.println("Part 1: count = " + count);
        System.out.println("Part 2: count = " + count2);
    }

    /**
     * Process of memory allocation it should return a looplist
     * @param list
     * @param loopList
     * @return
     */
    private static ArrayList memAllocation(ArrayList<Integer> list, ArrayList<String> loopList) {
        int bignum = Collections.max(list);
        int index = 0;
        boolean flag = true;

        while (flag == true) {

            //Resetting the first large number encountered in the list
            for (int i = 0; i < list.size(); i++) {
                if(bignum == list.get(i)) {
                    index = list.indexOf(list.get(i));
                    break;
                }
            }
            list.set(index, 0);

            //Iterating through the circular list until memAllocation is done
            for (int i = index + 1; i <= list.size(); i++) {
                //Ensuring list is circular
                if (i == list.size()) {
                    i = 0;
                }

                //check duplicates and break out if encountered else continue on with memAllocation
                if (bignum == 0) {
                    if (loopList.contains(list.toString())) {
                        calcSteps(loopList);
                        calcLoop(loopList, list);
                        flag = false;
                        break;
                    }
                    loopList.add(list.toString());

                    //Getting the new largest value for next memAllocation run
                    bignum = Collections.max(list);
                    index = 0;
                    break;
                } else {
                    //Reallocating the memories down the list
                    int curr = list.get(i);
                    list.set(i, curr + 1);
                    bignum--;
                }
            }
        }
        return list;
    }

    private static int calcSteps(ArrayList<String> list) {
        list.indexOf(list);
        return list.size();
    }

    private static int calcLoop(ArrayList<String> loopList, ArrayList<Integer> list) {
        int index = 0;
        for (int i = 0; i < loopList.size(); i++) {
            if(list.toString().equals(loopList.get(i))) {
                index = i;
            }
        }
        return loopList.size() - index;
    }
}
