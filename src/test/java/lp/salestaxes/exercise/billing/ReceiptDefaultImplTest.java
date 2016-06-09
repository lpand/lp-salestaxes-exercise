package lp.salestaxes.exercise.billing;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

import lp.salestaxes.exercise.cart.Cart.CartItem;

public class ReceiptDefaultImplTest {

	private final String DEL = System.getProperty("line.separator");
	
	private ReceiptDefaultImpl rec;
	private CartItem book, pills;

	@Before
	public void beforeEach() {
		book = new TestCartItem("1 book", 13.30, 0.5);
		pills = new TestCartItem("1 box of pills", 26.69, 5.65);
		rec = getReceipt(Locale.ENGLISH);
	}

// 	@Test
// 	public void format() {
// 		assertThat(rec.fmt(book), is("1 book: 13.30"));
// //		assertThat(rec.format(10.5), is("10.50"));
// //		assertThat(rec.format(1.0), is("1.00"));
// 	}
	
// 	@Test
// 	public void getTotalReturnsTheTotalPrice() {
// 		assertThat(rec.getTotalFmt(29.83), is("Total: 29.83"));
// 	}
	
// 	@Test
// 	public void getTotalTaxesReturnsTheTotalTaxes() {
// 		assertThat(rec.getTotalTaxesFmt(5.7), is("Sales Taxes: 5.70"));
// 	}
	
	@Test
	public void printFormat() {
		String expectedFormat = getExpectedReceiptFormat();
		assertThat(rec.print(), is(expectedFormat));
	}

	@Test
	public void printFormatChangesOnLocaleBasis() {
		rec = getReceipt(Locale.ITALIAN);
		String expectedFormat = getExpectedReceiptFormat()
			.replaceAll("\\.", ",");
		assertThat(rec.print(), is(expectedFormat));
	}

	private ReceiptDefaultImpl getReceipt(Locale locale) {
		return new ReceiptDefaultImpl(locale, Arrays.asList(book, pills));
	}

	private String getExpectedReceiptFormat() {
		return String.join(DEL, 
				"1 book: 13.30", 
				"1 box of pills: 26.69",
				"Sales Taxes: 6.15",
				"Total: 39.99");
	}
	
	static class TestCartItem implements CartItem {
		
		private String d;
		private double p;
		private double t;

		public TestCartItem(String d, double p, double t) {
			this.d = d;
			this.p = p;
			this.t = t;
		}
		
		@Override
		public String getDescription() {
			return d;
		}

		@Override
		public double getPrice() {
			return p;
		}

		@Override
		public double getTaxes() {
			return t;
		}
		
	}

}
