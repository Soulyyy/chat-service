package core;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Hans on 31/10/2015.
 */

/**
 * Class for handling Jersey Mappings.
 * Add classes to the set to map them.
 */
@ApplicationPath("/")
public class ApplicationMain extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    final Set<Class<?>> classes = new HashSet<>();
    classes.add(HelloWorldController.class);
    classes.add(JsonHelloWorld.class);
    classes.add(BroadcastController.class);
    classes.add(ChatService.class);
    //This class gives us JSON bindings by Jackson
    classes.add(JacksonJsonProvider.class);
    return classes;
  }

}
