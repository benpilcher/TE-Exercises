package com.techelevator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateFashionTests {

	DateFashion dateFashion = new DateFashion();
	
	@Test
	public void low_style_does_not_get_table() {
		assertEquals("Input: getATable(0, 10)", 0, dateFashion.getATable(0, 10));
		assertEquals("Input: getATable(0, 0)", 0, dateFashion.getATable(0, 0));
		assertEquals("Input: getATable(0, 5)", 0, dateFashion.getATable(0, 5));
		assertEquals("Input: getATable(10, 0)", 0, dateFashion.getATable(10, 0));
		assertEquals("Input: getATable(0, 0)", 0, dateFashion.getATable(0, 0));
		assertEquals("Input: getATable(5, 0)", 0, dateFashion.getATable(5, 0));
	}
	
	@Test
	public void high_style_gets_table () {
		assertEquals("Input: getATable(10, 10)", 2, dateFashion.getATable(10, 10));
		assertEquals("Input: getATable(5, 10)", 2, dateFashion.getATable(5, 10));
		assertEquals("Input: getATable(10, 5)", 2, dateFashion.getATable(10, 5));
	}
	
	@Test
	public void medium_style_maybe_gets_table () {
		assertEquals("Input: getATable(5, 5)", 1, dateFashion.getATable(5, 5));
		assertEquals("Input: getATable(3, 7)", 1, dateFashion.getATable(3, 7));
		assertEquals("Input: getATable(7, 3)", 1, dateFashion.getATable(7, 3));
	}
}
