package lp.salestaxes.exercise.billing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Locale;

import lp.salestaxes.exercise.cart.Cart.CartItem;

public class ReceiptDefaultImpl implements Receipt {
	
	private static final String FMT = "%s: %.02f";
	private static final String DEL = System.getProperty("line.separator");
	private List<CartItem> items;
	private Locale locale;
	
	public ReceiptDefaultImpl(Locale locale, List<CartItem> items) {
		this.items = items;
		this.locale = locale;
	}

	@Override
	public String print() {
		double total = getTotal();
		double taxes = getTaxes();
		String formattedItems = fmt(items);
		return String.join(DEL, formattedItems, getTotalTaxesFmt(taxes), getTotalFmt(total));
	}
	
	private String fmt(CartItem item) {
		return String.format(locale, FMT, item.getDescription(), item.getPrice());
	}
	
	private String fmt(List<CartItem> items2) {
		return items.stream()
				.map(this::fmt)
				.collect(Collectors.joining(DEL));
	}
	
	private String getTotalFmt(double total) {
		return String.format(locale, FMT, "Total", total);
	}

	private String getTotalTaxesFmt(double taxes) {
		return String.format(locale, FMT, "Sales Taxes", taxes);
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
