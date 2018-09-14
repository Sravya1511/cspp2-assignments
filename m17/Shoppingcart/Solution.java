import java.util.*;
class Item {
	String productName;
	int quantity;
	double unitPrice;

	Item(String n, int q, double p) {
		productName = n;
		quantity = q;
		unitPrice = p;
	}

	public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append(productName + " ");
            sb.append(quantity + " ");
            sb.append(unitPrice);
        return sb.toString();
    }
}

class ShoppingCart {
	Item[] catalogArray;
	Item[] cartArray;
	int sizeCatalog;
	int sizeCart;

	ShoppingCart() {
		catalogArray = new Item[20];
		cartArray = new Item[20];
		sizeCatalog = 0;
		sizeCart = 0;
	}

	public void addToCatalog(Item item) {
		catalogArray[sizeCatalog++] = item;
	}

	public void addToCart(Item item) {
		cartArray[sizeCart++] = item;
	}

	public void removeFromCart(Item item) {
		for(int i = 0; i<sizeCart; i++) {
			if(cartArray[i].productName.equals(item.productName)) {
				cartArray[i].quantity -= item.quantity;
			}

		}
	}

	public void catalog() {
		for(int i = 0; i<sizeCatalog; i++) {
			System.out.println(catalogArray[i]);
		}
	}
}

class Solution {
	public static void main(String[] args) {
		ShoppingCart shopping = new ShoppingCart();
		Scanner input = new Scanner(System.in);
		int lines = input.nextInt();
		for(int i = 0; i<lines; i++) {
			String[] tokens = input.nextLine().split(",");
			String[] check = tokens[0].split(" ");
			switch(check[0]) {
				case "Item":
				    shopping.addToCatalog(new Item((check[1]), Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2])));
				    break;

				// case "add":
				//     shopping.addToCart(new Item(()))
				//
				case "catalog":
				    shopping.catalog();

			}
		}
	}
}

