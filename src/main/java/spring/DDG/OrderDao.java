package spring.DDG;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class OrderDao {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DijkstrasDryGoods");

	/**
	 * Clean up program
	 */
	public void cleanUp() {
		emfactory.close();
	}
	
	public void updateProduct(ServiceUpdates toUpdate) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toUpdate);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Works with ServiceUpdates.java to pull the current inventory figures from currentinventory (MySQL)
	 * @return List of products
	 */
	public List<ServiceUpdates> getAllInventory() {	
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		String q = "select a from ServiceUpdates a";
		TypedQuery<ServiceUpdates> typedQuery = em.createQuery(q, ServiceUpdates.class);
		List<ServiceUpdates> all = typedQuery.getResultList();
		return all;
	}
	
	/**
	 * Works with Orders.java to pull all current orders from orderitems (MySQL)
	 * @return List of orders
	 */
	public List<Order> getAllOrders() {	
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		String q = "select a from Order a";
		TypedQuery<Order> typedQuery = em.createQuery(q, Order.class);
		List<Order> all = typedQuery.getResultList();
		return all;
	}
	
	/**
	 * Works with Orders.java to add a new order to the database table orderitems
	 * @param orderToAdd
	 */
	public void insertOrder(Order orderToAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(orderToAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateProduct(String products[]) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		String product = products.toString();
		System.out.println(product);
		//em.merge(products);
		em.getTransaction().commit();
		em.close();
	}
	
	/*public void updateProduct(ServiceUpdates update) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(update);
		em.getTransaction().commit();
		em.close();
	}*/
	//adding service side option to view customer's order by order number
	/*public List<Order> viewOrder(Integer orderno) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		//String orderNumberFinder = "FROM Order o WHERE o.orderNumber = orderno";
		//Order found = em.createQuery("Select o from Order o where o.orderNumber = :orderno", Order.class).setParameter("orderNumber", orderno).getSingleResult();
		TypedQuery<Order> typedQuery = em.createQuery("Select o from Order o where o.orderNumber = :orderNumber", Order.class);
		typedQuery.setParameter("orderNumber", orderno);
		List<Order> found = typedQuery.getResultList();
		em.close();
		return found;
	}*/
	
	public Order viewOrder(Integer orderno) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		String orderNumberFinder = "FROM Order o WHERE o.orderNumber = orderno";
		Order found = em.createQuery("Select o from Order o where o.orderNumber = :orderNumber", Order.class).setParameter("orderNumber", orderno).getSingleResult();
		System.out.println(found);
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

	
	
	
}
