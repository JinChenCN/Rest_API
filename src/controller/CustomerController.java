package controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.Customer;
import model.CustomerService;

import org.restlet.data.Form;
import org.restlet.representation.Representation;

@Path("/api/customers")
public class CustomerController {

	@GET
	@Produces("application/json")
	public List<Customer> getCustomers() {
		return CustomerService.getCustomers();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Customer getCustomer(@PathParam("id") int id) {
		return CustomerService.getCustomer(id);
	}
	
	@POST
	public String addCustomer(Representation entity) {
		Form form = new Form(entity);
		String name = form.getFirstValue("name");
		String address = form.getFirstValue("address");
		String phoneNumber = form.getFirstValue("phoneNumber");

		Customer customer = new Customer();
		customer.setName(name);
		customer.setAddress(address);
		customer.setPhoneNumber(phoneNumber);

		int id = CustomerService.maxId++;
		customer.setId(id);
		return String.valueOf(CustomerService.addCustomer(customer));
	}
}
