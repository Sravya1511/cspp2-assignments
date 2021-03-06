
import java.io.File;
import java.io.IOException;
// import java.util.HashMap;
// import java.util.Hashtable;
// import java.util.Map;
import java.util.Scanner;
// import java.io.*;
import java.util.NoSuchElementException;


/**
 * Class for solution..
 */

final class Solution {
    /**
     * { function_description }.
     *
     * @param      args         The arguments
     *
     * @throws     IOException  { exception_description }
     */
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { function_description }.
     *
     * @param      args         The arguments
     *
     * @throws     IOException  { exception_description }
     */
    public static void main(final String[] args) throws IOException {
        double max = 0;
        int a = 0;
        int b = 0;
        // StringMatching match = new StringMatching();
        Scanner input = new Scanner(System.in);
        try {
            String x = input.nextLine();
            File file = new File(x);
            File[] files = file.listFiles();
            System.out.print("             ");
            for (int i = 1; i <= files.length; i++) {
                System.out.print("file" + i + ".txt" + "    ");
            }
            System.out.println();

            for (int i = 0; i < files.length; i++) {
                int h = i + 1;
                   System.out.print("file" + h + ".txt");
                for (int j = 0; j < files.length; j++) {
                        StringMatching match = new StringMatching();
                        try {
                            Scanner s = new Scanner(files[i]);
                        String line = s.useDelimiter("\\A").next();
                        match.str1(line);
                        String[] tokens = line.toLowerCase().split(" ");
                        } catch (NoSuchElementException e) {
                            System.out.print("          0.0");
                        } catch (NullPointerException e) {
                            System.out.print("");
                        }
                        try {
                            Scanner s1 = new Scanner(files[j]);
                        String line1 = s1.useDelimiter("\\A").next();
                        match.str2(line1);
                        String[] tokens1 =
                        line1.toLowerCase().split(" ");

                        double p = match.compare();
                        // System.out.print("        ");
                        System.out.format("%13.1f", p);

                        if (p > max && i != j) {
                             a = i + 1;
                             b = j + 1;
                             max = p;
                            }

                        } catch (NoSuchElementException e) {
                            System.out.print("          0.0");
                        } catch (NullPointerException e) {
                            System.out.print("");
                        }


                }
                System.out.println();
            }
            System.out.println("Maximum similarity is between "
                + "file" + a + ".txt and file" + b + ".txt");
            } catch (NoSuchElementException e) {
                System.out.println("Empty Directory");
            }
        }
    }

