package com.onetoonemapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class User {

	public static void main(String[] args) {
//		insertCarAndEngine();
		findByCarId();
		deleteEngineById(100);
		
	}
	
	public static void deleteEngineById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
//		Engine e = em.find(Engine.class,id);
		
		String sql1 = "update car set engine_id=null where engine_id=?1";
		Query query1 = em.createNativeQuery(sql1);
		query1.setParameter(1, id);
		
		String sq2 = "delete from engine where id=?1";
		Query query2 = em.createNativeQuery(sq2);
		query2.setParameter(1, id);
	
		
		et.begin();
		query1.executeUpdate();
		query2.executeUpdate();
//		em.remove(e);
		et.commit();
	}
	
	public static void findByCarId() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car c = em.find(Car.class, 1);
		
		System.out.println(c);
	}
	
	public static void insertCarAndEngine() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Engine e=new Engine();
		e.setId(100);
		e.setType("V8");
		e.setFuelType("Petrol");
		e.setMileage("12");
		e.setCc("3000");
		
		
		Car c=new Car();
		c.setId(1);
		c.setBrand("Volkswagen");
		c.setModel("Polo GT10");
		c.setModelYear("2019");
		c.setPrice(10000000);
		c.setEngine(e);
		
		et.begin();
		em.persist(e);
		em.persist(c);
		et.commit();
	}
	
	
}