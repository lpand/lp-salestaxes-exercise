package lp.salestaxes.exercise.cart;

import lp.salestaxes.exercise.products.Item;

public interface Taxes {
	
	double getTaxes(Item product);
	
}
