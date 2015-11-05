package client;


import lombok.RequiredArgsConstructor;
import org.glassfish.jersey.media.sse.EventListener;

import java.io.OutputStream;

/**
 * Class to mask listening SSE.
 * Takes an outputStream to publish data to.
 */
@RequiredArgsConstructor
public class ListeningSocket {

  /**
   * @param Only parameter of the class. This should not be changed.
   */
  private final OutputStream outputStream;

  public void connectSocket(String ip) {

  }

  public EventListener registerClass(Class<?> clazz) {
    return inboundEvent -> inboundEvent.readData(clazz);

  }

}