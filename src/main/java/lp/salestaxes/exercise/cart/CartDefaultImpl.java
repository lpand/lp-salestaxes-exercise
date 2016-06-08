package lp.salestaxes.exercise.cart;

import java.util.List;

import lp.salestaxes.exercise.products.Item;

public class CartDefaultImpl implements Cart {
	
	public CartDefaultImpl(Taxes taxes) {
		
	}

	public Cart addProduct(Item product) {
		// TODO Auto-generated method stub
		return null;
	}

	public Cart addImportedProduct(Item product) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CartItem> checkout() {
		// TODO Auto-generated method stub
		return null;
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
			double cost = item.getCost();
			return taxes * cost + cost;
		}

		public double getTaxes() {
			return taxes;
		}
		
	}

}
