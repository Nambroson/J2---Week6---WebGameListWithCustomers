package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Customer;

/**
 * @author Nick - ntambroson
 * CIS175 - Fall 2021
 * Oct 6, 2021
 */
public class CustomerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("J2 - Week6 - WebGameListWithCustomers");

	public void insertCustomer(Customer c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Customer> showAllCustomers(){
		EntityManager em = emfactory.createEntityManager();
		List<Customer> allCustomers = em.createQuery("SELECT c from Customer c").getResultList();
		return allCustomers;
	}

	/**
	 * @param customerName
	 * @return
	 */
	public Customer findCustomer(String nameToLookUp) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Customer> typedQuery = em.createQuery("select ch from Customer ch where ch.customerName = :selectedName",Customer.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		Customer foundCustomer;
		try {
			foundCustomer = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundCustomer = new Customer(nameToLookUp);
		}
		em.close();

		return foundCustomer;
	}
}
