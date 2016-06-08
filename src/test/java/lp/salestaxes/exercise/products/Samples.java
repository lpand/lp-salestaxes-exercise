package lp.salestaxes.exercise.products;

import java.util.EnumSet;

public class Samples {

	public static Item digitalBook() {
		final String name = "digital book To Kill a Mockingbird";
		final int qty = 3;
		final double unitCost = 7.59;
		return new Product(name, unitCost, qty, EnumSet.of(Category.BOOK, Category.DIGITAL));
	}
	
	public static Item chocolates() {
		final String name = "box of chocolates";
		final int qty = 1;
		final double unitCost = 3.51;
		return new Product(name, unitCost, qty, Category.FOOD);
	}
	
	public static Item pills() {
		final String name = "box of headache pills";
		final int qty = 2;
		final double unitCost = 5;
		return new Product(name, unitCost, qty, Category.MEDICAL);
	}
}
