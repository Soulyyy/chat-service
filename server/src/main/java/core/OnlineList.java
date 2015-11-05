package core;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * Websocket based online list polling
 */
@ServerEndpoint(value = "/connected")
public class OnlineList {

  @OnOpen
  public void onOpen(Session session) {

  }

  @OnMessage
  public String onMessage(String message, Session session) {
    return "TERE";
  }

  @OnClose
  public void onClose(Session session, CloseReason closeReason) {

  }
}
