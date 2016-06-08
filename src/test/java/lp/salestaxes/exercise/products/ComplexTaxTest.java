package lp.salestaxes.exercise.products;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ComplexTaxTest {

	ComplexTax tax;
	Item book, pills, choc;
	
	@Mock Tax t1, t2;
	
	
	@Before
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);

		tax = new ComplexTax();
		tax.addTax(t1)
		   .addTax(t2);
		
		book = Samples.digitalBook();
		pills = Samples.pills();
		choc = Samples.chocolates();
		
		// Pills and chocolates are taxed here, book isn't.
		when(t1.hasTaxes(book)).thenReturn(false);
		when(t1.hasTaxes(choc)).thenReturn(false);
		when(t1.hasTaxes(pills)).thenReturn(true);
		
		when(t2.hasTaxes(book)).thenReturn(false);
		when(t2.hasTaxes(choc)).thenReturn(true);
		when(t2.hasTaxes(pills)).thenReturn(true);
		
		when(t1.getTaxes(pills)).thenReturn(3.0);
		when(t2.getTaxes(pills)).thenReturn(2.0);
		when(t2.getTaxes(choc)).thenReturn(1.0);		
	}
	
	
	@Test
	public void hasTaxesIfAtLeastOneOfProvidedTaxesSaysSo() {
		assertThat(tax.hasTaxes(book), is(false));
		assertThat(tax.hasTaxes(pills), is(true));
		assertThat(tax.hasTaxes(choc), is(true));
	}
	
	@Test
	public void taxesAreTheSumOfTheProvidedTaxes() {
		assertThat("it should be 3.0 from first tax and 2.0 from the second one", tax.getTaxes(pills), is(5.0));
		assertThat(tax.getTaxes(choc), is(1.0));
	}
	
	@Test
	public void addTaxReturnsTax() {
		assertThat(tax.addTax(t1), is(tax));
	}

}
