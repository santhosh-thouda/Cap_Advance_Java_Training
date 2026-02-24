package com.capgemini.dao;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.dto.Employee;
import com.capgemini.main.JpaUtil;

@Repository // we use repository instead of component for dao layers , we can use component
public class EmployeeDao {

	@Autowired
	JpaUtil jpa;
	EntityManager em;
	@PostConstruct
	public void init() {
		
		em = jpa.getEntityManager();
	}
	
	public void insert(Employee e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	public Employee findById(int id) {
		return em.find(Employee.class, id);
	}
	
	public void delete(Employee e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		System.out.println("object is deleted");
	}
	
	public void update(Employee e) {
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
		
		System.out.println("employee name is updated");
	}
	
}