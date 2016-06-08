package lp.salestaxes.exercise.products;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {

	Product prod;
	final String name = "digital book To Kill a Mockingbird";
	final int qty = 3;
	final double unitCost = 3.5;
	
	@Before
	public void beforeEach() {
		prod = new Product(name, unitCost, qty, EnumSet.of(Category.BOOK, Category.DIGITAL));
	}
	
	@Test
	public void productDataFill() {
		assertThat(prod.getName(), is(name));
		assertThat(prod.getQty(), is(qty));
		assertThat(prod.getCost(), is(qty * unitCost));
		assertThat(prod.getCategories(), contains(Category.BOOK, Category.DIGITAL));
	}
	
	@Test
	public void categoryChangesDoesNotAffectTheProduct() {
		Set<Category> cats = prod.getCategories();
		cats.clear();
		assertThat(prod.getCategories(), not(empty()));
	}

}
