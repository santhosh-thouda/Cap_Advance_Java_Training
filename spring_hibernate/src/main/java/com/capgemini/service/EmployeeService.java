package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.dto.Employee;

@Service // we use @Service for service class instead of @Component
public class EmployeeService {

	@Autowired
	EmployeeDao dao;
	
	public void insertEmployee(Employee e) {
		if(dao.findById(e.getId())==null) {
			dao.insert(e);
		}else {
			System.out.println("data already exists");
		}
	}
	
	public void deleteEmployee(Employee e) {
		if(dao.findById(e.getId())!=null) {
			dao.delete(e);
		}else {
			System.out.println("employee is already deleted");
		}
	}
	
	public void updateEmployee(Employee e) {
		
	}
}