package lp.salestaxes.exercise.products;

public class Product {
	
	private final String name;
	private final double price;
	private final int qty;
	
	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.qty = quantity;
	}

	/**
	 * Name or description of the product.
	 * @return name or description.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Product net price.
	 * 
	 * @return price.
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * @return the quantity of this product.
	 */
	public int getQty() {
		return qty;
	}
	
}
