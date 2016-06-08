package lp.salestaxes.exercise.products;

interface Tax {
	/**
	 * Given a product computes the tax to apply to it.
	 * @param product Taxed product.
	 * @return The tax to apply.
	 */
	double getTax(Item product);
}
