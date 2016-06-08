package lp.salestaxes.exercise.products;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ImportTaxTest {
	
	private ImportTax tax;

	@Before
	public void beforeEach() {
		tax = new ImportTax(0.5); 
	}
	
	@Test
	public void hasTaxesIsTrueOnlyIfItemIsAnImportedOne() {
		Item book = Samples.digitalBook();
		assertThat(tax.hasTaxes(book), is(false));
		assertThat(tax.hasTaxes(new ImportedProduct(book)), is(true));
	}

}
