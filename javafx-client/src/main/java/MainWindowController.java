import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lombok.Setter;

import javax.inject.Singleton;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Hans on 05/11/2015.
 */
@Singleton
public class MainWindowController implements Initializable {

  @FXML
  public TextArea participants;

  @FXML
  public TextField textArea;

  @FXML
  private TextArea chatArea;

  @Setter
  private static ByteArrayOutputStream byteArrayOutputStream;

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    PrintStream ps = new PrintStream(System.out);
    chatArea.appendText(ps.toString());
    ps.flush();
  }

  public void writeToTextArea(String line) {
    chatArea.appendText(line);
  }

  @FXML
  public void handleSendButtonAction(ActionEvent event) {
    chatArea.appendText("TERE");
    chatArea.appendText(byteArrayOutputStream.toString());
    try {
      byteArrayOutputStream.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
