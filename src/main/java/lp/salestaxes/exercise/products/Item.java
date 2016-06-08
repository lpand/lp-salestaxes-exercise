package lp.salestaxes.exercise.products;

import java.util.Set;

public interface Item {

	/**
	 * Name or description of the product.
	 * @return name or description.
	 */
	String getName();

	/**
	 * Product cost.
	 * 
	 * @return cost.
	 */
	double getCost();

	/**
	 * @return the quantity of this product.
	 */
	int getQty();

	/**
	 * Categories this product belongs to.
	 * @return Categories this product belongs to.
	 */
	Set<Category> getCategories();

}