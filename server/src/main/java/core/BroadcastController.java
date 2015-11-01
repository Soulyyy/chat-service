package core;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseBroadcaster;
import org.glassfish.jersey.media.sse.SseFeature;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("/broadcast")
public class BroadcastController {

  private SseBroadcaster broadcaster = new SseBroadcaster();

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.TEXT_PLAIN)
  public String broadcastMessage(String message) {
    OutboundEvent.Builder builder = new OutboundEvent.Builder();
    OutboundEvent event = builder.name("message").mediaType(MediaType.TEXT_PLAIN_TYPE).data(String.class, message).build();
    broadcaster.broadcast(event);
    return "Message: " + message + " has been broadcast!";
  }

  @GET
  @Produces(SseFeature.SERVER_SENT_EVENTS)
  public EventOutput listenToBroadcast() {
    final EventOutput eventOutput = new EventOutput();
    this.broadcaster.add(eventOutput);
    return eventOutput;
  }

  @GET
  public void registerBroadCast() {

  }

}
