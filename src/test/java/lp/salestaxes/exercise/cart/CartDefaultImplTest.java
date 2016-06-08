package lp.salestaxes.exercise.cart;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import lp.salestaxes.exercise.cart.Cart.CartItem;
import lp.salestaxes.exercise.cart.CartDefaultImpl.CartItemImpl;
import lp.salestaxes.exercise.products.Item;
import lp.salestaxes.exercise.products.Samples;

public class CartDefaultImplTest {
		
	Item item;
	double taxes;
	
	CartItem cartItem;
	
	Cart cart;
	@Mock Taxes taxCalc;
	
	@Before
	public void makeCartItem() {
		item = Samples.digitalBook();
		taxes = item.getCost() * 0.15; // 15%
		
		cartItem = new CartItemImpl(item, taxes);
	}
	
	@Before
	public void makeCartWithTaxes() {
		
	}
	
	@Test
	public void cartItemDecoratesProperlyAnItem() {
		int qty = item.getQty();
		double cost = item.getCost();
		assertThat(cartItem.getDescription(), is(qty + " " + item.getName()));
		assertThat("wrong taxes", cartItem.getTaxes(), is(taxes));
		assertThat("Price does not include taxes", cartItem.getPrice(), is(closeTo(cost + cost * taxes, 0.001)));
	}


}
