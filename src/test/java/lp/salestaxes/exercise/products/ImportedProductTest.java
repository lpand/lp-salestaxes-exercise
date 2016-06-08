package lp.salestaxes.exercise.products;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ImportedProductTest {

	Item item;
	ImportedProduct importedProd;
	
	@Before
	public void beforeEach() {
		item = Samples.digitalBook();
		importedProd = new ImportedProduct(item);
	}
	
	@Test
	public void itJustAddsImportedToTheItemName() {
		assertThat(importedProd.getName(), is("imported " + item.getName()));
		assertThat(importedProd.getCost(), is(item.getCost()));
		assertThat(importedProd.getQty(), is(item.getQty()));
		assertThat(importedProd.getCategories(), is(item.getCategories()));
	}
	
	@Test
	public void getItemReturnsTheDecoratedItem() {
		assertThat(importedProd.getItem(), is(item));
	}

}
