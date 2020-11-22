package com.techelevator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AnimalGroupNameTests {
	
	AnimalGroupName animalGroupName = new AnimalGroupName();
	
	@Test
	public void rhino_returns_crash () {
		assertEquals("Input: getHerd(\"rhino\")", "Crash", animalGroupName.getHerd("rhino"));
		assertEquals("Input: getHerd(\"Rhino\")", "Crash", animalGroupName.getHerd("Rhino"));
	}
	
	@Test
	public void giraffe_returns_tower () {
		assertEquals("Input: getHerd(\"giraffe\")", "Tower", animalGroupName.getHerd("giraffe"));
		assertEquals("Input: getHerd(\"Giraffe\")", "Tower", animalGroupName.getHerd("Giraffe"));
	}

	@Test
	public void elephant_returns_herd () {
		assertEquals("Input: getHerd(\"elephant\")", "Herd", animalGroupName.getHerd("elephant"));
		assertEquals("Input: getHerd(\"Elephant\")", "Herd", animalGroupName.getHerd("Elephant"));
	}
	
	@Test
	public void empty_name_returns_unknown () {
		assertEquals("Input: getHerd(\"\")", "unknown", animalGroupName.getHerd(""));
		assertEquals("Input: getHerd(null)", "unknown", animalGroupName.getHerd(null));
	}
	
	@Test
	public void name_not_on_list_returns_unknown () {
		assertEquals("Input: getHerd(\"walrus\")", "unknown", animalGroupName.getHerd("walrus"));
		assertEquals("Input: getHerd(\"Walrus\")", "unknown", animalGroupName.getHerd("Walrus"));
		assertEquals("Input: getHerd(\"squirrel\")", "unknown", animalGroupName.getHerd("squirrel"));
		assertEquals("Input: getHerd(\"Squirrel\")", "unknown", animalGroupName.getHerd("Squirrel"));
	}
}
