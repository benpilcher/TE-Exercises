package com.techelevator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NonStartTests {

	NonStart nonStart = new NonStart();
	
	@Test
	public void concatenation_without_first_characters () {
	assertEquals("Input: (\"Hello\", \"There\")", "ellohere", nonStart.getPartialString("Hello", "There"));
	assertEquals("Input: (\"java\", \"code\")", "avaode", nonStart.getPartialString("java", "code"));
	assertEquals("Input: (\"shotl\", \"java\")", "hotlava", nonStart.getPartialString("shotl", "java"));	
	assertEquals("Input: (\"\", \"java\")", "ava", nonStart.getPartialString("", "java"));	
	assertEquals("Input: (\"shotl\", \"\")", "hotl", nonStart.getPartialString("shotl", ""));	
	}
}
