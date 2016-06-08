package lp.salestaxes.exercise.products;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Product implements Item {
	
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
	
	/* (non-Javadoc)
	 * @see lp.salestaxes.exercise.products.Item#getName()
	 */
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see lp.salestaxes.exercise.products.Item#getCost()
	 */
	public double getCost() {
		return cost;
	}
	
	/* (non-Javadoc)
	 * @see lp.salestaxes.exercise.products.Item#getQty()
	 */
	public int getQty() {
		return qty;
	}

	/* (non-Javadoc)
	 * @see lp.salestaxes.exercise.products.Item#getCategories()
	 */
	public Set<Category> getCategories() {
		return new HashSet<Category>(cats);
	}
	
}
