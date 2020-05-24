package controllers;

import dbconnection.DBHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Scene2aSignUpClientCreateMembershipController {
    @FXML
    private ComboBox comboBoxExMonday;
    @FXML
    private ComboBox comboBoxExTuesday;
    @FXML
    private ComboBox comboBoxExWednesday;
    @FXML
    private ComboBox comboBoxExThursday;
    @FXML
    private ComboBox comboBoxExFriday;
    @FXML
    private Button buttonFinish;

    private DBHandler handler;
    private Connection connection;


    public void initialize(){
        handler = new DBHandler();
        connection = handler.getConnection();
        try{
            String sql = "SELECT * FROM exs";
            PreparedStatement ps1 = connection.prepareStatement(sql);
            ResultSet rs1 = ps1.executeQuery();
            while(rs1.next()){
                comboBoxExMonday.getItems().addAll(rs1.getString("exerciseName") + " (" + rs1.getInt("exerciseRepeat") + " Reps)");
                comboBoxExTuesday.getItems().addAll(rs1.getString("exerciseName") + " (" + rs1.getInt("exerciseRepeat") + " Reps)");
                comboBoxExWednesday.getItems().addAll(rs1.getString("exerciseName") + " (" + rs1.getInt("exerciseRepeat") + "R eps)");
                comboBoxExThursday.getItems().addAll(rs1.getString("exerciseName") + " (" + rs1.getInt("exerciseRepeat") + " Reps)");
                comboBoxExFriday.getItems().addAll(rs1.getString("exerciseName") + " (" + rs1.getInt("exerciseRepeat") + " Reps)");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        buttonFinish.setDisable(true);
    }

    public void keyReleasedProperty(){
        boolean bln = (comboBoxExMonday.getSelectionModel().isEmpty() || comboBoxExTuesday.getSelectionModel().isEmpty()
                        || comboBoxExWednesday.getSelectionModel().isEmpty() || comboBoxExThursday.getSelectionModel().isEmpty()
                       || comboBoxExFriday.getSelectionModel().isEmpty());
        buttonFinish.setDisable(bln);
    }

    public void onClickButtonFinish() throws IOException {
        buttonFinish.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene3DashboardClient.fxml"));
        Stage dashboardClient = new Stage();
        dashboardClient.setTitle("RAW PWER GYM - Client`s Dashboard");
        dashboardClient.setScene(new Scene(root));
        dashboardClient.show();
    }
}
