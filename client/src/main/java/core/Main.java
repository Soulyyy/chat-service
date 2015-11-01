package core;


import objects.Connect;
import objects.Message;
import org.glassfish.jersey.media.sse.EventListener;
import org.glassfish.jersey.media.sse.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Hans on 31/10/2015.
 */
public class Main {

  static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Client client = ClientBuilder.newClient();
      WebTarget target = client.target("http://localhost:8080").path("chat");
      EventSource source = EventSource.target(target).build();
    try {
      EventListener connectListener = inboundEvent -> System.out.println(inboundEvent.readData(Connect.class).toString());
      EventListener listener = inboundEvent -> System.out.println(inboundEvent.readData(Message.class).toString());
      source.register(listener, "message");
      source.register(connectListener, "connect");
      System.out.println("Please enter your user name: ");
      String name = scanner.nextLine();
      List<Message> messages = null;
      List<?> tmpList = target.path("register").request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(new Connect(null, name), MediaType.APPLICATION_JSON_TYPE), List.class);
      if (tmpList != null && tmpList.size() > 0 && tmpList.get(0) != null && tmpList.get(0) instanceof Message) {
        messages = (List<Message>) (tmpList);
      }
      System.out.println("Thanks, you are now called: " + name);
      if (messages != null) {
        for (Message message : messages) {
          System.out.println(message);
        }
        System.out.println("------END OF HISTORY------------");
      }
      source.open();
      while (true) {
        System.out.println("Enter message: ");
        String s = scanner.nextLine();
        if ("exit chat".equals(s)) {
          break;
        }
        target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(new Message(null, name, s), MediaType.APPLICATION_JSON_TYPE), Message.class);
        //System.out.println(response);

      }
    }catch (ProcessingException e) {
      logger.error("Connection closed by server, exiting.");
      System.exit(1);
    }
      source.close();
      scanner.close();
  }
}
