package core;

import javax.websocket.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Hans on 05/11/2015.
 */
@ClientEndpoint
public class SocketHandler implements Runnable {

  @OnOpen
  public void onOpen(Session session) {
    try {
      session.getBasicRemote().sendText("start");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @OnMessage
  public String onMessage(String message, Session session) {
    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
    try {
      String userInput = bufferRead.readLine();
      return userInput;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @OnClose
  public void onClose(Session session, CloseReason reason) {

  }

  @Override
  public void run() {

  }
}
