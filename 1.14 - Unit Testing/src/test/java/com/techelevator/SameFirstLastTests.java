package com.techelevator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SameFirstLastTests {

	SameFirstLast sameFirstLast = new SameFirstLast();
	
	@Test
	public void first_and_last_elements_are_equal () {
		assertEquals("Input: null", false, sameFirstLast.isItTheSame(null));
		assertEquals("Input: sameFirstLast(new int[]{1, 2, 3})", false, sameFirstLast.isItTheSame(new int[]{1, 2, 3}));
		assertEquals("Input: sameFirstLast(new int[]{1, 2, 3, 1})", true, sameFirstLast.isItTheSame(new int[]{1, 2, 3, 1}));
		assertEquals("Input: sameFirstLast(new int[]{1, 2, 1})", true, sameFirstLast.isItTheSame(new int[]{1, 2, 1}));
		assertEquals("Input: sameFirstLast(new int[]{1})", true, sameFirstLast.isItTheSame(new int[]{1}));
		assertEquals("Input: sameFirstLast(new int[]{1, 2})", false, sameFirstLast.isItTheSame(new int[]{1, 2}));
	}
	
}
