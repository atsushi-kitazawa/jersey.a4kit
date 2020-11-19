package com.example.jersey.a4kit;

import java.io.IOException;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.example.jersey.a4kit.exception.DefaultErrorHelper;
import com.example.jersey.a4kit.exception.DefaultErrorHelper.ResponseMediaType;

public class HttpServerFactory {
	protected static HttpServer createHttpServer() throws IOException {
		ResourceConfig resourceConfig = new ResourceConfig().packages("com.example.jersey.a4kit.resource")
				.register(JacksonFeature.class);

		System.out.println("Starting grizzly2...");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(ServerConfig.getBaseURI(), resourceConfig, false);
		server.getServerConfiguration()
				.setDefaultErrorPageGenerator(DefaultErrorHelper.getDefaultErrorResponse(ResponseMediaType.JSON));
		return server;
	}
}
