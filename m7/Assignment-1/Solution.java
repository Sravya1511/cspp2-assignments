import java.util.Scanner;
/**This is a program.**/
final class InputValidator {
    /**
     * @param input comment
     */
    private int l;
    /**
     * @param input The input
     */
    InputValidator(final String input) {
        l = input.length();
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    boolean validateData() {
        final int six = 6;
        if (l >= six) {
            return true;
        }
        return false;
    }
}
/*Program.*/
/**
 * { item_description }.
 */
final class Solution {
    /**
     * '{ item_description }.
     */
    private Solution() { }
    /**
     * @param args vaLue
     */
    public static void main(final String[] args) {
        /**
         * { var_description }.
         */
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }
}

