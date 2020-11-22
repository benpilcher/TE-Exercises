package com.techelevator.crm;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.techelevator.crm.Customer;

public class CustomerTest {

	@Test
    public void balanceShouldBe_Ten() {
		Customer customer = new Customer("Test", "Testerson");
		
		Map<String, Double> expectedMap = new HashMap<String, Double>();
		expectedMap.put("Walking", 10.0);
		
		double testDouble = customer.getBalanceDue(expectedMap);
		
		assertEquals(10.0, testDouble, 0.0);
    		   
    }
 
	@Test
    public void balanceShouldBe_Zero() {
    	Customer customer = new Customer("Test", "Testerson");
    	
    	Map<String, Double> expectedMap = new HashMap<String, Double>();
       
        double testDouble = customer.getBalanceDue(expectedMap);
        assertEquals(0, testDouble, 0.0);
    
    }

	@Test
    public void balanceShouldBe_TwentyOne() {
		Customer customer = new Customer("Test", "Testerson");
		
		Map<String, Double> expectedMap = new HashMap<String, Double>();
        expectedMap.put("Walking", 10.0);
        expectedMap.put("Tick treatment", 11.0);
		
		double testDouble = customer.getBalanceDue(expectedMap);
		
		assertEquals(21.0, testDouble, 0.0);
		
	}
}
