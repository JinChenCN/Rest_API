package model;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
	public static int maxId = 1;

	public static List<Customer> customers = new ArrayList<Customer>();

	static {
		Customer customer = new Customer();
		customer.setId(maxId++);
		customer.setName("TESTA");
		customer.setAddress("Shanghai");
		customer.setPhoneNumber("1234");
		customers.add(customer);

		Customer customer1 = new Customer();
		customer1.setId(maxId++);
		customer1.setName("TESTD");
		customer1.setAddress("Shandong");
		customer1.setPhoneNumber("4444");
		customers.add(customer1);
	}

	public static List<Customer> getCustomers() {
		return customers;
	}

	public static Customer getCustomer(int id) {
		Customer customer = customers.stream().filter(x -> x.getId() == id)
				.findFirst().orElse(null);
		return customer;
	}
}
