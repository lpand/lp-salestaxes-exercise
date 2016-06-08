package lp.salestaxes.exercise.products;

public class ImportTax implements Tax {

	private final double tax;

	/**
	 * {@code tax} is that number which is multiplied by the 
	 * item cost to get the total taxes amount.
	 * 
	 * @param tax a number in the interval [0, 1].
	 */
	public ImportTax(double tax) {
		this.tax = tax;
	}

	public double getTaxes(Item item) {
		return item.getCost() * tax;
	}

	public boolean hasTaxes(Item product) {
		return product instanceof ImportedProduct;
	}

}
