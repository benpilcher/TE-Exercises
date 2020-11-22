package com.techelevator.crm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class PetTests {

	@Test
	public void array_list_returns_comma_delimited_string () {
		
		Pet pet = new Pet("A", "A");
		List <String> vaccines = new ArrayList<>();
		vaccines.add("Rabies");
		vaccines.add("Distemper");
		vaccines.add("Parvo");
		
		pet.setVaccinations(vaccines);
		
		String list = pet.listVaccinations();
		Assert.assertEquals("Rabies, Distemper, Parvo", list);
	
	}
	
}
