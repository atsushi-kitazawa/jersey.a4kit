
package com.example.jersey.a4kit.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.example.jersey.a4kit.dto.Hello;

@Path("/hello")
public class HelloResource {

	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response hello(@PathParam("name") String name) {
		Hello hello = new Hello();
		hello.setMessage("hello " + name + ".");

		return Response.status(Status.OK).entity(hello).build();
	}
}
