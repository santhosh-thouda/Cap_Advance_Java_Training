package com.capgemini.springbootbasic;

import org.springframework.stereotype.Component;

public class Cricketer {
	private String name;
	private String role;
	private int runs;
	private int noOfMatches;
	private double average;
	
	public Cricketer(String name, String role, int runs, int noOfMatches, double average) {
		super();
		this.name = name;
		this.role = role;
		this.runs = runs;
		this.noOfMatches = noOfMatches;
		this.average = average;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getNoOfMatches() {
		return noOfMatches;
	}
	public void setNoOfMatches(int noOfMatches) {
		this.noOfMatches = noOfMatches;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}

	@Override
	public String toString() {
		return "Cricketer [name=" + name + ", role=" + role + ", runs=" + runs + ", noOfMatches=" + noOfMatches
				+ ", average=" + average + "]";
	}
	
	
}
