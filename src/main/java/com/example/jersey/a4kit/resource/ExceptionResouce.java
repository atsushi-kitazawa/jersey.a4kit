package com.example.jersey.a4kit.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/exception")
public class ExceptionResouce {

	@GET
	@Path("/not_found")
	public Response notFound() throws Exception {
		if(true)
			throw new Exception("not found exception");
		return Response.status(Status.OK).entity("not found").build();
	}
}
