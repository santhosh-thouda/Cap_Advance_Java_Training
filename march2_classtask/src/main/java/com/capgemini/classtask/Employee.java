package com.capgemini.classtask;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	private String name;
	private String role;
	private String salary;
	
	@Id
	private String email;
	private String password;
	
	
	public Employee(){}
	
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
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
