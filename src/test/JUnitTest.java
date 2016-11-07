package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Method;
import org.restlet.resource.ClientResource;

public class JUnitTest {
	
	public static final String url = "http://localhost:8044/api/customers";

	@Test
	public void testGetCustomers() {
		String curUrl = url;
		ClientResource client = new ClientResource(curUrl);
		try {
			Request request = new Request(Method.GET, curUrl);
			Response response = client.handleOutbound(request);
			assertTrue(response.getStatus().isSuccess());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.release();
		}
	}

	@Test
	public void testGetCustomer() {
	}

	@Test
	public void testUpdateCustomer() {
	}

	@Test
	public void testAddCustomer() {
	}

	@Test
	public void testDeleteCustomer() {
	}
}
