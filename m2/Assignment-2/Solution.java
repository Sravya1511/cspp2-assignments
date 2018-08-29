
import java.util.Scanner;
// import java.lang.Math;
/**This is a program.**/
final class Solution {
    /**
    *Do not modify this main function.
    */
    private Solution() { }
    /**
    * @param args comment
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootEquation(a, b, c);
    }
    /**
    * @param a a is a variable
    * @param b b is a variable
    * @param c c is a variable
    */
    static void rootEquation(final int a, final int b, final int c) {
        /**
        *function
        */
        final int t = 2;
        double d = Math.sqrt((b * b) - (t * t * a * c));

        // double root1, root2;
        double root1 = (-b + d) / (t * a);
        double root2 = (-b - d) / (t * a);
        System.out.println(root1 + " " + root2);
    }
    /**
    *Need to write the rootsOfQuadraticEquation function and print the output.
    */
}

