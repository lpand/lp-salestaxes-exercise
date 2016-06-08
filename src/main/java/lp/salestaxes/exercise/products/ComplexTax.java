package lp.salestaxes.exercise.products;

import java.util.LinkedList;
import java.util.List;

public class ComplexTax implements Tax {
	
	List<Tax> taxes = new LinkedList<Tax>();
	
	public ComplexTax addTax(Tax tax) {
		taxes.add(tax);
		return this;
	}

	public boolean hasTaxes(Item item) {
		return taxes.stream()
				.anyMatch(tax -> tax.hasTaxes(item));
	}

	public double getTaxes(Item item) {
		double t = 0;
		for (Tax tax : taxes) if (tax.hasTaxes(item)) {
			t += tax.getTaxes(item);
		}
		return t;
	}

}
