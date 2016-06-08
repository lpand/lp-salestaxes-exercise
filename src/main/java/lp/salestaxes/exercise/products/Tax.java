package lp.salestaxes.exercise.products;

public interface Tax {
	
	/**
	 * States if product must be taxed.
	 * @param product
	 * @return true if {@code product} must be taxed, false otherwise.
	 */
	boolean hasTaxes(Item product);
	
	/**
	 * Given a product computes the tax to apply to it.
	 * @param product Taxed product.
	 * @return The tax to apply.
	 */
	double getTaxes(Item product);
}
