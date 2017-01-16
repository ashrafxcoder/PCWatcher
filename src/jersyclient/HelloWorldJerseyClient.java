/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jersyclient;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Jersey REST client generated for REST resource:PeopleResource [/people]<br>
 * USAGE:
 * <pre>
 *        HelloWorldJerseyClient client = new HelloWorldJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Ashraf-XCODER
 */
public class HelloWorldJerseyClient {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/HelloWorldService/resources";

    public HelloWorldJerseyClient() {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("people");
    }

    public void setNames(Object requestEntity) throws ClientErrorException {
        webTarget.request(MediaType.TEXT_PLAIN).put(Entity.entity(requestEntity, MediaType.TEXT_PLAIN));
    }

    public String getNames() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(MediaType.TEXT_PLAIN).get(String.class);
    }

    public void close() {
        client.close();
    }
    
    
    public static void main(String[] args) {
        HelloWorldJerseyClient client = new HelloWorldJerseyClient();
        
        System.out.println(client.getNames());
    }
    
}
