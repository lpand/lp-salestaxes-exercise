package lp.salestaxes.exercise.products;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SimpleTaxTest {
	
	private Tax tax;

	@Before
	public void beforeEach() {
		tax = new TestTax(0.5); // 5%
	}

	@Test
	public void taxesAreItemCostMultipliedByTheTaxParameter() {
		Item book = new ImportedProduct(Samples.digitalBook());
		assertThat(tax.getTaxes(book), is(book.getCost() * 0.5));
	}
	
	static class TestTax extends SimpleTax {

		public TestTax(double tax) {
			super(tax);
		}

		public boolean hasTaxes(Item product) {
			return false;
		}
		
	}

}
