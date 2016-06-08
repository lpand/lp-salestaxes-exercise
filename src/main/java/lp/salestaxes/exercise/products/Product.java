package lp.salestaxes.exercise.products;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Product {
	
	private final String name;
	private final double cost;
	private final int qty;
	private final Set<Category> cats;
	
	public Product(String name, double cost, int quantity, Collection<Category> cats) {
		this.name = name;
		this.cost = cost * quantity;
		this.qty = quantity;
		this.cats = new HashSet<Category>(cats);
	}
	
	public Product(String name, double cost, int quantity, Category category) {
		this(name, cost, quantity, Arrays.asList(category));
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

	/**
	 * Categories this product belongs to.
	 * @return Categories this product belongs to.
	 */
	public Set<Category> getCategories() {
		return new HashSet<Category>(cats);
	}
	
}
