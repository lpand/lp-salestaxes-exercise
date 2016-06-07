package lp.salestaxes.exercise.billing;

import lp.salestaxes.exercise.products.Product;

public interface Receipt {
	
	String print();
	
	interface ReceiptEntry {
		Product getProduct();
		double getTaxes();
	}

}
