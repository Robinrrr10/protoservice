package com.github.protoservice.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.protoservice.entities.User;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/user")
public class UserService {

	@POST
	@Path("/create")
	public User createUser(User user) {
		return user;
	}
	
	@POST
	@Path("/add")
	public List<User> addUsers(List<User> users) {
		return users;
	}
	

}
