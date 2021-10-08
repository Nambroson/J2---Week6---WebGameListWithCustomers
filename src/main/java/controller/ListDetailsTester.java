package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Game;
import model.ListDetails;


/**
 * @author Nick - ntambroson
 * CIS175 - Fall 2021
 * Oct 6, 2021
 */
public class ListDetailsTester {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Customer griffin = new Customer("Griffin");
		
		//CustomerHelper ch = new CustomerHelper();
		
		//ch.insertCustomer(griffin);
		
		Game gears = new Game("FPS", "Gears of War");
		Game speed = new Game("Racing", "Need for Speed");
		
		List<Game> griffinItems = new ArrayList<Game>();
		griffinItems.add(gears);
		griffinItems.add(speed);
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListDetails griffinList = new ListDetails("Griffin's List", LocalDate.now(), griffin);
		griffinList.setListOfItems(griffinItems);
		
		ldh.insertNewListDetails(griffinList);
		
		List<ListDetails> allLists = ldh.getLists();
		
		for(ListDetails a : allLists) {
			System.out.println(a.toString());
		}
	}

}
