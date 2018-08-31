/**This is a program.*/
import java.util.*;
final class Solution {
     /**
    *Do not modify this main function.
    */
    private Solution() { }
    /**
    * @param args comment.
    */

    public static void main(final String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
    /**
     * { function_description }.
     *
     * @param      s     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    static String reverseString(final String s) {
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            String str = Character.toString(c);
            rev = rev + str;
        }
    return rev;
    }
    //Write reverseString function
}
