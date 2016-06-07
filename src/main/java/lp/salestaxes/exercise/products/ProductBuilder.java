package lp.salestaxes.exercise.products;

public interface ProductBuilder {

	ProductBuilder setQty(int quantity);
	
	ProductBuilder setName(String name);
	
	ProductBuilder setPrice(double price);
	
	/**
	 * @param tax A tax to apply to the product being built.
	 * @return
	 */
	ProductBuilder addTax(Tax tax);
	
	Product get();
	
	
	interface Tax {
		/**
		 * Given a product computes the tax to apply to it.
		 * @param product Taxed product.
		 * @return The tax to apply.
		 */
		double getTax(Product product);
	}
}
