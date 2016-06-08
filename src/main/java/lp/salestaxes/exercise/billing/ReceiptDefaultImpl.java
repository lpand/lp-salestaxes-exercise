package lp.salestaxes.exercise.billing;

import java.util.List;
import java.util.stream.Collectors;

import lp.salestaxes.exercise.cart.Cart.CartItem;

public class ReceiptDefaultImpl implements Receipt {
	
	private static final String FMT = "%s: %.02f";
	private static final CharSequence DEL = "\n";
	private List<CartItem> items;
	
	public ReceiptDefaultImpl(List<CartItem> items) {
		this.items = items;
	}

	protected String fmt(CartItem item) {
		return String.format(FMT, item.getDescription(), item.getPrice());
	}
	
	protected String getTotalFmt(double total) {
		return String.format(FMT, "Total", total);
	}
	
	private String fmt(List<CartItem> items2) {
		return items.stream()
				.map(this::fmt)
				.collect(Collectors.joining(DEL));
	}

	@Override
	public String print() {
		double total = getTotal();
		double taxes = getTaxes();
		String formattedItems = fmt(items);
		return String.join(DEL, formattedItems, getTotalTaxesFmt(taxes), getTotalFmt(total));
	}

	protected String getTotalTaxesFmt(double taxes) {
		return String.format(FMT, "Sales Taxes", taxes);
	}
	
	private double getTaxes() {
		return items.stream()
				.mapToDouble(CartItem::getTaxes)
				.sum();
	}
	
	private double getTotal() {
		return items.stream()
			.mapToDouble(CartItem::getPrice)
			.sum();
	}

}
