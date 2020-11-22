package com.techelevator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Lucky13Tests {

	Lucky13 lucky13 = new Lucky13();
	
	@Test
	public void null_array () {
		assertEquals("Input: null", true, lucky13.getLucky(null));
		assertEquals("Input: lucky13(new int[]{0, 2, 4})", true, lucky13.getLucky(new int[]{0, 2, 4}));
		assertEquals("Input: lucky13(new int[]{1, 2, 3})", false, lucky13.getLucky(new int[]{1, 2, 3}));
		assertEquals("Input: lucky13(new int[]{1, 2, 4})", false, lucky13.getLucky(new int[]{1, 2, 4}));
		assertEquals("Input: lucky13(new int[]{0, 2, 3})", false, lucky13.getLucky(new int[]{0, 2, 3}));
		assertEquals("Input: lucky13(new int[]{4, 5, 6})", true, lucky13.getLucky(new int[]{4, 5, 6}));
	}
	
}
