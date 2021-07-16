package com.example.jersey.a4kit.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/regex")
public class RegexResource {

	@GET
	@Path("/hello/{name: foo|bar|ahe}/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response hello(@PathParam("name") String name,
			@PathParam("id") String id) {

		String html = buildPage(name, id);
		return Response.status(Status.OK).entity(html).build();
	}

	private String buildPage(String name, String id) {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<body>");
		sb.append("<p>hello " + name + "(id:" + id + ")");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
}
