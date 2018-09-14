import java.util.Scanner;
/**program.**/
final class Solution {
    /**
     * Constructs the object.
     */

    private Solution() {

    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        ShoppingCart shopping = new ShoppingCart();
        Scanner input = new Scanner(System.in);
        int lines = Integer.parseInt(input.nextLine());
        for (int i = 0; i < lines; i++) {
            String[] tokens = input.nextLine().split(" ");

            switch (tokens[0]) {
                case "Item":
                String[] check = tokens[1].split(",");
    shopping.addToCatalog(new Item(check[0], check[1], check[2]));
                    break;
                case "add":
                    String[] check1 = tokens[1].split(",");
    shopping.addToCart(new Item(check1[0], check1[1]));
                    break;
                case "catalog":
                    shopping.showCatalog();
                    break;
                case "show":
                    shopping.showCart();
                    break;
                case "totalAmount":
    System.out.println("totalAmount: " + shopping.getTotalAmount());
                    break;
                case "payableAmount":
    System.out.println("Payable amount: " + shopping.getPayableAmount());
                    break;
                case "remove":
                    String[] check2 = tokens[1].split(",");
    shopping.removeFromCart(new Item(check2[0], check2[1]));
                    break;
                case "coupon":
                    shopping.applyCoupen(tokens[1]);
                    break;
                case "print":
                    System.out.println("Name   " + "quantity   " + "Price");
                    shopping.printInvoice();
                    break;
                default:
                break;
            }
        }
    }
}

