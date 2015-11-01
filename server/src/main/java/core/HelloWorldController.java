package core;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;
import java.util.stream.IntStream;

/**
 * Created by Hans on 31/10/2015.
 */

@Path("/helloworld")
public class HelloWorldController {

  @GET
  @Produces(SseFeature.SERVER_SENT_EVENTS)
  public EventOutput helloWorld() {
    EventOutput eventOutput = new EventOutput();
    new Thread(() -> {
      IntStream.range(0, 10).forEach(i -> {
            try {
              final OutboundEvent.Builder builder = new OutboundEvent.Builder();
              builder.name("Message to client");
              builder.data(String.class, "Hello world " + i + "!");
              final OutboundEvent event = builder.build();
              eventOutput.write(event);
              Thread.sleep(500);
            } catch (Exception e) {
              System.out.println("KATKI");
            }
          }
      );
      if (!eventOutput.isClosed()) {
        try {
          eventOutput.close();
        } catch (IOException e) {
          throw new RuntimeException("Failed to close event output", e);
        }
      }
    }).start();
    return eventOutput;
  }
/*
  @POST
  @Path("/post")
  public Response postString() {

  }*/
}
