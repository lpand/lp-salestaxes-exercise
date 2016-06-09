package lp.salestaxes.exercise;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import lp.salestaxes.exercise.cart.Cart;
import lp.salestaxes.exercise.cart.Carts;
import lp.salestaxes.exercise.products.Category;
import lp.salestaxes.exercise.products.Product;

public class ExerciseTest {

	@Test
	public void output1() {
		System.out.println("Output1: ");
		System.out.println(getReceipt1());
		assertThat("Output1 does not match expected", getReceipt1(), is(expectedReceipt1()));
	}
	
	String getReceipt1() {
		return receipt(getCart1());
	}
	
	Cart getCart1() {
		Cart c = newCart();
		c.addItem(new Product("book", 12.49, Category.BOOK));
		c.addItem(new Product("music CD", 14.99, Category.MUSIC));
		c.addItem(new Product("chocolate bar", 0.85, Category.FOOD));
		return c;
	}
	
	String expectedReceipt1() {
		return String.join("\n",
				   "1 book: 12.49",
	               "1 music CD: 16.49",
	               "1 chocolate bar: 0.85",
	               "Sales Taxes: 1.50", 
	               "Total: 29.83");
	}
	
	Cart newCart() {
		return Carts.newDefaultCart(0.1, 0.05);
	}
	
	String receipt(Cart c) {
		return Carts.newDefaultReceipt(c).print();
	}

}
