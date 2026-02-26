package practice_mockito;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UsersDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	

	public void insertUser() {
		EntityTransaction et = em.getTransaction();
		
		Users u = new Users();
		u.setId(6);
		u.setName("shweta");
		u.setBalance(19000.0);
		
		et.begin();
		em.persist(u);
		et.commit();
	}
	
	public Users findById(int id) {
		return em.find(Users.class, id);
	}
}