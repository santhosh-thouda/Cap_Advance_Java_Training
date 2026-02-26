package com.capgemini;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.capgemini")
public class ProjectConfiguration {

	
//	@PostConstruct
//	public EntityManager getEntityManager() {
//		return Persistence
//				.createEntityManagerFactory("postgres")
//				.createEntityManager();
//		
//	}
	
	
//	postconstruct and bean suing here is one way i commented this because now i am using createconnection function inside JpaUtil class and creating
//	and using postconstruct annotation above it and to destroy connection using closeConnection function with preDestroy annotation
}