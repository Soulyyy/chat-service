package chat;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.websocket.Session;

/**
 * Temporary class, will merge with User in the future
 */
@RequiredArgsConstructor
public class SocketUser {

  @Getter
  private final int id;

  private final String userName;

  private final Session session;

  @Override
  public String toString() {
    return userName;
  }
}
