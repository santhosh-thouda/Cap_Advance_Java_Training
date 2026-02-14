package com.onetomanymapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main3 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		College college = em.find(College.class, 1);
		et.begin();
		em.remove(college);;
		et.commit();
		
		String sql1 = "Delete from college where id=?1";
		// String sql2 = "Delete from college_student where id=?1";
		
	}
}
