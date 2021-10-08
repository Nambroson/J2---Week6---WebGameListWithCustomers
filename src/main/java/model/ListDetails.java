package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Nick - ntambroson
 * CIS175 - Fall 2021
 * Oct 6, 2021
 */
@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate tripDate;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Customer customer;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<Game> listOfItems;
	
	public ListDetails() {
		super();
	}
	
	public ListDetails(int id, String listName, LocalDate tripDate, Customer customer, List<Game> listOfItems) {
		super();
		this.id = id;
		this.listName = listName;
		this.tripDate = tripDate;
		this.customer = customer;
		this.listOfItems = listOfItems;
	}
	
	public ListDetails(String listName, LocalDate tripDate, Customer customer, List<Game> listOfItems) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.customer = customer;
		this.listOfItems = listOfItems;
	}
	
	public ListDetails(String listName, LocalDate tripDate, Customer customer) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.customer = customer;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public LocalDate getTripDate() {
		return tripDate;
	}
	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Game> getListOfItems() {
		return listOfItems;
	}
	public void setListOfItems(List<Game> listOfItems) {
		this.listOfItems = listOfItems;
	}
	
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", tripDate=" + tripDate + ", customer=" + customer
				+ ", listOfItems=" + listOfItems + "]";
	}

}