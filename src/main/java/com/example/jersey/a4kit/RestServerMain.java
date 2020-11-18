
package com.example.jersey.a4kit;

import java.io.IOException;

import org.glassfish.grizzly.http.server.ErrorPageGenerator;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class RestServerMain {

	protected static HttpServer startServer() throws IOException {
		ResourceConfig resourceConfig = new ResourceConfig().packages("com.example.jersey.a4kit.resource")
				.register(JacksonFeature.class);

		System.out.println("Starting grizzly2...");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(ServerConfig.getBaseURI(), resourceConfig, false); 
		server.getServerConfiguration().setDefaultErrorPageGenerator(getErrorPageGenerator());
		return server;
	}

	public static ErrorPageGenerator getErrorPageGenerator() {
		return new ErrorPageGenerator() {
			
			@Override
			public String generate(Request request, int status, String reasonPhrase, String description, Throwable exception) {
				return "{\"message\":\"server unknown error!\"}";
			}
		};
	}
	
	public static void main(String[] args) throws IOException {
		HttpServer httpServer = startServer();
		httpServer.start();
		System.out.println(String.format(
				"Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...",
				ServerConfig.getBaseURI()));
		System.in.read();
		httpServer.shutdown();
	}
}
