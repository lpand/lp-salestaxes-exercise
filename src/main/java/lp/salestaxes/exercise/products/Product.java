package lp.salestaxes.exercise.products;

public interface Product {

	/**
	 * Name or description of the product.
	 * @return name or description.
	 */
	String getName();
	
	/**
	 * Product net price.
	 * 
	 * @return price.
	 */
	double getPrice();
	
	/**
	 * @return the quantity of this product.
	 */
	int getQty();
	
}
