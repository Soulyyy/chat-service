package client;


import lombok.RequiredArgsConstructor;
import org.glassfish.jersey.media.sse.EventListener;

import java.io.OutputStream;

/**
 * Class to mask listening websocket.
 * Takes an outputStream to publish data to.
 */
@RequiredArgsConstructor
public class ListeningSocket {

  /**
   * @param Only parameter of the class. This should not be changed.
   */
  final OutputStream outputStream;

  public void connectSocket(String ip) {

  }

  public EventListener registerClass(Class<?> clazz) {
    return inboundEvent -> inboundEvent.readData(clazz);

  }

}