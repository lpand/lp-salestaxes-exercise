package lp.salestaxes.exercise.cart;

import static lp.salestaxes.exercise.products.Category.BOOK;
import static lp.salestaxes.exercise.products.Category.FOOD;
import static lp.salestaxes.exercise.products.Category.MEDICAL;

import java.util.Arrays;
import java.util.Locale;

import lp.salestaxes.exercise.billing.Receipt;
import lp.salestaxes.exercise.billing.ReceiptDefaultImpl;
import lp.salestaxes.exercise.products.BasicTax;
import lp.salestaxes.exercise.products.ComplexTax;
import lp.salestaxes.exercise.products.ImportTax;
import lp.salestaxes.exercise.products.RoundedTax;


public class Carts {

	/**
	 * For testing.
	 * 
	 * @param basicTax number between [0,1].
	 * @param importTax number between [0,1].
	 * @return default cart.
	 */
	public static Cart newDefaultCart(double basicTax, double importTax) {
		ComplexTax complexTax = new ComplexTax();
		complexTax.addTax(new RoundedTax(new BasicTax(Arrays.asList(FOOD, MEDICAL, BOOK), basicTax)));
		complexTax.addTax(new RoundedTax(new ImportTax(importTax)));
		return new CartDefaultImpl(complexTax);
	}
	
	public static Receipt newDefaultReceipt(Locale loc, Cart cart) {
		return new ReceiptDefaultImpl(loc, cart.checkout());
	}
}
