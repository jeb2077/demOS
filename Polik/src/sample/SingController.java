package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SingController implements Initializable {

    @FXML
    private Button Log_button;
    @FXML
    private Button Sing_button;
    @FXML
    private RadioButton Id_Doctor;
    @FXML
    private  RadioButton id_Regist;
    @FXML
    private TextField tf_user;
    @FXML
    private TextField tf_pass;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup toggleGroup = new ToggleGroup();
        id_Regist.setToggleGroup(toggleGroup);
        Id_Doctor.setToggleGroup(toggleGroup);

        id_Regist.setSelected(true);

        Log_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String toggleName = ((RadioButton) toggleGroup.getSelectedToggle()).getText();

                if (!tf_user.getText().trim().isEmpty() && !tf_pass.getText().trim().isEmpty()) {
                    DatabaseHandler.singUpUser(event, tf_user.getText(), tf_pass.getText(), toggleName);
                }   else {
                    System.out.println("Please fill in all information");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in all information to sing up");
                    alert.show();
                }
            }
        });
        Sing_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseHandler.changeScene(event, "sample.fxml", "log in!", null, null);
            }
        });
    }
}
