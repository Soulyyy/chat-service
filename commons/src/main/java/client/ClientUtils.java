package client;


import lombok.RequiredArgsConstructor;

import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.List;


@Singleton
@RequiredArgsConstructor
public class ClientUtils {

  private final String ip;
  private final Client client = ClientBuilder.newClient();

  public WebTarget createWebTarget() {
    return client.target(ip);
  }

  public WebTarget createWebTarget(WebTarget target, List<String> path) {
    for (String s : path) {
      target = target.path(s);
    }
    return target;
  }

  public WebTarget createWebTarget(WebTarget target, String pathElement) {
    return target.path(pathElement);
  }

  public WebTarget createWebTarget(List<String> path) {
    WebTarget target = client.target(ip);
    for (String s : path) {
      target = target.path(s);
    }
    return target;
  }

  public WebTarget createWebTarget(String pathElement) {
    return client.target(ip).path(pathElement);
  }
}
