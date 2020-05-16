package controllers;

import dbconnection.DBHandler;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Scene1LogInController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private CheckBox checkBoxVerifyHuman;
    @FXML
    private Button buttonSignUp;
    @FXML
    private Button buttonLogIn;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement ps;
    private ResultSet rs;

    public void initialize(){
        checkBoxVerifyHuman.setSelected(false);
        buttonLogIn.setDisable(true);
        handler = new DBHandler();
    }

    public void keyReleasedProperty()throws Exception{
        String un = username.getText();
        String pw = password.getText();
        boolean vH = checkBoxVerifyHuman.isSelected();
        boolean bln = (un.isEmpty() || un.trim().isEmpty() || pw.isEmpty() || pw.trim().isEmpty() || !vH);
        buttonLogIn.setDisable(bln);
    }

    public void onClickButtonSignUp()throws Exception{
        buttonSignUp.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene2SignUp.fxml"));
        Stage singUpStage = new Stage();
        singUpStage.setScene(new Scene(root));
        singUpStage.setTitle("RAW POWER GYM - SIGN UP");
        singUpStage.show();
    }

    public void onClickButtonLogIn()throws IOException {
        connection = handler.getConnection();
        String sql = "SELECT  * FROM users WHERE username = ? AND password = ?";
        try{
            connection = handler.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, username.getText());
            ps.setString(2, password.getText());
            rs = ps.executeQuery();
            int ok = 0;
            while(rs.next()) {
                if(rs.getObject("clientId") != null){
                    //mergi pe client fxml
                    buttonLogIn.getScene().getWindow().hide();
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene3DashboardClient.fxml"));
                        Stage dashboardClient = new Stage();
                        dashboardClient.setScene(new Scene(root));
                        dashboardClient.setTitle("RAW POWER GYM - Client`s Dashboard");
                        dashboardClient.show();
                        ok = 1;
                    } catch (Exception e) {
                        e.getCause();
                        e.printStackTrace();
                    }
                }
                if(rs.getObject("trainerId") != null){
                    //mergi pe trainer fxml
                    buttonLogIn.getScene().getWindow().hide();
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene3DashboardTrainer.fxml"));
                        Stage dashboardTrainer = new Stage();
                        dashboardTrainer.setScene(new Scene(root));
                        dashboardTrainer.setTitle("RAW POWER GYM - Trainer`s Dashboard");
                        dashboardTrainer.show();
                        ok = 1;
                    } catch (Exception e) {
                        e.getCause();
                        e.printStackTrace();
                    }
                }
                if(rs.getObject("managerId") != null){
                    //mergi pe manager fxml
                    buttonLogIn.getScene().getWindow().hide();
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene3DashboardManager.fxml"));
                        Stage dashboardTrainer = new Stage();
                        dashboardTrainer.setScene(new Scene(root));
                        dashboardTrainer.setTitle("RAW POWER GYM - Manager`s Dashboard");
                        dashboardTrainer.show();
                        ok = 1;
                    } catch (Exception e) {
                        e.getCause();
                        e.printStackTrace();
                    }
                }
            }
            //daca nu e gasit userul in baza de date
            if(ok == 0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Username was not found in the database. Check the spelling or click the button to sign up!");
                alert.setTitle("opsie dopsie :S");
                alert.setHeaderText(null);
                alert.show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
