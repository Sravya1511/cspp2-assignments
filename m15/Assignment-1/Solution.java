import java.util.*;
import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

class InvalidException extends Exception {
	InvalidException(String s) {
		super(s);
	}
}
class Solution {
	int[] list;
    int size;
    Solution(final int capacity) {
        size = 0;
        list = new int[capacity];
    }
	Solution() {
		list = new int[10];
		size = 0;
	}

	public void add(int item) {
		list[size++] = item;
	}

	public int size() {
		return size;
	}

	private void resize(final int x) {
        list = Arrays.copyOf(list, 2 * x);
    }

	public void remove(final int index) throws Exception {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
        } else {
            throw new Exception("Invalid Position Exception");
        }
    }

    public int get(final int index) {
        if (index < 0 || index >= size) {
            return -1;
        } else {
            return list[index];
        }
    }

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

    public boolean contains(final int item) {
        return indexOf(item) == -1;
    }

    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (item == list[i]) {
                return i;
            }
        }
        return -1;
    }

    public void addAll(final int[] items) {
        if (items.length > list.length) {

            resize(list.length);
        }
           for (int i : items) {
            list[size] = i;
            size++;
        }
    }

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

    public void removeAll(final int[] newArray) throws Exception{
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

    public Solution subSolution(final int start, final int end) throws Exception {
        if (start < 0 || end < 0 || start > end || start == end || size == 0) {
            throw new Exception("Index Out of Bounds Exception");
        } else {
            int x = end - start;
        Solution l2 = new Solution(x);
        for (int i = start; i < end; i++) {
            l2.add(list[i]);
        }
        return l2;
        }
    }

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

    public void clear() {
        size = 0;
    }


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
                    } catch(Exception m) {
                    	System.out.println(m);
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
                    	try{
                        String[] t2 = tokens[1].split(",");
                        int[] a = new int[t2.length];
                        for (int i = 0; i < t2.length; i++) {
                            a[i] = Integer.parseInt(t2[i]);
                        }
                        l.removeAll(a);
                    } catch(Exception m) {
                    	System.out.println(m);
                    }

                    	}

                break;
                case "subSolution":
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

                    } catch(Exception m){
                    	System.out.println(m);
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






