package chat;

import lombok.RequiredArgsConstructor;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Hans on 05/11/2015.
 */
@RequiredArgsConstructor
public class SocketUserHandler {

  private final Set<SocketUser> userSet = new HashSet<>();

  private final AtomicInteger userCount = new AtomicInteger(0);

  public void registerUser(String name, Session session) {
    userSet.add(new SocketUser(userCount.getAndIncrement(), name, session));
  }

  public void userDisconnect(SocketUser user) {
    userSet.remove(user);
  }

  public List<SocketUser> getUsersAsList() {
    return new ArrayList<>(userSet);
  }
}
