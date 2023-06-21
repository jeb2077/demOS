package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.text.Position;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {
    @FXML
    private Button  butt_exit;
    @FXML
    private Label label_welcome;
    @FXML
    private Label label_channel;
    @FXML
    private Button bt_ambcard;
    @FXML
    private Button bt_zapiska;
    @FXML
    private Button bt_otchet;
    @FXML
    private Button bt_rasspisanie;

    @Override
    public void initialize(URL location, ResourceBundle resources)  {

        butt_exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseHandler.changeScene(event,"sample.fxml", "log in!", "null", null);
            }
        });
        bt_ambcard.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseHandler.changeScene(event, "/Doctor/AmbCard/AmbCard.fxml","","null",null );
            }
        });
        bt_zapiska.setOnAction(event -> {
            bt_zapiska.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/Registration/Zapiska/Zapiska.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            });
        bt_otchet.setOnAction(event -> {
            bt_otchet.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/Doctor/Otchet/Otchet_diagnos.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                });
        bt_rasspisanie.setOnAction(event -> {
            bt_rasspisanie.getScene().getWindow().hide();
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/Registration/Registration/Rasspisanie.fxml"));
                        try {
                            loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Parent root = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.showAndWait();
                    });
/*
        bt_zapiska.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseHandler.changeScene(event, "/Registrarion/Zapiska/Zapiska.fxml","","null",null );
            }
        });
        bt_otchet.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseHandler.changeScene(event, "/Doctor/AmbCard/Otchet_diagnos.fxml","","null",null );
            }
        });
        bt_rasspisanie.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseHandler.changeScene(event, "/Registrarion/Rasspisanie/Rasspisanie.fxml","","null",null );
            }
        });
*/
    }
    public void setUserInfo(String username, String Position){
        label_welcome.setText("Добро пожаловать! " + username);
        label_channel.setText("Вы вошли как :" + Position);
    }
}