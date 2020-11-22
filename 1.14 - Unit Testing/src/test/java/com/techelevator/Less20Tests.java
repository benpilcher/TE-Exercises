package com.techelevator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Less20Tests {

	Less20 less20 = new Less20();
	
	@Test
	public void one_or_two_less_than_multiple_of_20 () {
		assertEquals("Input: isLessThanMultipleOf20(19)", true, less20.isLessThanMultipleOf20(19));
		assertEquals("Input: isLessThanMultipleOf20(18)", true, less20.isLessThanMultipleOf20(18));
		assertEquals("Input: isLessThanMultipleOf20(39)", true, less20.isLessThanMultipleOf20(39));
		assertEquals("Input: isLessThanMultipleOf20(38)", true, less20.isLessThanMultipleOf20(38));
		assertEquals("Input: isLessThanMultipleOf20(99)", true, less20.isLessThanMultipleOf20(99));
		assertEquals("Input: isLessThanMultipleOf20(98)", true, less20.isLessThanMultipleOf20(98));
		assertEquals("Input: isLessThanMultipleOf20(20)", false, less20.isLessThanMultipleOf20(20));
		assertEquals("Input: isLessThanMultipleOf20(17)", false, less20.isLessThanMultipleOf20(17));
		assertEquals("Input: isLessThanMultipleOf20(97)", false, less20.isLessThanMultipleOf20(97));
		
	}
	
}
