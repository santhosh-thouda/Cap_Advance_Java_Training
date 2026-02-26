package com.springbasics;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {
	
	// Dependency Injection
	@Autowired
	private Mobile mobile;
	
	@Autowired
	private List<String> items;
	
	
	public void message() {
		System.out.println("Hi");
	}
	
	public Mobile getMobile() {
		return mobile;
	}
	
	public void setMobile() {
		this.mobile = mobile;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}
}
