/*This is program.*/
import java.util.Scanner;
/**
    *Do not modify this main function.
    */
final class Solution {
   /**
    *Do not modify this main function.
    */
    private Solution() { }
    /**
    * @param args comment.
    */
/* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(numberOf(n));
    }
    /**
     * { function_description }
     *
     * @param      n     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */

    static int numberOf(final int n) {
        int count = 0;
        final int ten = 10;
        final int seven = 7;
        for (int i = 1; i <= n; i++) {
            // System.out.println(i);
            int j = i;
            while (j != 0) {
                int x;
                x = j % ten;
                if (x == seven) {
                    count = count + 1;
                    // System.out.println(count);
                }
                j = j / ten;
            }
        }
        return count;
    }

}
