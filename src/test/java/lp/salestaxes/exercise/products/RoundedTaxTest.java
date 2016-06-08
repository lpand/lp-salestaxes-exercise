package lp.salestaxes.exercise.products;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class RoundedTaxTest {

	Item item1, item2, item3;
	RoundedTax tax;
	Tax decTax;
	
	@Before
	public void beforeEach() {
		item1 = Samples.digitalBook();
		item2 = Samples.pills();
		item3 = Samples.chocolates();
		
		decTax = mock(Tax.class);
		when(decTax.hasTaxes(item1)).thenReturn(true);
		when(decTax.hasTaxes(item2)).thenReturn(false);
		when(decTax.getTaxes(item1)).thenReturn(16.4892);
		when(decTax.getTaxes(item2)).thenReturn(7.125);
		when(decTax.getTaxes(item3)).thenReturn(3.0);
		tax = new RoundedTax(decTax);
	}
	
	@Test
	public void forwardsHasTaxesToDecoratedTax() {
		assertThat(tax.hasTaxes(item1), is(true));
		assertThat(tax.hasTaxes(item2), is(false));
		verify(decTax, times(1)).hasTaxes(item1);
		verify(decTax, times(1)).hasTaxes(item2);
	}
	
	@Test
	public void roundsTaxes() {
		assertThat(tax.getTaxes(item1), is(16.5));
		assertThat(tax.getTaxes(item2), is(7.15));
		assertThat(tax.getTaxes(item3), is(3.0));
	}

}
