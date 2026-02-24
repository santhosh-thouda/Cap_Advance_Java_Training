package com.capgemini.main;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

@Component
public class JpaUtil {

	private EntityManagerFactory emf;
	private EntityManager entityManager;
	@PostConstruct  // it is used to implicitly execute this function when bean is created
	public void createConnection() {
		emf = Persistence.createEntityManagerFactory("postgres");
		entityManager = emf.createEntityManager();
		
		System.out.println("Connection");
	}
	
	
	
	public EntityManagerFactory getEmf() {
		return emf;
	}



	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}



	public EntityManager getEntityManager() {
		return entityManager;
	}



	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}



	@PreDestroy //it is used to call just before destroying ioc container 
	public void closeConnection() {
		entityManager.close();
		emf.close();
		
		System.out.println("Connection is closed");
	}
}