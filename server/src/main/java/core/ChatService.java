package core;

import chat.UserRegistration;
import objects.Connect;
import objects.Message;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseBroadcaster;
import org.glassfish.jersey.media.sse.SseFeature;
import utils.Cache;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.Instant;

@Singleton
@Path("/chat")
public class ChatService {

  private UserRegistration userRegistration = new UserRegistration();
  Cache cache = new Cache(100);
  private SseBroadcaster broadcaster = new SseBroadcaster();

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Message broadcast(Message message) {
    OutboundEvent.Builder builder = new OutboundEvent.Builder();
    Message broadcastMessage = new Message(Instant.now().toString(), message.getUserName(), message.getMessage());
    OutboundEvent event = builder.name("message").mediaType(MediaType.APPLICATION_JSON_TYPE).data(Message.class, broadcastMessage).build();
    broadcaster.broadcast(event);
    cache.addElement(broadcastMessage);
    return broadcastMessage;
  }

  @GET
  @Produces(SseFeature.SERVER_SENT_EVENTS)
  public EventOutput chatListener() {
    final EventOutput eventOutput = new EventOutput();
    //eventOutput.
    broadcaster.onClose(eventOutput);
    this.broadcaster.add(eventOutput);
    return eventOutput;
  }

  @POST
  @Path("/register")
  @Consumes(MediaType.APPLICATION_JSON)
  public Message[] registerUser(Connect connect) {
    OutboundEvent.Builder builder = new OutboundEvent.Builder();
    connect.setTimestamp(Instant.now().toString());
    connect.setConnect(true);
    OutboundEvent event = builder.name("connect").mediaType(MediaType.APPLICATION_JSON_TYPE).data(Connect.class, connect).build();
    userRegistration.registerUser(connect.getName());
    broadcaster.broadcast(event);
    return cache.getAsArray();
  }

}
