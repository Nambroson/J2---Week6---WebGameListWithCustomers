import java.util.List;

import controller.CustomerHelper;
import model.Customer;

/**
 * @author Nick - ntambroson
 * CIS175 - Fall 2021
 * Oct 6, 2021
 */
public class CustomerTester {
	public static void main(String[] args) {
		Customer nick = new Customer("Nick");
		CustomerHelper c = new CustomerHelper();
		
		c.insertCustomer(nick);
		
		Customer hayley = new Customer("Hayley");
		c.insertCustomer(hayley);
		
		List<Customer> allCustomers = c.showAllCustomers();
		for(Customer a: allCustomers) {
			System.out.println(a.toString());
		}
	}
}
