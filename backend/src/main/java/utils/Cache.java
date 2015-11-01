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
    LIST.add(0, message);
    logger.info("Cache list size is {}", LIST.size());
    if (LIST.size() >= length) {
      LIST.remove(length);
    }
  }

}
