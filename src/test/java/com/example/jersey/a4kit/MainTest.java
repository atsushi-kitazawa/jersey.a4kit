
package com.example.jersey.a4kit;

import org.glassfish.grizzly.http.server.HttpServer;

import junit.framework.TestCase;


public class MainTest extends TestCase {

    private HttpServer httpServer;
    
//    private WebResource r;

    public MainTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
//        super.setUp();
//        
//        //start the Grizzly2 web container 
//        httpServer = RestServerMain.startServer();
//
//        // create the client
//        Client c = Client.create();
//        r = c.resource(ServerConfig.getBaseURI());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();

        httpServer.stop();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    public void testMyResource() {
//        String responseMsg = r.path("myresource").get(String.class);
//        assertEquals("Got it!", responseMsg);
    }

    /**
     * Test if a WADL document is available at the relative path
     * "application.wadl".
     */
    public void testApplicationWadl() {
    }
}
