package com.example.jersey.a4kit.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.example.jersey.a4kit.domain.User;
import com.example.jersey.a4kit.dto.request.AddUserRequest;

@Path("/account")
public class AccountResouce {

	@POST
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(AddUserRequest body) {
		User user = User.builder().name(body.getName()).birth(body.getBirth()).email(body.getEmail()).build();
		System.out.println(user);
		return Response.status(Status.OK).entity(user).build();
	}
}
