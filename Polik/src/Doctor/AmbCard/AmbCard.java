package Doctor.AmbCard;

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

public class AmbCard {
    @FXML
    private TextField tf_polis;
    @FXML
    private TextField tf_Date;
    @FXML
    private TextField tf_simptoms;
    @FXML
    private TextField tf_famili;
    @FXML
    private TextField tf_name;
    @FXML
    private TextField tf_otchestvo;
    @FXML
    private TextField tf_isledovanie;
    @FXML
    private TextField tf_lekarstva;
    @FXML
    private Button bt_isert;
    @FXML
    private Button bt_update;
    @FXML
    private Button bt_delete;
    @FXML
    private TableView <Amb> ft_amb;
    @FXML
    private TableColumn<Amb, String> ft_poli;
    @FXML
    private TableColumn <Amb, String>ft_fami;
    @FXML
    private TableColumn <Amb, String> tf_Name;
    @FXML
    private TableColumn <Amb, String> tf_otches;
    @FXML
    private TableColumn <Amb, String> tf_date;
    @FXML
    private TableColumn <Amb, String> tf_simp;
    @FXML
    private TableColumn <Amb, String> tf_issled;
    @FXML
    private TableColumn <Amb, String> tf_lekar;
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
                DatabaseHandler.changeScene(event,"login.fxml", "Главный экран", "null", null);
            }
        });
        showAmb();

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
    public ObservableList<Amb> getAmbList(){
        ObservableList<Amb> AmbList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM `ip_polik`.ambcard";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Amb Amb;
            while (rs.next()){
                Amb = new Amb(rs.getInt("idambcard"), rs.getString("Polis"), rs.getString("famil"), rs.getString("Name"), rs.getString("Otchest"),
                        rs.getString("Date"), rs.getString("Simptoms"), rs.getString("Isledovanie"), rs.getString("Lekarstva"));
                AmbList.add(Amb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AmbList;
    }
    public void showAmb(){
        ObservableList<Amb> list = getAmbList();
        ft_poli.setCellValueFactory(new PropertyValueFactory<Amb, String>("Polis"));
        ft_fami.setCellValueFactory(new PropertyValueFactory<Amb, String>("famil"));
        tf_Name.setCellValueFactory(new PropertyValueFactory<Amb, String>("Name"));
        tf_otches.setCellValueFactory(new PropertyValueFactory<Amb, String>("Otchest"));
        tf_date.setCellValueFactory(new PropertyValueFactory<Amb, String>("Date"));
        tf_simp.setCellValueFactory(new PropertyValueFactory<Amb, String>("Simptoms"));
        tf_issled.setCellValueFactory(new PropertyValueFactory<Amb, String>("Isledovanie"));
        tf_lekar.setCellValueFactory(new PropertyValueFactory<Amb, String>("Lekarstva"));

        ft_amb.setItems(list);
    }
    private void insertRecord(){
        String query = "INSERT INTO ambcard VALUES (" +
                "'" + ft_poli.getText() + "," +
                "'" + ft_fami.getText() + "'" + "," +
                "'" + tf_Name.getText() + "'" + "," +
                "'" + tf_otches.getText() + "'" + "," +
                "'" + tf_date.getText() + "'" + "," +
                "'" + tf_simp.getText() + "'" + "," +
                "'" + tf_issled.getText() + "'" + "," +
                "'" + tf_lekar.getText() + "'" + "," +
                ")";
        executeQuery(query);
        showAmb();
    }

    private void deleteButton(){
        String query = "DELETE FROM ambcard WHERE id = " + (tf_polis.getText()) + " ";
        executeQuery(query);
        showAmb();
    }
    private void updateRecord(){

        String query = "UPDATE ambcard SET name  = " + tf_name.getText() + "," +  ft_fami.getText() + "," +  tf_otches.getText() +
                tf_date.getText() + "," +  tf_simp.getText() + "," + tf_issled.getText() + "," +  tf_lekar.getText() + ","
                 + " WHERE id = " + (ft_poli.getText()) + " ";
        executeQuery(query);
        showAmb();
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
        Amb Amb = ft_amb.getSelectionModel().getSelectedItem();
        tf_polis.setText("" + Amb.getPolis());
        tf_Date.setText("" + Amb.getDate());
        tf_simptoms.setText("" + Amb.getSimptoms());
        tf_famili.setText("" + Amb.getFamili());
        tf_name.setText("" + Amb.getName());
        tf_otchestvo.setText("" + Amb.getOtchestvo());
        tf_isledovanie.setText("" + Amb.getIsledovanie());
        tf_lekarstva.setText("" + Amb.getLekarstva());

    }
}