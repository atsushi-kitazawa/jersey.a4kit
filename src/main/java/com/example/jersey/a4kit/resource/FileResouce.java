package com.example.jersey.a4kit.resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.StreamingOutput;

@Path("/file")
public class FileResouce {

	@GET
	@Path("/download/{fileId}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response downloadFile(@PathParam("fileId") String id) {
		StreamingOutput fileStream = new StreamingOutput() {
			@Override
			public void write(java.io.OutputStream output) throws IOException, WebApplicationException {
				try {
					java.nio.file.Path path = Paths.get(id);
					byte[] data = Files.readAllBytes(path);
					output.write(data);
					output.flush();
				} catch (Exception e) {
					System.err.println(e.getClass().getSimpleName() + ":" + e.getMessage());
					throw e;
				}
			}
		};
		return Response.status(Status.OK).header("content-disposition", "attachment; filename = " + id)
				.entity(fileStream).build();
	}
}
