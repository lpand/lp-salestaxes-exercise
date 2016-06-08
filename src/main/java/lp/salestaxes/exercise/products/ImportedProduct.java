package lp.salestaxes.exercise.products;

import java.util.Set;

public class ImportedProduct implements Item {
	private static final String PREFIX_ID = "imported ";
	
	private Item prod;

	public ImportedProduct(Item prod) {
		this.prod = prod;
	}

	public String getName() {
		return PREFIX_ID.concat(prod.getName());
	}

	public double getCost() {
		return prod.getCost();
	}

	public int getQty() {
		return prod.getQty();
	}

	public Set<Category> getCategories() {
		return prod.getCategories();
	}

	public Item getItem() {
		return prod;
	}

}
