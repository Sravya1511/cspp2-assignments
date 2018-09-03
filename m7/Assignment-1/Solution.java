/*This is a program.*/
import java.util.Scanner;
final class InputValidator {
	/*Write the atrributes and methods for InputValidator*/
	/**
	 * { var_description }
	 */
	String input;



	InputValidator(final String input) {
		this.input = input;
	}
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
	boolean validateData() {
		int l = input.length();
        if (l >= 6) {
        	return true; }
    
        return false; 
        
	}
}
/*Program.*/
final class Solution {
	/**
	 * '{ item_description }.
	 */
	private Solution() {
		
	}
	public static void main(final String args[]) {
    	Scanner s = new Scanner(System.in);
    	String input = s.next();
    	InputValidator i = new InputValidator(input);    	
    	System.out.println(i.validateData());
    }
}
