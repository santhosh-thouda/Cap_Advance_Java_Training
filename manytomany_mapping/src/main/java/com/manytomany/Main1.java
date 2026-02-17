package com.manytomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main1 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Query q1 = em.createNativeQuery("delete from student1_subject where subject_id=?1");
		q1.setParameter(1, 1);
		Query q2 = em.createNativeQuery("delete from subject where id=?1");
		q2.setParameter(1, 1);
		
		et.begin();
		q1.executeUpdate();
		q2.executeUpdate();
		et.commit();
	}
}
