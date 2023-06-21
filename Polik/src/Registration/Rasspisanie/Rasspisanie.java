/*
package Registration.Rasspisanie;

import Registration.Zapiska.Zap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.DatabaseHandler;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Rasspisanie {
    @FXML
    private TableView<Rass> tv_rasspisanie;
    @FXML
    private TableColumn<Rass, String> tc_fam;
    @FXML
    private TableColumn<Rass, String> tc_name;
    @FXML
    private TableColumn<Rass, String> tc_otches;
    @FXML
    private TableColumn<Rass, String> tc_cab;
    @FXML
    private TableColumn<Rass, String> tc_startwork;
    @FXML
    private TableColumn<Rass, String> tc_finwork;
    @FXML
    private Button tb_exit;
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        tb_exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseHandler.changeScene(event,"sample.fxml", "log in!", "null", null);
            }
        });
        showRass();
    }
    public Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ip_polik?useSSl=false", "root", "12345");
            return connection;
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
            return null;
        }
    }
    public ObservableList<Zap> getRassList(){
        ObservableList<Zap> RassList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM `ip_polik`.rasspisanie";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Rass Rass;
            while (rs.next()){
                Rass = new Rass(rs.getInt("idRassspisanie"), rs.getString("Famili"), rs.getString("Name"), rs.getString("Otchestvo"), rs.getString("Cabinet"),
                        rs.getString("Time_start_work"), rs.getString("Time_finish_work"));
                RassList.add(Rass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RassList;
    }
    public void showRass(){
        ObservableList<Rass> list = getRassList();
        tc_fam.setCellValueFactory(new PropertyValueFactory<Rass, String>("Famili"));
        tc_name.setCellValueFactory(new PropertyValueFactory<Rass, String>("Name"));
        tc_otches.setCellValueFactory(new PropertyValueFactory<Rass, String>("Otchestvo"));
        tc_cab.setCellValueFactory(new PropertyValueFactory<Rass, String>("Cabinet"));
        tc_startwork.setCellValueFactory(new PropertyValueFactory<Rass, String>("Time_start_work"));
        tc_finwork.setCellValueFactory(new PropertyValueFactory<Rass, String>("Time_finish_work"));

        tv_rasspisanie.setItems(list);
    }
    @FXML
    private void handleMouseAction(MouseEvent event) {
        Rass rass = tv_rasspisanie.getSelectionModel().getSelectedItem();
        tc_fam.setText("" + Rass.getFamili());
        tc_name.setText("" + Rass.getName());
        tc_otches.setText("" + Rass.getOtchestvo());
        tc_cab.setText("" + Rass.getCabinet());
        tc_startwork.setText("" + Rass.getTime_start_work());
        tc_finwork.setText("" + Rass.getTime_finish_work());
    }
}
*/