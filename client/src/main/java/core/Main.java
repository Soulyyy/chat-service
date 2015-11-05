package core;


import client.ChatClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Command line application Main class
 */
public class Main {

  static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
    ChatClient chatClient = new ChatClient(args, System.in, System.out);
    new Thread(chatClient).start();
  }
}
