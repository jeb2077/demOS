package Doctor.Otchet;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class OtchetDiagnos {
        @FXML
        private Button Back;
        @FXML
        private AreaChart otchet;
        @FXML
        void initialize(){
            Back.setOnAction(event -> {
                Back.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/Doctor.fxml"));
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
        }
}
