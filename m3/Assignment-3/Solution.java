/*This is a program.*/
import java.util.Scanner;
/**
    Do not modify this main function.
    */
final class Solution {
     /**
    *Do not modify this main function.
    */
    private Solution() { }
    /**
    * @param args comment
    */

    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        gcd(n1, n2);
        System.out.println(gcd(n1, n2));
    }
    /*
    Need to write the gcd function and print the output.
    */
    /**
     * { function_description }
     *
     * @param      n1    The n 1
     * @param      n2    The n 2
     *
     * @return     { description_of_the_return_value }
     */
    static int gcd(final int n1, final int n2) {
        int a = n1;
        int b = n2;
        while (b != 0) {
            int r = a % b;
            if (r == 0) {
                return b;
            } else {
                a = b;
                b = r;
            }
        }
        return b;
    }

}
