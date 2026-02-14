package com.onetomanymapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s1 = new Student();
		s1.setS_id(101);
		s1.setName("Santhu");
		s1.setBranch("CSE");
		
		Student s2 = new Student();
		s2.setS_id(102);
		s2.setName("Arjun");
		s2.setBranch("Fashion Designing");
		
		College c1 = new College();
		c1.setCollege_id(1);
		c1.setName("LPU");
		c1.setLocation("Punjab");
		c1.setPincode("144411");
		
		List<Student> slist = new ArrayList<>();
		slist.add(s1);
		slist.add(s2);
		c1.setStudent(slist);
		
		et.begin();
		em.persist(c1);
		em.persist(s1);
		em.persist(s2);
		et.commit();
	}
}
