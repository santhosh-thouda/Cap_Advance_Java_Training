package com.manytoonemapping;

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
		
		Query updateQuery = em.createNativeQuery("update employee set department_d_id=null where department_d_id=?1");
		updateQuery.setParameter(1,101);
		Query deleteQuery = em.createNativeQuery("delete from department where d_id=?1");
		deleteQuery.setParameter(1, 101);
		
		et.begin();
		updateQuery.executeUpdate();
		deleteQuery.executeUpdate();
		et.commit();
	}
}