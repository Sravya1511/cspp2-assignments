/*This is a program.*/
import java.util.Scanner;
/**
 * Class for solution.
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
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
           // System.out.println(s+"ss");
            String res = binaryToDecimal(s);
            System.out.println(res);
        }
    }
    /**
     * { function_description }.
     *
     * @param      s     { parameter_description }.
     *
     * @return     { description_of_the_return_value }
     */
    static String binaryToDecimal(final String s) {
      double sum =  0;
      int count = 0;
      for (int i = s.length() - 1; i >= 0; i--) {
        char ch = s.charAt(i);
        // System.out.println("Character at "+i+" Position: "+ch)
        int x = Character.getNumericValue(ch);
        // System.out.println(x);
        sum = sum + (x * Math.pow(2, count));
        count++;
      }
      return String.format("%.0f", sum);
    }
}
