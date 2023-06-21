package Registration.Zapiska;

import Doctor.AmbCard.Amb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.DatabaseHandler;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Zapiska {
    @FXML
    private TextField tf_Polis;
    @FXML
    private TextField tf_Doctor;
    @FXML
    private TextField tf_Famil;
    @FXML
    private TextField tf_Name;
    @FXML
    private TextField tf_Otchestvo;
    @FXML
    private TextField tf_Date;
    @FXML
    private TextField tf_Time;
    @FXML
    private TableView<Zap> tv_Zapiska;
    @FXML
    private TableColumn<Zap, String> tc_Polis;
    @FXML
    private TableColumn <Zap, String>tc_Doctor;
    @FXML
    private TableColumn <Zap, String> tc_Famil;
    @FXML
    private TableColumn <Zap, String> tc_Name;
    @FXML
    private TableColumn <Zap, String> tc_Otchestv;
    @FXML
    private TableColumn <Zap, String> tc_Date;
    @FXML
    private TableColumn <Zap, String> tc_Time;
    @FXML
    private Button bt_isert;
    @FXML
    private Button bt_update;
    @FXML
    private Button bt_delete;
    @FXML
    private Button bt_exit;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == bt_isert){
            insertRecord();
        }else if (event.getSource() == bt_update){
            updateRecord();
        }else if(event.getSource() == bt_delete){
            deleteButton();
        }
    }
    @FXML
    void initialize() {
        bt_exit.setOnAction(event -> {
            bt_exit.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Login.fxml"));
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
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        bt_exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseHandler.changeScene(event,"sample.fxml", "log in!", "null", null);
            }
        });
        showZap();
         */
    }
    public Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ip_polik?useSSl=false", "root", "CrucifixCrosses");
            return connection;
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
            return null;
        }
    }
    public ObservableList<Zap> getZapList(){
        ObservableList<Zap> ZapList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM `ip_polik`.spisokpatient";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Zap Zap;
            while (rs.next()){
                Zap = new Zap(rs.getInt("idZapiska0"),rs.getString("Polis"), rs.getString("Doctor"), rs.getString("Familia"), rs.getString("Name"),
                        rs.getString("Otchestvo"), rs.getString("Date"), rs.getString("Time"));
                ZapList.add(Zap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ZapList;
    }
    public void showZap(){
        ObservableList<Zap> list = getZapList();
        tc_Polis.setCellValueFactory(new PropertyValueFactory<Zap, String>("Polis"));
        tc_Doctor.setCellValueFactory(new PropertyValueFactory<Zap, String>("Doctor"));
        tc_Famil.setCellValueFactory(new PropertyValueFactory<Zap, String>("Famil"));
        tc_Name.setCellValueFactory(new PropertyValueFactory<Zap, String>("Name"));
        tc_Otchestv.setCellValueFactory(new PropertyValueFactory<Zap, String>("Otchestv"));
        tc_Date.setCellValueFactory(new PropertyValueFactory<Zap, String>("Date"));
        tc_Time.setCellValueFactory(new PropertyValueFactory<Zap, String>("Time"));

        tv_Zapiska.setItems(list);
    }
    private void insertRecord(){
        String query = "INSERT INTO customers VALUES (" +
                "'" + tc_Polis.getText() + "," +
                "'" + tc_Doctor.getText() + "'" + "," +
                "'" + tc_Famil.getText() + "'" + "," +
                "'" + tc_Name.getText() + "'" + "," +
                "'" + tc_Otchestv.getText() + "'" + "," +
                "'" + tc_Date.getText() + "'" + "," +
                "'" + tc_Time.getText() + "'" + "," +
                ")";
        executeQuery(query);
        showZap();
    }

    private void deleteButton(){
        String query = "DELETE FROM customers WHERE id = " + Integer.parseInt(tf_Polis.getText()) + " ";
        executeQuery(query);
        showZap();
    }
    private void updateRecord(){

        String query = "UPDATE customers SET name  = '" + tf_Polis.getText() + "'," + "surname = '" + tf_Doctor.getText() + "'," + "otches = '" + tf_Famil.getText() +
                "date  = '" + tf_Name.getText() + "'," + "simp = '" + tf_Otchestvo.getText() + "issled = '" + tf_Date.getText() + "'," + "lekar = '" + tf_Time.getText() + "',"
                + " WHERE id = " + (tc_Polis.getText()) + " ";
        executeQuery(query);
        showZap();
    }


    private void executeQuery(String query) {
        Connection connection = getConnection();
        Statement st;
        try {
            st = connection.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleMouseAction(MouseEvent event) {
        Zap Zap = tv_Zapiska.getSelectionModel().getSelectedItem();
        tf_Polis.setText("" + Zap.getPolis());
        tf_Doctor.setText("" + Zap.getDoctor());
        tf_Famil.setText("" + Zap.getFamil());
        tf_Name.setText("" + Zap.getName());
        tf_Otchestvo.setText("" + Zap.getOtchestvo());
        tf_Date.setText("" + Zap.getDate());
        tf_Time.setText("" + Zap.getTime());
    }
}


