package cache_practice;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		
//		insert();
		read();
		
	}
	
	public static void insert() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	    
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		Product p=new Product();
		p.setId(1);
		p.setName("Bottle");
		
		et.begin();
		em.persist(p);
		et.commit();
	}
	
	public static void read() 
	{
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

        System.out.println("---- First EntityManager ----");
        EntityManager em1 = emf.createEntityManager();
        Product p1 = em1.find(Product.class, 1); // DB hit
     
        em1.close();

        System.out.println("---- Second EntityManager ----");
       EntityManager em2 = emf.createEntityManager();
        Product p2 = em2.find(Product.class, 1);
        
        p2.setName("Pencil");
         // From 2nd-level cache
        em2.getTransaction().begin();
        em2.persist(p2);
        em2.getTransaction().commit();
        em2.close();

        emf.close();
		
	}
}