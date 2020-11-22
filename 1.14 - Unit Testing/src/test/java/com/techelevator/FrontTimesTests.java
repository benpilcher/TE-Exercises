package com.techelevator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FrontTimesTests {

	FrontTimes frontTimes = new FrontTimes();
	
	@Test
	public void string_with_more_than_three_characters () {
		assertEquals("Input: generateString(\"chocolate\", 2)", "chocho", frontTimes.generateString("chocolate", 2));
		assertEquals("Input: generateString(\"chocolate\", 3)", "chochocho", frontTimes.generateString("chocolate", 3));
		assertEquals("Input: generateString(\"Java\", 2)", "JavJav", frontTimes.generateString("Java", 2));
		assertEquals("Input: generateString(\"Java\", 3)", "JavJavJav", frontTimes.generateString("Java", 3));
	}
	
	public void string_with_three_or_fewer_characters () {
		assertEquals("Input: generateString(\"dog\", 2)", "dogdog", frontTimes.generateString("dog", 2));
		assertEquals("Input: generateString(\"dog\", 3)", "dogdogdog", frontTimes.generateString("dog", 3));
		assertEquals("Input: generateString(\"Abc\", 3)", "AbcAbcAbc", frontTimes.generateString("Abc", 3));
		assertEquals("Input: generateString(\"Bye\", 2)", "ByeBye", frontTimes.generateString("Bye", 2));
		assertEquals("Input: generateString(\"Bye\", 3)", "ByeByeBye", frontTimes.generateString("Bye", 3));
		assertEquals("Input: generateString(\"my\", 2)", "mymy", frontTimes.generateString("my", 2));
		assertEquals("Input: generateString(\"my\", 3)", "mymymy", frontTimes.generateString("my", 3));
		assertEquals("Input: generateString(\"A\", 2)", "AA", frontTimes.generateString("A", 2));
		assertEquals("Input: generateString(\"A\", 3)", "AAA", frontTimes.generateString("A", 3));
	}
	
	public void null_string () {
		assertEquals("Input: generateString(null, 2)", "", frontTimes.generateString(null, 2));
		assertEquals("Input: generateString(\"\", 3)", "", frontTimes.generateString("", 3));
	}
}
