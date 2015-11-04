import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
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


    int firstLayerHeight = 500;
    int secondLayerHeight = 100;

    TextArea area = new TextArea();
    area.setEditable(false);
    area.setText("TERE");
    area.setPrefHeight(firstLayerHeight);
    area.setPrefWidth(400);
    area.setFont(Font.font("Arial", 12));

    TextArea friendArea = new TextArea();
    friendArea.setEditable(false);
    friendArea.setText("FRIEDS");
    friendArea.setPrefHeight(firstLayerHeight);
    friendArea.setPrefWidth(200);
    friendArea.setFont(Font.font("Arial", 18));

    TextField inputField = new TextField();
    inputField.setPrefHeight(secondLayerHeight);
    inputField.setPrefWidth(400);

    Label label = new Label("Message: ");
    label.setPrefHeight(secondLayerHeight);
    label.setPrefWidth(150);

    Button button = new Button();
    button.setPrefHeight(secondLayerHeight);
    button.setPrefWidth(50);
    button.setText("Send");

    HBox messagingBox = createMessagingBox();

    GridPane root = new GridPane();
    //root.setValignment(area, VPos.TOP);
    root.add(area, 0, 0);
    //root.getChildren().add(area, 0, 0);
    root.add(label, 0,1);
    root.add(inputField, 1, 1);
    root.add(button, 2, 1);
    //root.getChildren().add(friendArea);
    root.add(friendArea, 1, 0);

    Parent root2 = FXMLLoader.load(getClass().getResource("fxml/test.fxml"));

    Scene scene = new Scene(root2, 600, 600);
    scene.getStylesheets().add("/css/main.css");
    primaryStage.setTitle("Chat Client");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public HBox createMessagingBox() {
    HBox hbox = new HBox();
    hbox.setPadding(new Insets(15, 12, 15, 12));
    hbox.setSpacing(10);
    hbox.setStyle("-fx-background-color: #336699;");

    Button buttonCurrent = new Button("Current");
    buttonCurrent.setPrefSize(100, 20);

    Button buttonProjected = new Button("Projected");
    buttonProjected.setPrefSize(100, 20);
    hbox.getChildren().addAll(buttonCurrent, buttonProjected);

    return hbox;
  }

  public HBox chatAndFriends() {
    return new HBox();
  }
}
