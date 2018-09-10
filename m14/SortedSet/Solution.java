import java.util.*;
import java.io.BufferedInputStream;
class SortedSet extends Set {

	int[] array;
	int size;

	SortedSet() {
		array = new int[10];
		size = 10;
	}




	public String subSet(int start, int stop) {
		SortedSet ss = new SortedSet();
		if (start > stop) {
			System.out.println("Invalid Arguments to Subset Exception");
		}
		else {

		int j = 0;
		for(int i : set) {

			if(i >= start && i < stop && i!=0) {
				ss.add(i);
				j++;

			}
		}
	}

		return ss.toString() ;
	}

	public String headSet(int stop) {
		SortedSet ss = new SortedSet();
		int j = 0;
		for(int i : set) {

			if(i < stop && i!=0) {
				ss.add(i);
				j++;

			}
		}

		return ss.toString() ;
	}

	public int last() {
		return set[size-1];
	}


}

class Solution {

    Solution() {

    }

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
                String [] a = tokens[1].split(",");
                System.out.println(s.subSet(Integer.parseInt(a[0]), Integer.parseInt(a[1])));
                break;
                case "headSet":
                // int a = input.nextInt();
                // int b = input.nextInt();
                System.out.println(s.headSet(Integer.parseInt(tokens[1])));
                break;
                case "last":
                System.out.println(s.last());



            }
        }
    }
}