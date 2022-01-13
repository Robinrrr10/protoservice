package com.github.protoservice.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.github.protoservice.entities.proto.UserResponse.User;
import com.github.protoservice.entities.proto.UserResponse.Users;

@Path("/customer")
public class CustomerService {

	@GET()
	@Path("/all")
	@Produces("application/x-protobuf")
	public Users getAllUsers() {
		return Users.newBuilder().addAllUsers(User.newBuilder().setId(1001).setName("Raja").build()).addAllUsers(User.newBuilder().setId(1002).setName("Babu").build()).build();
	}
	
}
