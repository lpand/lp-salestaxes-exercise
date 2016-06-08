package lp.salestaxes.exercise.products;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import static lp.salestaxes.exercise.products.Category.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class BasicTaxTest {

	private Tax tax;

	@Before
	public void beforeEach() {
		tax = new BasicTax(Arrays.asList(MEDICAL, FOOD), 0.5); 
	}
	
	@Test
	public void hasTaxesIsTrueOnlyIfItemBelongsToAtLeastOneOfTheSpecifiedCategories() {
		Item book = Samples.digitalBook(), choc = Samples.chocolates(),
				pills = Samples.pills();
		assertThat(tax.hasTaxes(book), is(false));
		assertThat(tax.hasTaxes(choc), is(true));
		assertThat(tax.hasTaxes(pills), is(true));
	}
	
	@Test
	public void itIsASimpleTax() {
		assertThat(tax, is(instanceOf(SimpleTax.class)));
	}
}
