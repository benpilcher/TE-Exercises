package com.techelevator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CigarPartyTest {

	CigarParty cigarParty = new CigarParty();
	
	@Test
	public void sufficient_cigars_for_weekend () {
		assertEquals("Input: haveParty(40, true)", true, cigarParty.haveParty(40, true));
		assertEquals("Input: haveParty(50, true)", true, cigarParty.haveParty(50, true));
		assertEquals("Input: haveParty(60, true)", true, cigarParty.haveParty(60, true));
		assertEquals("Input: haveParty(39, true)", false, cigarParty.haveParty(39, true));
		assertEquals("Input: haveParty(61, true)", true, cigarParty.haveParty(61, true));
		assertEquals("Input: haveParty(99, true)", true, cigarParty.haveParty(99, true));
	}
	
	@Test
	public void sufficient_cigars_for_weekday () {
		assertEquals("Input: haveParty(40, false)", true, cigarParty.haveParty(40, false));
		assertEquals("Input: haveParty(50, false)", true, cigarParty.haveParty(50, false));
		assertEquals("Input: haveParty(60, false)", true, cigarParty.haveParty(60, false));
		assertEquals("Input: haveParty(39, false)", false, cigarParty.haveParty(39, false));
		assertEquals("Input: haveParty(61, false)", false, cigarParty.haveParty(61, false));
		assertEquals("Input: haveParty(99, false)", false, cigarParty.haveParty(99, false));
	}
}
