package client;

import lombok.RequiredArgsConstructor;
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
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Class to handle all client communication
 */
@RequiredArgsConstructor
public class ChatClient implements Runnable {

  static final Logger logger = LoggerFactory.getLogger(ChatClient.class);

  private final String ip;

  private final InputStream inputStream;
  private final PrintStream printStream;

  public ChatClient(String[] args, InputStream inputStream, PrintStream printStream) {
    this.ip = args.length == 0 ? "http://localhost:8080" : args[0];
    logger.info("Connecting on address : {}", ip);
    this.inputStream = inputStream;
    this.printStream = printStream;
  }

  @Override
  public void run() {
    Scanner scanner = new Scanner(this.inputStream);
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(ip).path("chat");
    EventSource source = EventSource.target(target).build();
    try {

      EventListener connectListener = inboundEvent -> printStream.println(inboundEvent.readData(Connect.class).toString());
      EventListener listener = inboundEvent -> printStream.println(inboundEvent.readData(Message.class).toString());
      source.register(listener, "message");
      source.register(connectListener, "connect");
      printStream.println("Please enter your user name: ");
      String name = scanner.nextLine();
      //Using array because of type erasure
      Message[] messages = target.path("register").request().accept(MediaType.APPLICATION_JSON_TYPE)
          .post(Entity.entity(new Connect(null, name, true), MediaType.APPLICATION_JSON_TYPE), Message[].class);
      for (Object message : messages) {
        logger.debug("Message is : {}", message);
        printStream.println(message.toString());
      }
      if (messages.length > 0) {
        printStream.println("------END OF HISTORY------------");
      }
      printStream.println("Thanks, you are now called: " + name);
      source.open();
      while (true) {
        printStream.println("Enter message: ");
        String s = scanner.nextLine();
        if ("exit chat".equals(s)) {
          break;
        }
        target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(new Message(null, name, s), MediaType.APPLICATION_JSON_TYPE), Message.class);
      }
    } catch (ProcessingException e) {
      logger.error("Connection closed by server, exiting.");
      System.exit(1);
    }
    source.close();
    scanner.close();
  }
}
