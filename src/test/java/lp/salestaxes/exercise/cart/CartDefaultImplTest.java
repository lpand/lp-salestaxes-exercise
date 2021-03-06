package lp.salestaxes.exercise.cart;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import lp.salestaxes.exercise.cart.Cart.CartItem;
import lp.salestaxes.exercise.cart.CartDefaultImpl.CartItemImpl;
import lp.salestaxes.exercise.products.ImportedProduct;
import lp.salestaxes.exercise.products.Item;
import lp.salestaxes.exercise.products.Samples;
import lp.salestaxes.exercise.products.Tax;

public class CartDefaultImplTest {
		
	Item book, chocolates;
	double taxes;
	
	CartItem cartItem;
	
	Cart cart;
	@Mock Tax tax;
	
	@Before
	public void beforeEach() {
		makeCartItems();
		makeCartWithTaxes();
	}
	
	void makeCartItems() {
		book = Samples.digitalBook();
		chocolates = Samples.chocolates();
		taxes = book.getCost() * 0.15; // 15%
		
		cartItem = new CartItemImpl(book, taxes);
	}
	
	
	void makeCartWithTaxes() {
		MockitoAnnotations.initMocks(this);
		when(tax.getTaxes(book)).thenReturn(2.1);
		when(tax.getTaxes(chocolates)).thenReturn(0.5);

		cart = new CartDefaultImpl(tax);
	}
	
	@Test
	public void addItemComputesTaxes() {
		cart.addItem(book);
		
		verify(tax, times(1)).getTaxes(book);
		
		cart.addItem(chocolates);
		
		verify(tax, times(1)).getTaxes(chocolates);
	}
	
	@Test
	public void addImportedItemInvokesAddItemWithAnImportedProductAsArgument() {
		ArgumentCaptor<Item> arg = ArgumentCaptor.forClass(Item.class);
		cart.addImportedItem(book);
		verify(tax).getTaxes(arg.capture());
		
		Item prod = arg.getValue();
		assertThat("The item is not an imported one", prod, is(instanceOf(ImportedProduct.class)));
		
		ImportedProduct importedItem = (ImportedProduct) prod;
		assertThat(importedItem.getItem(), is(book));
	}
	
	@Test
	public void checkoutReturnsTaxedCartItems() {
		cart.addItem(book);
		cart.addItem(chocolates);
		
		List<CartItem> cartItems = cart.checkout();
		
		assertThat("there should be only book and chocolates in the cart", cartItems, hasSize(2));
		assertThat("book should have 2.1 of total taxes", cartItems.get(0).getTaxes(), is(2.1));
		assertThat("chocolates should have 0.5 of total taxes", cartItems.get(1).getTaxes(), is(0.5));
	}
	
	@Test
	public void addItemReturnsTheCartItself() {
		assertThat(cart.addItem(book), is(cart));
	}
	
	@Test
	public void addImportedItemReturnsTheCartItself() {
		assertThat(cart.addImportedItem(book), is(cart));
	}
	
	@Test
	public void cartItemDecoratesProperlyAnItem() {
		int qty = book.getQty();
		double cost = book.getCost();
		assertThat(cartItem.getDescription(), is(qty + " " + book.getName()));
		assertThat("wrong taxes", cartItem.getTaxes(), is(taxes));
		assertThat("Price does not include taxes: cost + taxes", cartItem.getPrice(), is(cost + taxes));
	}


}
