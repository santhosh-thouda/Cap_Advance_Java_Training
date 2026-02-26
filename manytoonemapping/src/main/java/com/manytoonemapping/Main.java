package com.manytoonemapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Department dept = new Department();
		dept.setManager_name("Allen");
		dept.setName("HR");
		dept.setNo_of_employees(5);
		
		Employee e1 = new Employee();
		
		e1.setName("Miller");
		e1.setDesignation("ASE");
		e1.setDepartment(dept);
		e1.setSalary(2000);
		
		Employee e2=new Employee();
		
		e2.setName("Virat");
		e2.setDesignation("Analyst");
		e2.setSalary(3000);
		e2.setDepartment(dept);
		et.begin();
		em.persist(dept);
		em.persist(e2);
		em.persist(e1);
		et.commit();
	}
}