package controllers;

import dbconnection.DBHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Scene2SignUpClientCreateMembershipController {
    @FXML
    private Button buttonNextPageMembership;
    @FXML
    private ComboBox comboBoxSelectGym;
    @FXML
    private ComboBox comboBoxSelectDietBreakfast;
    @FXML
    private ComboBox comboBoxSelectDietLunch;
    @FXML
    private ComboBox comboBoxSelectDietDinner;
    @FXML
    private ComboBox comboBoxSelectDiet;

    private Connection connection;
    private DBHandler handler;
    private ResultSet rs1, rs2, rs3;
    private PreparedStatement ps1, ps2, ps3, ps4;

    public void initialize(){
        buttonNextPageMembership.setDisable(true);
        handler = new DBHandler();
        connection = handler.getConnection();
        String sql1 = "SELECT * FROM gyms";
        String sql2 = "SELECT * FROM diets";
        String sql3 = "SELECT * FROM diettype";
        try{
            ps1 = connection.prepareStatement(sql1);
            rs1 = ps1.executeQuery();
            while(rs1.next()){
                comboBoxSelectGym.getItems().addAll(rs1.getString("gymHall"));
            }
            ps2 = connection.prepareStatement(sql2);
            rs2 = ps2.executeQuery();
            while(rs2.next()){
                comboBoxSelectDiet.getItems().addAll(rs2.getString("dietType")); //vegan-nonvegan
            }
            ps3 = connection.prepareStatement(sql3);
            rs3 = ps3.executeQuery();
            while(rs3.next()){
                comboBoxSelectDietBreakfast.getItems().addAll(rs3.getString("breakfast") + " " +
                        "(" + rs3.getInt("breakfastCal") + " Cal.)");
                comboBoxSelectDietLunch.getItems().addAll(rs3.getString("Lunch") + " " +
                        "(" + rs3.getInt("LunchCal") + " Cal.)");
                comboBoxSelectDietDinner.getItems().addAll(rs3.getString("Dinner") + " " +
                        "(" + rs3.getInt("DinnerCal") + " Cal.)");
            }
        }catch (Exception e){
            e.getCause();
            e.printStackTrace();
        }
    }

    public String getGymChoice(){
        return (String) comboBoxSelectGym.getSelectionModel().getSelectedItem();
    }

    public String getDietChoice(){
        return (String) comboBoxSelectDiet.getSelectionModel().getSelectedItem();
    }

    //public String getDietTypeChoice(){
       // return (String) comboBoxSelectTypeOfDiet.getSelectionModel().getSelectedItem();
   // }

    public void keyReleasedProperty(){
        boolean bln = (comboBoxSelectGym.getSelectionModel().isEmpty() || comboBoxSelectDiet.getSelectionModel().isEmpty() ||
                        comboBoxSelectDietBreakfast.getSelectionModel().isEmpty() || comboBoxSelectDietLunch.getSelectionModel().isEmpty()
                        || comboBoxSelectDietDinner.getSelectionModel().isEmpty());
;
        buttonNextPageMembership.setDisable(bln);
    }

    public void onClickGoToNextPage() throws IOException {
        /*String sql4 = "INSERT INTO membership(gymId) VALUES(?)";
        ps4  = connection.prepareStatement(sql4);
        int idGym;
        String gymChoice = getGymChoice();
        while(rs1.next()){
            if(rs1.getString("gymHall").equals(gymChoice))
                idGym = rs.getInt("gymId");
                break;
            }
        }
        ps4.setString(1, idGym);
        ps4.executeUpdate();
        */
        buttonNextPageMembership.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene2aSignUpClientCreatMembership.fxml"));
        Stage signUpClient2 = new Stage();
        signUpClient2.setScene(new Scene(root));
        signUpClient2.setTitle("RAW POWER GYM - Create your MEMBERSHIP");
        signUpClient2.show();
    }
}
