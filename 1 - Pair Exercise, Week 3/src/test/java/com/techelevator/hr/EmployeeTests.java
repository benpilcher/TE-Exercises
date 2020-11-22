package com.techelevator.hr;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class EmployeeTests {

    @Test
    public void getFullNameReturnsCorrectFormat() {
        Employee employee = new Employee("Test", "Testerson");
        String fullName = employee.getFullName();

        assertEquals("The employee full name is not in the correct format.", "Testerson, Test", fullName);
    }

    @Test
    public void raiseSalaryTest_Positive() {
        Employee employee = new Employee("Test", "Testerson");
        employee.setSalary(100);
        employee.raiseSalary(5);

        assertEquals("The employee raise of 5% was not computed correctly.",employee.getSalary(), 100 * 1.05, 0.0);
    }

    @Test
    public void raiseSalaryTest_Negative() {
        Employee employee = new Employee("Test", "Testerson");
        employee.setSalary(100);
        employee.raiseSalary(-10); //"raise" by negative 10%

        assertEquals("Salary should remain the same when raise percentage is negative.",100, employee.getSalary(),0.0);
    }


    @Test
    public void balanceShouldBe_Zero() {
       Employee employee = new Employee("Test", "Testerson");
       
       Map<String, Double> testMap = new HashMap<>();
       
       double testDouble = employee.getBalanceDue(testMap);
       
       assertEquals(0.0, testDouble, 0.0);
    		   
    }

    @Test
    public void balanceShouldBe_10() {
    	 Employee employee = new Employee("Test", "Testerson");
         
    	 Map<String, Double> testMap = new HashMap<>();
         testMap.put("Grooming", 10.0);
         testMap.put("Sitting",  10.0);
         
         double testDouble = employee.getBalanceDue(testMap);
         
         assertEquals(10.0, testDouble, 0.0);
    		   
    }

    @Test
    public void balanceShouldBe_Five() {
    	Employee employee = new Employee("Test", "Testerson");
		
    	Map<String, Double> testMap = new HashMap<>();
        testMap.put("Walking", 10.0);
		
		double testDouble = employee.getBalanceDue(testMap);
		
		assertEquals(5.0, testDouble, 0.0);
    
    }
    
    @Test
    public void balanceShouldBe_TenFifty() {
    	Employee employee = new Employee("Test", "Testerson");
		
    	Map<String, Double> testMap = new HashMap<>();
        testMap.put("Walking", 10.0);
        testMap.put("Tick treatment", 11.0);
		
		double testDouble = employee.getBalanceDue(testMap);
		
		assertEquals(10.5, testDouble, 0.0);
    
    }
}
