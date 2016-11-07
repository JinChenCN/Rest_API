package app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import controller.CustomerController;

public class MyApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<Class<?>>();
		resources.add(CustomerController.class);
		return resources;
	}
}