package com.github.protoservice;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.github.protoservice.service.CustomerService;
import com.github.protoservice.service.UserService;

@ApplicationPath("v1")
public class AppService extends Application {

	private Set<Class<?>> allServices = new HashSet<Class<?>>();
	
	public AppService() {
		System.out.println("Starting service....");
		allServices.add(ProtoPubMemeProvider.class); //This line is so important. This is to add provider
		allServices.add(UserService.class);
		allServices.add(CustomerService.class);
		System.out.println("Service started!");
	}
	
	public Set<Class<?>> getClasses() {
		return allServices;
	}
	
	
}
