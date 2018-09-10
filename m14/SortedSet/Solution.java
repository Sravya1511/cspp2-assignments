import java.util.*;
import java.io.BufferedInputStream;
import java.util.Arrays;
class SortedSet extends Set {
	/**
	 * { var_description }.
	 */

	int[] array;
	/**
	 * { var_description }.
	 */
	int si;

	/**
	 * Constructs the object.
	 */

	SortedSet() {
		array = new int[10];
		si = 0;
	}
	/**
	 * { function_description }.
	 *
	 * @param      start  The start
	 * @param      stop   The stop
	 *
	 * @return     { description_of_the_return_value }
	 */




	public int[] subSet(final int start, final int stop) {
		int[] arr = new int[size];
		int j = 0;
		if (start > stop) {
			System.out.println
			("Invalid Arguments to Subset Exception");
            return null;
		}

		else {


		for (int i : set) {

			if (i >= start && i < stop && i != 0) {
				arr[j] = i;
				j++;

			}
		}

	}
    return Arrays.copyOf(arr,j) ;

	}
	/**
	 * { function_description }.
	 *
	 * @param      stop  The stop
	 *
	 * @return     { description_of_the_return_value }
	 */

	public String headSet(final int stop) {
		SortedSet ss = new SortedSet();
		int j = 0;
		for (int i : set) {

			if (i < stop && i != 0) {
				ss.add(i);
				j++;

			}
		}

		return ss.toString();
	}
	/**
	 * { function_description }.
	 *
	 * @return     { description_of_the_return_value }
	 */

	public int last() {
		if (size == 0) {
            System.out.println("Set Empty Exception");
			return - 1;
		}
		return set[size - 1];

	}


}
/**
 * Class for solution.
 */

public class Solution {
	/**
	 * Constructs the object.
	 */

    Solution() {

    }
    /**
     * { function_description }.
     *
     * @param      s     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */

    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        SortedSet s = new SortedSet();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                s.add(intArray[0]);
                break;
                 case "addAll":
                int[] intArr = intArray(tokens[1]);
                s.addAll(intArr);
                break;
                case "subSet":
                // int a = input.nextInt();
                // int b = input.nextInt();
                String[] a = tokens[1].split(",");
                int[] res = s.subSet(Integer.parseInt(a[0]),
                	Integer.parseInt(a[1]));
                if (res != null) {
                	System.out.println(
                		Arrays.toString(res).replace("[", "{").replace("]", "}"));
                }
                break;
                case "headSet":
                // int a = input.nextInt();
                // int b = input.nextInt();
                System.out.println(s.headSet(Integer.parseInt(tokens[1])));
                break;
                case "last":
                System.out.println(s.last());
                default:
                break;



            }
        }
    }
}