package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Game;

/**
 * @author Nick - ntambroson
 * CIS175 - Fall 2021
 * Sep 23, 2021
 */
public class GameHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("J2 - Week6 - WebGameListWithCustomers");
	
	public void insertItem(Game game) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(game);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Game> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<Game> allItems = em.createQuery("SELECT i FROM Game i").getResultList();
		return allItems;
	}
	
	public void deleteItem(Game toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Game> typedQuery = em.createQuery("select gh from Game gh where gh.genre = :selectedGenre and gh.game = :selectedGame", Game.class);


		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedGenre", toDelete.getGenre());
		typedQuery.setParameter("selectedGame", toDelete.getGame());

		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		Game result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}


	public Game searchForGameById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Game found = em.find(Game.class, idToEdit);
		em.close();
		return found;
	}

	public void updateGame(Game toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Game> searchForGameByGenre(String genreName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Game> typedQuery = em.createQuery("select gh from Game gh where gh.genre = :selectedGenre", Game.class);
		typedQuery.setParameter("selectedGenre", genreName);
		
		List<Game> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Game> searchForGameByGame(String gameName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Game> typedQuery = em.createQuery("select gh from Game gh where gh.game = :selectedGame", Game.class);
		typedQuery.setParameter("selectedGame", gameName);
		
		List<Game> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
