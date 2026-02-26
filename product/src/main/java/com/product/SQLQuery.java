package com.product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;

public class SQLQuery {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		String sql="select * from product";
		
		Query query = em.createNativeQuery(sql);
		
		List<Product> list = query.getResultList();
		
		System.out.println(list);
	}
}