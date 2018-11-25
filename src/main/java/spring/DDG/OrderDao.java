package spring.DDG;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OrderDao {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DijkstrasDryGoods");

	public void insertOrder(Order orderToAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(orderToAdd);
		em.getTransaction().commit();
		
	}
}
