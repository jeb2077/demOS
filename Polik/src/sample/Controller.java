package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button Log_button;
    @FXML
    private Button Sing_button;
    @FXML
    private TextField tf_user;
    @FXML
    private TextField tf_pass;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Log_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseHandler.logInUser(event, tf_user.getText(), tf_pass.getText());
                DatabaseHandler.changeScene(event,"login.fxml"," ", null, null );
            }
        });
        Sing_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseHandler.changeScene(event,"singup.fxml","Sign  Up!", null, null );
            }
        });
    }
}
