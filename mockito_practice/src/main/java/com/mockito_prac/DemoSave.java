package com.mockito_prac;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DemoSave {

	public static void main(String[] args) {
		EntityManagerFactory emf =
	            Persistence.createEntityManagerFactory("postgres");
		  EntityManager em = emf.createEntityManager();
		  
		  EntityTransaction et = em.getTransaction();
		  
		  User user=new User(3,"Miller",30000);
		  et.begin();
		  em.persist(user);
		  et.commit();
		  
	
	}
}