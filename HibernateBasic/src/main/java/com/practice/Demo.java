package com.practice;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;


public class Demo {

	public static void main(String[] args) {
		
		EntityManagerFactory emf   = Persistence.createEntityManagerFactory("postgres");
		
		EntityManager em = emf.createEntityManager();
		
		//EntityTransaction
		
		EntityTransaction et = em.getTransaction();
		
		Student s = new Student();
		
		s.setId(1);
		s.setName("Virat");
		s.setPercentage(90.1);
		
		et.begin();
		em.persist(s);
		et.commit();
		
		emf.close();
	}
}