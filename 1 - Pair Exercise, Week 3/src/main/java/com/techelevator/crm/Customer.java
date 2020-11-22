package com.techelevator.crm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.techelevator.Person;
import com.techelevator.Billable;

public class Customer extends Person implements Billable {
	private String phoneNumber;
	private List<Pet> pets = new ArrayList<Pet>();
	
	public Customer (String firstName, String lastName, String phoneNumber) {
		 super(firstName, lastName);
	     this.phoneNumber = phoneNumber;
	}
	
	public Customer(String firstName, String lastName) {
        super(firstName, lastName);
    }

	public double getBalanceDue (Map<String, Double> servicesRendered) {
		double amountOwed = 0.0;
		for (String service : servicesRendered.keySet()) {
			amountOwed += servicesRendered.get(service);
		}
		return amountOwed;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
	
	
	
	
	
	
}
