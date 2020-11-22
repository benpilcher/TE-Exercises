package com.techelevator;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MaxEnd3Tests {

	MaxEnd3 maxEnd3 = new MaxEnd3();
	
	@Test
	public void larger_last_element () {
		assertArrayEquals("Input: maxEnd3(new int[]{0, 2, 4})", new int[]{4, 4, 4}, maxEnd3.makeArray(new int[]{0, 2, 4}));
		assertArrayEquals("Input: maxEnd3(new int[]{7, 2, 39})", new int[]{39, 39, 39}, maxEnd3.makeArray(new int[]{7, 2, 39}));
		assertArrayEquals("Input: maxEnd3(new int[]{16, 48, 17})", new int[]{17, 17, 17}, maxEnd3.makeArray(new int[]{16, 48, 17}));
	}
	
	@Test
	public void larger_first_element () {
		assertArrayEquals("Input: maxEnd3(new int[]{4, 2, 0})", new int[]{4, 4, 4}, maxEnd3.makeArray(new int[]{4, 2, 0}));
		assertArrayEquals("Input: maxEnd3(new int[]{39, 2, 7})", new int[]{39, 39, 39}, maxEnd3.makeArray(new int[]{39, 2, 7}));
		assertArrayEquals("Input: maxEnd3(new int[]{17, 48, 16})", new int[]{17, 17, 17}, maxEnd3.makeArray(new int[]{17, 48, 16}));

	}
}
