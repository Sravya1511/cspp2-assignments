/*This is program.*/
import java.util.Scanner;
/**
    *Do not modify this main function.
    */
final class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);      
        int n = s.nextInt();
        System.out.println(numberOf(n));
    }

    static int numberOf(final int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            // System.out.println(i);
            int j = i;
            while (j != 0) {
                int x;
                x = j % 10;
                if (x == 7) {
                    count = count + 1;
                    // System.out.println(count);
                }
                j = j / 10;
            }
        }
        return count;
    }

}
