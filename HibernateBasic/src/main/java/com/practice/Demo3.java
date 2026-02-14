package com.practice;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Demo3 {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		Student student = em.find(Student.class, 1);
		
		if(student != null) {
			student.setDob("2005-03-26");
			et.begin();
			em.merge(student);
			et.commit();
		}
		
		emf.close();
		
	}
}