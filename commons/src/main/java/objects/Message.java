package objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {

  @Getter
  @Setter
  private String timestamp;

  @Getter
  @Setter
  private String userName;

  @Getter
  @Setter
  private String message;

  @Override
  public String toString() {
    return "[" + timestamp + "]" + userName + ": " + message;
  }
}
