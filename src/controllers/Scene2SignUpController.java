package controllers;

import dbconnection.DBHandler;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Scene2SignUpController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField telNo;
    @FXML
    private TextField age;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private CheckBox checkBoxVerifyHuman;
    @FXML
    private Button buttonSignUp;
    @FXML
    private Hyperlink hyperlinkGoBackToLogInScene;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement ps;
    private PreparedStatement ps1;
    private PreparedStatement ps2;
    private ResultSet rs;;

    public void initialize(){
        handler = new DBHandler();
        checkBoxVerifyHuman.setSelected(false);
        buttonSignUp.setDisable(true);
    }

    public void keyReleasedProperty() throws Exception{
        String un = username.getText();
        String pw = password.getText();
        String fn = firstName.getText();
        String ln = lastName.getText();
        String cpw = confirmPassword.getText();
        String em = email.getText();
        String no = telNo.getText();
        String ag = age.getText();
        boolean vH = checkBoxVerifyHuman.isSelected();
        boolean bln = (fn.isEmpty() || fn.trim().isEmpty() || ln.isEmpty() || ln.trim().isEmpty()
                        || em.isEmpty() || em.trim().isEmpty() || no.isEmpty() || no.trim().isEmpty()
                        || ag.trim().isEmpty() || ag.isEmpty() || un.trim().isEmpty() || un.isEmpty()
                        || pw.isEmpty() || pw.trim().isEmpty() || cpw.isEmpty() || cpw.trim().isEmpty()
                        || !pw.equals(cpw) || !vH);
        buttonSignUp.setDisable(bln);
    }

    public void onClickGoBackToLogInScene()throws Exception{
        hyperlinkGoBackToLogInScene.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene1LogIn.fxml"));
        Stage logInStage = new Stage();
        logInStage.setTitle("RAW POWER GYM - LOG IN");
        logInStage.setScene(new Scene(root));
        logInStage.show();

    }

    public void onClickButtonSignUp()throws Exception{
        connection = handler.getConnection();
        try{

            String sql1 = "INSERT INTO clients(firstName, lastName, email, telNo, age)" + "Values(?, ?, ? ,? ,?)";
            ps1 = connection.prepareStatement(sql1);
            ps1.setString(1, firstName.getText());
            ps1.setString(2, lastName.getText());
            ps1.setString(3, email.getText());
            ps1.setString(4, telNo.getText());
            ps1.setString(5, age.getText());
            ps1.executeUpdate();
            String sql = "INSERT INTO users(username, password, clientId)" + "VALUES(?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, username.getText());
            ps.setString(2, password.getText());
            String sqll = "SELECT clientId FROM clients WHERE firstName = ?";
            ps2 = connection.prepareStatement(sqll);
            ps2.setString(1, firstName.getText());
            rs = ps2.executeQuery();
            while(rs.next())
                ps.setInt(3, rs.getInt("clientId"));
            ps.executeUpdate();
            buttonSignUp.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene3DashboardClient.fxml"));
            Stage logInStage = new Stage();
            logInStage.setTitle("RAW POWER GYM - Client`s Dashboard ");
            logInStage.setScene(new Scene(root));
            logInStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
