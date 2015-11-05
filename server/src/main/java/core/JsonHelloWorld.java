package core;

import objects.Message;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Hans on 31/10/2015.
 */
@Path("/json")
public class JsonHelloWorld {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Message getMessage() {
    Message message = new Message();
    message.setMessage("Hello JSON");
    return message;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/test")
  public String test() {
    return "Hello Not so JSON!";
  }
}
