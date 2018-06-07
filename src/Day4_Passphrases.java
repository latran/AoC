import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * A new system policy has been put in place that requires all accounts to use a passphrase instead of simply a password. A passphrase consists of a series of words (lowercase letters) separated by spaces.

 To ensure security, a valid passphrase must contain no duplicate words.
 */
public class Day4_Passphrases {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("./resources/Day 4.txt");
        Scanner fileScanner = new Scanner(file);

        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        Set<String> set = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        int count1 = 0;
        int count2 = 0;
        int key = 1;

        //Scans the entire file
        while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);

            //Scans line by line
            while (lineScanner.hasNext()) {
                String pwd = lineScanner.next();
                String pwd2 = sortString(pwd);

                map.put(key, pwd);
                set.add(pwd);

                map2.put(key, pwd2);
                set2.add(pwd2);
                key++;
            }
            lineScanner.close();

            //Checking the set and map sizes
            if (set.size() == map.size()) {
                count1++;
            }

            if (set2.size() == map2.size()) {
                count2++;
            }

            //Resetting everything
            map.clear();
            map2.clear();
            set.clear();
            set2.clear();
            key = 0;
        }
        System.out.println("Part 1: " + count1);
        System.out.println("Part 2: " + count2);

    }

    /**
     * Sort string letter into alphabetical order
     * @param pass
     * @return
     */
    private static String sortString(String pass) {
        char tempArray[] = pass.toCharArray();
        Arrays.sort(tempArray);

        return new String(tempArray);
    }

}
