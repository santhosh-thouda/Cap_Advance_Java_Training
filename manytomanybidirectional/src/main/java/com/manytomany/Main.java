package com.manytomany;

import javax.persistence.EntityTransaction;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student student1 = new Student();
		student1.setId(1);
		student1.setName("Miller");
		student1.setBranch("CSE");
		
		Subject sub1 = new Subject();
		sub1.setId(100);
		sub1.setName("Micro-Processor");
		
		Subject sub2 = new Subject();
		sub2.setId(101);
		sub2.setName("Machine Learning");
		
		Subject sub3 = new Subject();
		sub3.setId(102);
		sub3.setName("Software Engineering");
		
		Student student2 = new Student();
		List<Student> stu = ListOf(student1, student2);
		List<Subject> sub = List.of(sub1, sub2, sub3);
		
		
	}
}
