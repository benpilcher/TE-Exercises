package com.techelevator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringBitsTests {

	StringBits stringBits = new StringBits();
	
	@Test
	public void remove_every_other_character () {
		assertEquals("Input: null", "", stringBits.getBits(null));
		assertEquals("Input: (\"\")", "", stringBits.getBits(""));
		assertEquals("Input: (\"Hello\")", "Hlo", stringBits.getBits("Hello"));
		assertEquals("Input: (\"Hi\")", "H", stringBits.getBits("Hi"));
		assertEquals("Input: (\"Heeololeo\")", "Hello", stringBits.getBits("Heeololeo"));		
	}
	
}
