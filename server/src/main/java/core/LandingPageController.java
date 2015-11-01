package core;

import org.glassfish.jersey.server.mvc.Viewable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/")
public class LandingPageController {

  @GET
  @Produces(MediaType.TEXT_HTML)
  public Viewable landingPage() {
    return new Viewable("/index");
  }


}
