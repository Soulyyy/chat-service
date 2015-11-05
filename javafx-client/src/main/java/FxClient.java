import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Hans on 04/11/2015.
 */
public class FxClient extends Application {

  static final Logger logger = LoggerFactory.getLogger(FxClient.class);


  @Override
  public void start(Stage primaryStage) throws Exception {

    Parent root = FXMLLoader.load(getClass().getResource("fxml/test.fxml"));

    Scene scene = new Scene(root, 600, 600);
    scene.getStylesheets().add(getClass().getResource("css/main.css").toString());
    primaryStage.setTitle("Chat Client");
    primaryStage.setScene(scene);
    primaryStage.setMaxHeight(600);
    primaryStage.setMaxWidth(600);
    primaryStage.show();

  }

}
