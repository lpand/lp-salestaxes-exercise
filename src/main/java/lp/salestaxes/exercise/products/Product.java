package lp.salestaxes.exercise.products;

public class Product {
	
	private final String name;
	private final double cost;
	private final int qty;
	
	public Product(String name, double cost, int quantity) {
		this.name = name;
		this.cost = cost * quantity;
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
	 * Product cost.
	 * 
	 * @return cost.
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * @return the quantity of this product.
	 */
	public int getQty() {
		return qty;
	}
	
}
