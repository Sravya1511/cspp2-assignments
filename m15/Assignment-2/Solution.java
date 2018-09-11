import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;
/**
 *
 * Exception for signaling invalid errors.
 */
class InvalidException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      s     { parameter_description }
     */
    InvalidException(final String s) {
        super(s);
    }
}
/**
 * Class for sorted set.
 */
/**program.**/
class SortedSet extends Set {
    /**
     * { var_description }.
     */

    private int[] array;
    /**
     * { var_description }.
     */
    private int si;

    /**
     * Constructs the object.
     */

    SortedSet() {


    }

    SortedSet(final int[] a) {
        for(int i : a) {
            add(i);
        }
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     */


    public void add(final int item) {
        if (!contains(item)) {
            int index = getIndex(item);
            add(index, item);
        }
    }
    /**
     * Gets the index.
     *
     * @param      item  The item
     *
     * @return     The index.
     */
    public int getIndex(final int item) {
        for (int i = 0; i < size(); i++) {
            if (item <= this.get(i)) {
                return i;
            }
        }
        return size();
    }


    /**
     * { function_description }.
     *
     * @param      start      The start
     * @param      stop       The stop
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     Exception  { exception_description }
     */
    public int[] subSet(final int start, final int stop) throws Exception {
        int[] arr = new int[size()];
        int j = 0;
        if (start > stop) {
throw new InvalidException("Invalid Arguments to Subset Exception");

        } else {
        for (int i : set) {

            if (i >= start && i < stop && i != 0) {
                arr[j] = i;
                j++;

            }
        }

    }
    return Arrays.copyOf(arr, j);

    }
    /**
     * { function_description }.
     *
     * @param      stop       The stop
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     Exception  { exception_description }
     */


    public String headSet(final int stop) throws Exception {
        SortedSet ss = new SortedSet();
        int j = 0;
        for (int i : set) {
            if (i < stop && i != 0) {
                ss.add(i);
                j++;


            }
        }
        if (j == 0) {
            throw new InvalidException("Set Empty Exception");
        }
        else {
            return ss.toString();
        }


    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     Exception  { exception_description }
     */

    public int last() throws Exception {
        if (size == 0) {
            throw new InvalidException("Set Empty Exception");
        } else {
            return set[size - 1];
        }


    }

    // public void add(int item) {
    //  if(size() == 0) {
    //      array[size()] = item;
    //         setSize(size()+1);
    //     }
    //     int i;
    //     for(i = 0; i<size(); i++) {
    //      if(array[i] > item) {
    //          break;
    //      }
    //     }
    //     for(int j = size()-1; j>i; j--){
    //      array[j+1] = array[j];
    //     }
    //     array[i] = item;
    //     setSize(size()+1);
    // }


}
/**
 * Class for solution.
 */

public final class Solution {
    /**
     * Constructs the object.
     */

    private Solution() {

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
                try {
                    int[] res = s.subSet(Integer.parseInt(a[0]),
                    Integer.parseInt(a[1]));

                System.out.println(
                        Arrays.toString(res).
                        replace("[", "{").replace("]", "}"));

                } catch (Exception m) {
System.out.println("Invalid Arguments to Subset Exception");
                }


                break;
                case "headSet":
                // int a = input.nextInt();
                // int b = input.nextInt();
                try {
System.out.println(s.headSet(Integer.parseInt(tokens[1])));
                } catch (Exception m) {
                    System.out.println("Set Empty Exception");
                }

                break;
                case "last":
                try {
                    System.out.println(s.last());
                } catch (Exception m) {
                    System.out.println("Set Empty Exception");
                }
                break;
                case "intersection":
                Set s1 = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s1.addAll(intArray);
                intArray = intArray(tokens[2]);
                t.addAll(intArray);
                System.out.println(s1.intersection(t));
                break;
                case "retainAll":
                Set s2 = new Set();
                intArray = intArray(tokens[1]);
                s2.addAll(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s2.retainAll(intArray));
                break;
                default:
                break;

            }
        }
    }
}



// class Solution {
//  public static void main(String[] args) {
//      SortedSet obj = new SortedSet();
//      Scanner sc = mew Scanner(System.in);
//      int m = Integer.parseInt(sc.nextLine());
//      while(m > 0) {
//          m--;
//          String token = s.nextLine().split(" ");
//          switch(token[0]) {
//              case "add":
//              String[] input = tokens[1].split(",");
//              int[] arr = new int[input.length];
//              for(int i = 0; i <input.length; i++)
//                  arr[i] = Integer.parseInt(input[i]);
//              obj.addAll(input);
//              break;
//              case "addAll":
//              break;
//              case "subSet":
//              break;
//              case "headSet":
//              break;
//              case "last":
//              break;
//              default:
//              break;
//          }
//      }
//   }
// }