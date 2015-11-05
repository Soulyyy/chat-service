package core;

import chat.SocketUserHandler;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * Websocket based online list polling
 */
@ServerEndpoint(value = "/connected")
public class OnlineList {

  static final SocketUserHandler socketUserHandler = new SocketUserHandler();

  @OnOpen
  public void onOpen(Session session) {


  }

  @OnMessage
  public String onMessage(String message, Session session) {
    if("username".equals(message.substring(0,8))) {
      System.out.println("is username");
    }
    return "TERE";
  }

  @OnClose
  public void onClose(Session session, CloseReason closeReason) {

  }
}
