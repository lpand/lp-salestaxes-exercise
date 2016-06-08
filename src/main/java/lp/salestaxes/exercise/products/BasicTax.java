package lp.salestaxes.exercise.products;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class BasicTax extends SimpleTax {

	private Set<Category> cats;

	/**
	 * It taxes an item only if it has not one of the specified categories.
	 * 
	 * @param cats Categories exempted from taxes.
	 * @param tax tax amount. A number in the interval [0, 1].
	 */
	public BasicTax(Collection<Category> cats, double tax) {
		super(tax);
		this.cats = new HashSet<Category>(cats);
	}

	public boolean hasTaxes(Item item) {
		Set<Category> itemCats = item.getCategories();
		itemCats.retainAll(cats);
		return itemCats.isEmpty();
	}

}
