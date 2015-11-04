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

  public String toString() {
    return "[" + timestamp + "] " + name + " connected to the server!";
  }
}
