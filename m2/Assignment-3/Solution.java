
import java.util.Scanner;
/**This is a program.**/
final class Solution {
    /**
    Do not modify this main function.
    */
    private Solution() { }
    /**
    * @param args comment
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**
    * @param base comment
    * @param exponent comment
    @return long value
    **/
    static long power(final int base, final int exponent) {
        /**
        *function
        */
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        } else {
            return base * power(base, exponent - 1);
        }
    }
    /**
    Need to write the power function and print the output.
    */
}

