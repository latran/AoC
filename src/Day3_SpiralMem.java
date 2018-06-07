/**
 * While this is very space-efficient (no squares are skipped),
 * requested data must be carried back to square 1 (the location of the only
 * access port for this memory system) by programs that can only move up, down,
 * left, or right. They always take the shortest path: the Manhattan Distance
 * between the location of the data and square 1.
 *
 * Ex:
 * 17  16  15  14  13
 18   5   4   3  12
 19   6   1   2  11
 20   7   8   9  10
 21  22  23---> ...
 */
public class Day3_SpiralMem {
    public static void main(String[] args) {
        int n = 368078;
        int sqrtNum = calcRing(n); //The odd value of the sqrt of n (605)
        int TRC, TLC, BLC, BRC, mid, n2Mid, manDist;

        TRC = (sqrtNum * sqrtNum) + sqrtNum + 1; //Top right corner num
        TLC = TRC + sqrtNum + 1; //Top left corner
        BLC = TLC + sqrtNum + 1; //Bottom left corner
        BRC = BLC + sqrtNum + 1; //Bottom right corner

        //Check corner numbers
        if (n < TRC) {
            System.out.println(n + " is somewhere on right side ring.");
            mid = (TRC + n + 1) / 2;
            n2Mid = Math.abs(mid - n);
            manDist = n2Mid + (sqrtNum + 1) / 2;
            System.out.println("Shortest path = " + manDist);
        } else if (n < TLC) {
            System.out.println(n + " is somewhere on top ring.");
            mid = (TLC + TRC) / 2;
            n2Mid = Math.abs(mid - n);
            manDist = n2Mid + (sqrtNum + 1) / 2;
            System.out.println("Shortest path = " + manDist);
        } else if (n < BLC) {
            System.out.println(n + " is somewhere on left side ring.");
            mid = (TLC + BLC) / 2;
            n2Mid = Math.abs(mid - n);
            manDist = n2Mid + (sqrtNum + 1) / 2;
            System.out.println("Shortest path = " + manDist);
        } else {
            System.out.println(n + " is somewhere on bottom ring.");
            mid = (BRC + BLC) / 2;
            n2Mid = Math.abs(mid - n);
            manDist = n2Mid + (sqrtNum + 1) / 2;
            System.out.println("Shortest path = " + manDist);
        }
    }

    /**
     * Calculates the sqrt number and returns only the square root
     * @param n
     * @return
     */
    public static int calcRing(int n) {
        int num = (int) Math.floor(Math.sqrt(n));
        int sqrtNum = 0;

        //Return the odd number from the sqrt
        if (num % 2 == 0) {
            sqrtNum = (num - 1);
            return sqrtNum;
        } else {
            return num;
        }
    }
}
