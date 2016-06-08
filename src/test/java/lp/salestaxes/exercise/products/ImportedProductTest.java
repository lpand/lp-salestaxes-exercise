package lp.salestaxes.exercise.products;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class ImportedProductTest {

	@Test
	public void itJustAddsImportedToTheItemName() {
		Item item = Samples.digitalBook();
		
		ImportedProduct importedProd = new ImportedProduct(item);
		
		assertThat(importedProd.getName(), is("imported " + item.getName()));
		assertThat(importedProd.getCost(), is(item.getCost()));
		assertThat(importedProd.getQty(), is(item.getQty()));
		assertThat(importedProd.getCategories(), is(item.getCategories()));
	}

}
