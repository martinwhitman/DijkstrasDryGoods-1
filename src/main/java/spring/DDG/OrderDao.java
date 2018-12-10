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
	public Order viewOrder(Integer orderno) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Order found = em.createQuery("Select o from Order o where o.orderNumber = :orderNumber", Order.class).setParameter("orderNumber", orderno).getSingleResult();
		em.close();
		return found;
	}
	
	public List<Order> generateList() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Order> typedQuery = em.createQuery("select o from Order o", Order.class);
		List<Order> list = typedQuery.getResultList();
		em.close();
		/*EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		String o = "select o from Order o";
		TypedQuery<Order> typedQuery = em.createQuery(o, Order.class);
		List<Order> list = typedQuery.getResultList();
		em.close();*/
		return list;	
	}
	
	//adding service side option to view full inventory
	public List<Order> showAllInventory() {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		String o = "select o from Order o";
		TypedQuery<Order> typedQuery = em.createQuery(o, Order.class);
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
