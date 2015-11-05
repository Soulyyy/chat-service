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
    ChatClient chatClient = new ChatClient(args, System.in, System.out);
    new Thread(chatClient).start();
  }
}
