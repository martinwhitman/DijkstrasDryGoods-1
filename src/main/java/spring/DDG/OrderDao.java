package spring.DDG;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class OrderDao {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DijkstrasDryGoods");

	//cleanUp method for when the console based service side program is closed
	public void cleanUp() {
		emfactory.close();
	}
	
	public void insertOrder(Order orderToAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(orderToAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	//adding service side option to view customer's order by order number
	public Order viewOrder(int on) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Order found = em.find(Order.class, on);
		em.close();
		return found;
	}
	
	//adding service side option to view full inventory
	public List<Order> showAllInventory() {
		EntityManager em = emfactory.createEntityManager();
		//I may need to change the query criteria
		TypedQuery<Order> typedQuery = em.createQuery("select orderNumber from Order orderNumber", Order.class);
		List<Order> allInventory = typedQuery.getResultList();
		em.close();
		return allInventory;
	}
	
	//adding service side option to view the next order in line
	/*public Order viewOrders() {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		//Order nextOrder = 
		return nextOrder;
	}*/
	
	//adding service side option to edit an item's inventory
	
	
	
}
