package com.account.enquiry.model;

public enum AccountType {
	SAVINGS("SAVINGS"), CURRENT("CURRENT");
	
	private String type;
	
	private AccountType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type;
	}
}
