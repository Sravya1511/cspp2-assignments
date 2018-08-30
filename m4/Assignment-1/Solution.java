import java.util.Scanner;
/**This is a comment.**/
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
        int n = sc.nextInt();
        int[] arr;
        arr = new int[n];
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if (temp < arr[i]) {
                temp = arr[i];
            }
        }
        System.out.println(temp);

    }
}
