package chat;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Hans on 31/10/2015.
 */
@RequiredArgsConstructor
public class UserRegistration {

  private final Set<User> userSet = new HashSet<>();

  private final AtomicInteger userCount = new AtomicInteger(0);

  public void registerUser(String name) {
    userSet.add(new User(userCount.getAndIncrement(), name));
  }

  public void userDisconnect(User user) {
    userSet.remove(user);
  }

  public List<User> getUsersAsList() {
    return new ArrayList<>(userSet);
  }

}
