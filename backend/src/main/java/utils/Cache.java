package utils;

import lombok.Getter;
import objects.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hans on 01/11/2015.
 */
public class Cache {

  Logger logger = LoggerFactory.getLogger(Cache.class);

  private int length;

  @Getter
  private List<Message> LIST = new ArrayList<>();

  public Cache(int length) {
    this.length = length;
  }


  public synchronized void addElement(Message message) {
    LIST.add(message);
    logger.info("Cache list size is {}", LIST.size());
    if (LIST.size() >= length) {
      logger.info("Removing element, list maximum size exceeded");
      LIST.remove(0);
    }
  }

  public Message[] getAsArray() {
    return LIST.toArray(new Message[LIST.size()]);
  }

}
