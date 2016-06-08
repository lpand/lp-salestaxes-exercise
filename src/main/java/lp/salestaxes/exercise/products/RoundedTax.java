package lp.salestaxes.exercise.products;

public class RoundedTax implements Tax {
	
	private final Tax tax;

	public RoundedTax(Tax tax) {
		this.tax = tax;
	}

	@Override
	public boolean hasTaxes(Item item) {
		return tax.hasTaxes(item);
	}

	@Override
	public double getTaxes(Item item) {
		double t = tax.getTaxes(item);
		return Math.ceil(t * 20) / 20.0;
	}

}
