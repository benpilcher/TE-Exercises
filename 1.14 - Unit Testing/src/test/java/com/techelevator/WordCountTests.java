package com.techelevator;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class WordCountTests {

	WordCount wordCount = new WordCount();

	@Test
	public void ba2_black1_sheep1() {

		Map<String, Integer> expectedMap = new HashMap<String, Integer>();
		expectedMap.put("ba", 2);
		expectedMap.put("black", 1);
		expectedMap.put("sheep", 1);
		
		Map<String, Integer> output = wordCount.getCount(new String[] {"ba", "ba", "black", "sheep"});		
		
		assertEquals(expectedMap, output);
		
	}
	
	@Test
	public void empty_map_empty_array () {

		Map<String, Integer> expectedMap = new HashMap<String, Integer>();
		
		Map<String, Integer> output = wordCount.getCount(new String[] {});		
		
		assertEquals(expectedMap, output);
		
	}
	
	@Test
	public void a2_b2_c1() {

		Map<String, Integer> expectedMap = new HashMap<String, Integer>();
		expectedMap.put("a", 2);
		expectedMap.put("b", 2);
		expectedMap.put("c", 1);
		
		Map<String, Integer> output = wordCount.getCount(new String[] {"a", "b", "a", "c", "b"});		
		
		assertEquals(expectedMap, output);
		
	}
	
	@Test
	public void a1_b1_c1() {

		Map<String, Integer> expectedMap = new HashMap<String, Integer>();
		expectedMap.put("a", 1);
		expectedMap.put("b", 1);
		expectedMap.put("c", 1);
		
		Map<String, Integer> output = wordCount.getCount(new String[] {"c", "b", "a"});		
		
		assertEquals(expectedMap, output);
		
	}
}