package chat;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Hans on 31/10/2015.
 */
@RequiredArgsConstructor
public class UserRegistration {

  private final List<User> userList;

  private final AtomicInteger userCount;

  public void registerUser(String name) {
    userList.add(new User(userCount.getAndIncrement(), name));
  }

}
