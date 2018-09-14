import java.util.*;
class Item {
	String productName;
	int quantity;
	double unitPrice;

	Item(String n, String q, String p) {
		productName = n;
		quantity = Integer.parseInt(q);
		unitPrice = Double.parseDouble(p);
	}

	 Item(String n, String q) {
		productName = n;
		quantity = Integer.parseInt(q);
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
	String[] validcoupons = {"IND10", "IND20", "IND30", "IND50"};
	static double discount = 0.0;
	static boolean couponApplied = false;

	ShoppingCart() {
		catalogArray = new Item[20];
		cartArray = new Item[20];
		sizeCatalog = 0;
		sizeCart = 0;
	}

	public void addToCatalog(Item item) {
		catalogArray[sizeCatalog++] = item;
	}

	public boolean inCart(Item item) {
		for(Item s: cartArray) {
			if(s!=null) {
				if(s.productName.equals(item.productName)) {
					s.quantity +=item.quantity;
					return true;
				}

			}
		}
		return false;
	}

	public void addToCart(Item item) {
		if(!inCart(item)) {
		if(checkCatalog(item)) {
			cartArray[sizeCart++] = item;
		}
		}


	}

	private boolean checkCatalog(Item item) {
		for(Item i : catalogArray) {
			if(i!= null) {
				if(i.productName.equals(item.productName)) {
					if(item.quantity <= item.quantity) {
						i.quantity -= item.quantity;
						return true;
					}
				}
			}
		}
		return false;
	}

	public void removeFromCart(Item item) {
		for(int i = 0; i<sizeCart; i++) {
			if(cartArray[i].productName.equals(item.productName)) {
				cartArray[i].quantity -= item.quantity;
			}

		}
	}



	public void showCatalog() {
		for(int i = 0; i<sizeCatalog; i++) {
			System.out.println(catalogArray[i]);
		}
	}

	public void showCart() {
        for(int i = 0; i<sizeCart; i++) {
        	if(cartArray[i].quantity!=0) {
        		System.out.println(cartArray[i].productName+" "+cartArray[i].quantity);
        	}


		}
	}

	public double getTotalAmount() {
		double total = 0;
		for(int i = 0; i<sizeCart; i++) {
			total = total+cartArray[i].quantity*getPrice(cartArray[i]);
		}
		return total;
	}

	double getPrice(Item given) {
		for(Item i : catalogArray) {
			if(i!= null) {
				if(i.productName.equals(given.productName)) {
					return i.unitPrice;
				}
			}
		}
		return 0.0;
	}
	void applyCoupen(String coupon) {
		if(couponApplied) {
			// System.out.println("Invalid coupon");
			return;
		}
		boolean x = false;
		for(String s : validcoupons) {
			if(s.equals(coupon)) {
				int num = Integer.parseInt(coupon.substring(3));
				discount = getTotalAmount()*num/100;
				couponApplied = true;
				x = true;
			}
		}
		if(!x) {
			System.out.println("Invalid coupon");
			return;
		}

	}

	public void printInvoice() {
		for(Item i: cartArray) {
			if(i!=null) {
				if(i.quantity!=0) {
					System.out.println(i.productName+" "+i.quantity+" "+getPrice(i));
				}

			}

		}
		double amount;
		double amo = (getTotalAmount()-discount);
		double tax = amo*15/100;
		System.out.println("Total:"+getTotalAmount());
		System.out.println("Disc%:"+discount);
		System.out.println("Tax:"+tax);
		System.out.println("Payable amount: "+getPayableAmount());

	}

	public double getPayableAmount() {
		double amount;
		double amo = (getTotalAmount()-discount);
		double tax = amo*15/100;
		amount = amo+tax;
		return amount;

    }
}
