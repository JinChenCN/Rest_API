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
}
