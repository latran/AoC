import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day5_Jumps {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("./resources/Day 5.txt");
        Scanner scan = new Scanner(file);
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        while(scan.hasNextLine()) {
            int n = scan.nextInt();
            list.add(n);
            list2.add(n);
        }

        System.out.println(part1(list));
        System.out.println(part2(list2));
    }

    /**
     * Part 1:
     *  - Jump with offset, increment offset by 1, and update offset in the old position
     * @param list
     * @return
     */
    private static String part1(List<Integer> list) {
        String str = "Something went wrong";
        int count = 0;
        int offset;

        for (int i = 0; i < list.size();) {
            offset = list.get(i);
            int pos = i;

            //Don't jump else jump forward or backwards
            if (offset == 0) {
                offset++;
                list.set(i, offset); //Update offset in old position
                count++; //Count steps
            } else {
                i += offset; //Actual jumping
                count++;
                if (i >= list.size()) {
                    return "Part 1 - Steps taken: "  + count;
                }
                offset++;
                list.set(pos, offset);
            }
        }
        return str;
    }

    /**
     * Part 2:
     *  -Jump with offset
     *  -Decrement offset by 1 if offset is >= 3
     *  -increment offset by 1 if offset is < 3
     *  -Update the offset in the old position
     * @param list
     * @return
     */
    private static String part2(List<Integer> list) {
        String str = "Something went wrong";
        int count = 0;
        int offset;

        for(int i = 0; i < list.size();) {
            offset = list.get(i);
            int pos = 1;

            //Don't jump else jump forward or backwards
            if (offset == 0) {
                offset++;
                list.set(i, offset); //Update offset in old position
                count++; //count steps
            } else {
                i += offset;
                count++;
                if (offset >= 3) {
                    if (i >= list.size()) {
                        return "Part 2 - Steps taken: " + count;
                    }
                    offset--;
                } else {
                    if (i >= list.size()) {
                        return "Part 2 - Steps taken: " + count;
                    }
                    offset++;
                }
                list.set(pos, offset);
            }
        }
        return str;
    }
}
