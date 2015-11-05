package objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Hans on 01/11/2015.
 */
@RequiredArgsConstructor
@AllArgsConstructor
public class Connect implements Serializable {

  @Getter
  @Setter
  private String timestamp;

  @Getter
  @Setter
  private String name;

  @Getter
  @Setter
  private boolean isConnect;

  public String toString() {
    String resp = "[" + timestamp + "] " + name;

    if (isConnect) {
      return resp + " connected to the server!";
    } else {
      return resp + " disconnected from the server!";
    }
  }
}
