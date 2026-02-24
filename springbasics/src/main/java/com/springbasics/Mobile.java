package com.springbasics;

import org.springframework.beans.factory.annotation.Value;

public class Mobile {
	@Value("9876543210")
	private String number;
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
}