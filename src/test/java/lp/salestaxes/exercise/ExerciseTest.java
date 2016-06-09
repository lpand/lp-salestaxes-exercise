package lp.salestaxes.exercise;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.After;
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
	
	@Test
	public void output2() {
		System.out.println("Output2: ");
		System.out.println(getReceipt2());
		assertThat("Output2 does not match expected", getReceipt2(), is(expectedReceipt2()));
	}
	
	@Test
	public void output3() {
		System.out.println("Output3: ");
		System.out.println(getReceipt3());
		assertThat("Output3 does not match expected", getReceipt3(), is(expectedReceipt3()));
	}
	
	String getReceipt1() {
		return receipt(getCart1());
	}
	
	String getReceipt2() {
		return receipt(getCart2());
	}
	
	String getReceipt3() {
		return receipt(getCart3());
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
	
	Cart getCart2() {
		Cart c = newCart();
		c.addImportedItem(new Product("box of chocolates", 10.00, Category.FOOD));
		c.addImportedItem(new Product("bottle of perfume", 47.50, Category.BEAUTY));
		return c;
	}
	
	String expectedReceipt2() {
		return String.join("\n", 
			"1 imported box of chocolates: 10.50", 
			"1 imported bottle of perfume: 54.65", 
			"Sales Taxes: 7.65",
			"Total: 65.15");
	}
	
	Cart getCart3() {
		Cart c = newCart();
		c.addImportedItem(new Product("bottle of perfume", 27.99, Category.BEAUTY));
		c.addItem(new Product("bottle of perfume", 18.99, Category.BEAUTY));
		c.addItem(new Product("packet of headache pills", 9.75, Category.MEDICAL));
		c.addImportedItem(new Product("box of chocolates", 11.25, Category.FOOD));
		return c;
	}
	
	String expectedReceipt3() {
		return String.join("\n", 
				"1 imported bottle of perfume: 32.19",
				"1 bottle of perfume: 20.89",
				"1 packet of headache pills: 9.75",
				"1 imported box of chocolates: 11.85",
				"Sales Taxes: 6.70",
				"Total: 74.68");
	}
	
	Cart newCart() {
		return Carts.newDefaultCart(0.1, 0.05);
	}
	
	String receipt(Cart c) {
		return Carts.newDefaultReceipt(c).print();
	}
	
	@After
	public void afterEach() {
		System.out.println();
	}

}
