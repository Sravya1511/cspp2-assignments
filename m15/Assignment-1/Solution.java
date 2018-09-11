import java.util.*;
import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Exception for signaling invalid errors.
 */
/**program.**/

class InvalidException extends Exception {
	InvalidException(final String s) {
		super(s);
	}
}
/**
 * Class for solution..
 */
class Solution {
	/**
	 * { var_description }.
	 */
	private int[] list;
	/**
	 * { var_description }.
	 */
    private int size;
    /**
     * Constructs the object..
     *
     * @param      capacity  The capacity
     */
    Solution(final int capacity) {
        size = 0;
        list = new int[capacity];
    }
    /**
     * Constructs the object.
     */
	Solution() {
		final int ten = 10;
		list = new int[ten];
		size = 0;
	}
	/**
	 * { function_description }.
	 *
	 * @param      item  The item
	 */

	public void add(final int item) {
		list[size++] = item;
	}
	/**
	 * { function_description }.
	 *
	 * @return     { description_of_the_return_value }
	 */

	public int size() {
		return size;
	}
	/**
	 * { function_description }.
	 *
	 * @param      x     { parameter_description }
	 */

	private void resize(final int x) {
        list = Arrays.copyOf(list, 2 * x);
    }
    /**
     * { function_description }.
     *
     * @param      index      The index
     *
     * @throws     Exception  { exception_description }
     */

	public void remove(final int index) throws Exception {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
        } else {
            throw new InvalidException("Invalid Position Exception");
        }
    }
    /**
     * { function_description }.
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */

    public int get(final int index) {
        if (index < 0 || index >= size) {
            return -1;
        } else {
            return list[index];
        }
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */

    public String toString() {
        if (size == 0) {
            return "[]";
        }
        String str = "[";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + list[i] + ",";
        }
        str = str + list[i] + "]";
        return str;
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */

    public boolean contains(final int item) {
        return indexOf(item) == -1;
    }
    /**
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */

    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (item == list[i]) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Adds all..
     *
     * @param      items  The items
     */

    public void addAll(final int[] items) {
        if (items.length > list.length) {

            resize(list.length);
        }
           for (int i : items) {
            list[size] = i;
            size++;
        }
    }
    /**
     * { function_description }.
     *
     * @param      index  The index
     * @param      item   The item
     */

    public void add(final int index, final int item) {
        if (index < 0) {
            System.out.println("Negative Index Exception");
        } else if (index == 0) {
            list[size++] = item;
        } else {
            for (int i = (size); i > index; i--) {
            list[i] = list[i - 1];
            // System.out.println(Arrays.toString(list));
        }
        list[index] = item;
        size++;
        }
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */

    public int count(final int item) {
         // write the logic
        int c = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == item) {
                c = c + 1;
            }
        }
        return c;
    }
    /**
     * Removes all.
     *
     * @param      newArray   The new array
     *
     * @throws     Exception  { exception_description }
     */

    public void removeAll(final int[] newArray) throws Exception {
        for (int i = 0; i < size; i++) {
             for (int j = 0; j < newArray.length; j++) {
                if (list[i] == newArray[j]) {
                    remove(i);
                    i--;
                    break;
                }
            }
        }
    }
    /**
     * { function_description }.
     *
     * @param      start      The start
     * @param      end        The end
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     Exception  { exception_description }
     */

    public Solution subSolution(final int start, final int end) throws Exception {
        if (start < 0 || end < 0 ||
        	start > end || start == end || size == 0) {
            throw new InvalidException("Index Out of Bounds Exception");
        } else {
            int x = end - start;
        Solution l2 = new Solution(x);
        for (int i = start; i < end; i++) {
            l2.add(list[i]);
        }
        return l2;
        }
    }
    /**
     * { function_description }.
     *
     * @param      listt  The listt
     *
     * @return     { description_of_the_return_value }
     */

    public boolean equals(final Solution listt) {
    if (this.size != listt.size) {
        return false;
    }
    int c = 0;
    for (int i = 0; i < this.size; i++) {
       if (this.list[i] != listt.list[i]) {
         return false;
        }
    }
    return true;
    }
    /**
     * { function_description }.
     */

    public void clear() {
        size = 0;
    }
    /**
     * .
     *
     * @param      args  The arguments.
     */


    public static void main(final String[] args) {
        // create an object of the list to invoke methods on it
        Solution l = new Solution();

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
                case "add":
                    if (tokens.length == 2) {
                        String[] t = tokens[1].split(",");
                        if (t.length == 1) {
                            l.add(Integer.parseInt(tokens[1]));
                        }
                    }
                break;
                case "size":
                    System.out.println(l.size());
                break;
                case "print":
                    System.out.println(l);
                break;
                case "remove":
                    if (tokens.length == 2) {
                    try {
                    	l.remove(Integer.parseInt(tokens[1]));
                    } catch (Exception m) {
                    	System.out.println("Invalid Position Exception");
                    }
                }
                break;
                case "indexOf":
                    if (tokens.length == 2) {
                        System.out.println(l.indexOf(
                            Integer.parseInt(tokens[1])));
                    }
                break;
                case "get":
                    if (tokens.length == 2) {
                        System.out.println(l.get(
                            Integer.parseInt(tokens[1])));
                    }
                break;
                case "contains":
                    if (tokens.length == 2) {
                        System.out.println(l.contains(
                            Integer.parseInt(tokens[1])));
                    }
                break;
                case "count":
                    if (tokens.length == 2) {
                        System.out.println(l.count(
                            Integer.parseInt(tokens[1])));
                    }
                break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        int[] temp = new int[t1.length];
                        for (int i = 0; i < temp.length; i++) {
                            temp[i] = Integer.parseInt(t1[i]);
                        }
                        l.addAll(temp);
                    }
                break;
                case "removeAll":
                    if (tokens.length == 2) {
                    	try {
                        String[] t2 = tokens[1].split(",");
                        int[] a = new int[t2.length];
                        for (int i = 0; i < t2.length; i++) {
                            a[i] = Integer.parseInt(t2[i]);
                        }
                        l.removeAll(a);
                    } catch (Exception m) {
                    	System.out.println("Invalid Position Exception");
                    }

                    	}

                break;
                case "subList":
                    if (tokens.length != 2) {
                     break;
                    }
                    try {
                    	String[] arrstring3 = tokens[1].split(",");
               Solution obje = l.subSolution(Integer.parseInt(arrstring3[0]),
                            Integer.parseInt(arrstring3[1]));
                    if (obje != null) {
                        System.out.println(obje);
                    }

                    } catch (Exception m) {
                    	System.out.println("Index Out of Bounds Exception");
                    }

                    break;

                case "equals":
                    if (tokens.length == 2) {
                        String[] lt = tokens[1].split(",");
                        Solution l2 = new Solution();
                        for (int k = 0; k < lt.length; k++) {
                            l2.add(Integer.parseInt(lt[k]));
                        }
                        System.out.println(l.equals(l2));
                    }
                break;
                case "clear":
                    l.clear();
                break;
                default:
                break;
            }
        }
    }
}






