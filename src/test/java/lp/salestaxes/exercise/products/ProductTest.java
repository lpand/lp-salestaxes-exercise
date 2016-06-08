package lp.salestaxes.exercise.products;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {

	Product prod;
	final String name = "box of chocolates";
	final int qty = 3;
	final double unitCost = 3.5;
	
	@Before
	public void beforeEach() {
		prod = new Product(name, unitCost, qty);
	}
	
	@Test
	public void productDataFill() {
		assertThat(prod.getName(), is(name));
		assertThat(prod.getQty(), is(qty));
		assertThat(prod.getCost(), is(qty * unitCost));
	}

}
