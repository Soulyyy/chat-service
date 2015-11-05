package chat;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class User {

  @Getter
  private final int id;

  private final String userName;

  @Override
  public String toString() {
    return userName;
  }


}