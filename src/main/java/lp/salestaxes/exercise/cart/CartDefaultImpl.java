package lp.salestaxes.exercise.cart;

import java.util.LinkedList;
import java.util.List;

import lp.salestaxes.exercise.products.ImportedProduct;
import lp.salestaxes.exercise.products.Item;

public class CartDefaultImpl implements Cart {
	
	private final Taxes taxes;

	private final List<CartItem> cartItems = new LinkedList<CartItem>();
	
	public CartDefaultImpl(Taxes taxes) {
		this.taxes = taxes;
	}

	public Cart addItem(Item item) {
		cartItems.add(new CartItemImpl(item, taxes.getTaxes(item)));
		return this;
	}

	public Cart addImportedItem(Item item) {
		return addItem(new ImportedProduct(item));
	}

	public List<CartItem> checkout() {
		return new LinkedList<CartItem>(cartItems);
	}
	
	protected static class CartItemImpl implements CartItem {
		
		private final Item item;
		private final double taxes;

		public CartItemImpl(Item item, double taxes) {
			this.item = item;
			this.taxes = taxes;
		}

		public String getDescription() {
			return item.getQty() + " " + item.getName();
		}

		public double getPrice() {
			return taxes + item.getCost();
		}

		public double getTaxes() {
			return taxes;
		}
		
	}

}
