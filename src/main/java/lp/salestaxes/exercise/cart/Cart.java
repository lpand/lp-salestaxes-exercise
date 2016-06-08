package lp.salestaxes.exercise.cart;

import java.util.List;

import lp.salestaxes.exercise.products.Item;

public interface Cart {
	
	Cart addProduct(Item product);
	
	Cart addImportedProduct(Item product);
	
	List<CartItem> checkout();

	interface CartItem {
		
		String getDescription();
				
		/**
		 * The price tax included of the item.
		 * @return the price of the item.
		 */
		double getPrice();
		
		/**
		 * Total amount of taxes applied.
		 * @return total amount of taxes.
		 */
		double getTaxes();
		
	}
}
