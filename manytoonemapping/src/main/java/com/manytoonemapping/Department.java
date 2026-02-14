package com.manytoonemapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Department {
	@Id
	private int id;
	private String name;
	private String manager_name;
	private int no_of_employees;
	
    private List<Employee> employees; 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public int getNo_of_employees() {
		return no_of_employees;
	}
	public void setNo_of_employees(int no_of_employees) {
		this.no_of_employees = no_of_employees;
	}
	
	public String toString() {
		return id+" "+name+" "+manager_name+" "+no_of_employees;
	}
}
