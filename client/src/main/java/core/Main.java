package core;


import client.ChatClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Hans on 31/10/2015.
 */
public class Main {

  static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
    String ip = args.length == 0 ? "http://localhost:8080" : args[0];
    logger.info("Connecting on address : {}", ip);
    ChatClient chatClient = new ChatClient(ip);
    chatClient.start();
  }
}
