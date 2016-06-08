package lp.salestaxes.exercise.products;

public abstract class SimpleTax implements Tax {
	
	private final double tax;

	public SimpleTax(double tax) {
		this.tax = tax;
	}

	public double getTaxes(Item item) {
		return item.getCost() * tax;
	}

}
