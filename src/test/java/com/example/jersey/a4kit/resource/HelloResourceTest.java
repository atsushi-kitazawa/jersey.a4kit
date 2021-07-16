package com.example.jersey.a4kit.resource;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class HelloResourceTest extends JerseyTest {

	@Override
	protected Application configure() {
		return new ResourceConfig(HelloResource.class);
	}

	@Test
	public void testHello() {
		final String hello = target("/hello/hoge").request().get(String.class);
		assertEquals("{\"message\":\"hello hoge.\"}", hello);
	}
}
