package com.techelevator;

import java.util.List;
import java.util.ArrayList;

public class BankCustomer {
	
	private String name;
	private String address;
	private String phoneNumber;
	private List<Accountable> accounts = new ArrayList<Accountable>();
	
	public void addAccount(Accountable newAccount) {
		accounts.add(newAccount);
	}

	public boolean isVip () {
        int totalBalance = 0;
        for (Accountable account : accounts) {
            totalBalance = totalBalance + account.getBalance();
        }
		
		return totalBalance >= 25000;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
    public Accountable[] getAccounts() {
    	Accountable[] accountArray = new Accountable[accounts.size()];
    	for (int i = 0; i < accounts.size(); i++) {
    		accountArray[i] = accounts.get(i);
    	}
        return accountArray;
    }
}
