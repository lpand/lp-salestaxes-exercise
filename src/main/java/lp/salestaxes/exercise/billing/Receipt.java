package lp.salestaxes.exercise.billing;

import lp.salestaxes.exercise.products.Item;

public interface Receipt {
	
	String print();
	
	interface ReceiptEntry {
		Item getProduct();
		double getTaxes();
	}

}
