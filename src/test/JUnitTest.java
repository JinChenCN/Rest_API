package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Form;
import org.restlet.data.Method;
import org.restlet.representation.Representation;
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
		String curUrl = url + "/1";
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
	public void testUpdateCustomer() {
		String curUrl = url + "/2";
		ClientResource client = new ClientResource(curUrl);
		try {
			Form form = new Form();
			form.add("name", "TESTA");
			form.add("address", "Beijing");
			form.add("phoneNumber", "1233");
			Representation webRepresentation = form.getWebRepresentation();
			Request request = new Request(Method.PUT, curUrl, webRepresentation);
			Response response = client.handleOutbound(request);
			assertTrue(response.getStatus().isSuccess());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.release();
		}
	}

	@Test
	public void testAddCustomer() {
		String curUrl = url;
		ClientResource client = new ClientResource(curUrl);
		try {
			Form form = new Form();
			form.add("name", "TESTB");
			form.add("address", "Auckland");
			form.add("phoneNumber", "4321");
			Representation webRepresentation = form.getWebRepresentation();
			Request request = new Request(Method.POST, curUrl,
					webRepresentation);
			Response response = client.handleOutbound(request);
			assertTrue(response.getStatus().isSuccess());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.release();
		}
	}

	@Test
	public void testDeleteCustomer() {
		String curUrl = url + "/1";
		ClientResource client = new ClientResource(curUrl);
		try {
			Request request = new Request(Method.DELETE, curUrl);
			Response response = client.handleOutbound(request);
			assertTrue(response.getStatus().isSuccess());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.release();
		}
	}
}
