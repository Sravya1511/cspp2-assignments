import java.util.*;
final class InputValidator
{
	/*Write the atrributes and methods for InputValidator*/
	/**
	 * { var_description }
	 */
	String input;



	InputValidator(String input) {
		this.input = input;
	}

	boolean validateData() {
		int l = input.length();
        if (l >= 6) {
        	return true;
        } else { 
        	return false; 
        }
	}
}
final class Solution
{
	/**
	 * '{ item_description }.
	 */
	public static void main(final String args[])
    {
    	Scanner s = new Scanner(System.in);
    	String input = s.next();
    	InputValidator i = new InputValidator(input);    	
    	System.out.println(i.validateData());
    }
}
