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
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
    private ResultSet rs1, rs2, rs3, rs3a, rs4;
    private PreparedStatement ps1, ps2, ps3, ps3a, ps4;
    private String dC;

    public void initialize(){
        buttonNextPageMembership.setDisable(true);
        handler = new DBHandler();
        connection = handler.getConnection();
        String sql1 = "SELECT * FROM gyms";
        String sql2 = "SELECT * FROM diets";

        try{
            ps1 = connection.prepareStatement(sql1);
            rs1 = ps1.executeQuery();
            while(rs1.next()){
                comboBoxSelectGym.getItems().addAll(rs1.getString("gymHall"));
            }
            ps2 = connection.prepareStatement(sql2);
            rs2 = ps2.executeQuery();
            while(rs2.next()){
                comboBoxSelectDiet.getItems().addAll(rs2.getString("dietType"));
            }
        }catch (Exception e){
            e.getCause();
            e.printStackTrace();
        }
        comboBoxSelectDietBreakfast.setDisable(true);
        comboBoxSelectDietDinner.setDisable(true);
        comboBoxSelectDietLunch.setDisable(true);
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

    public void keyReleasedProperty() throws SQLException {
        boolean bln = (comboBoxSelectGym.getSelectionModel().isEmpty() || comboBoxSelectDiet.getSelectionModel().isEmpty() ||
                        comboBoxSelectDietBreakfast.getSelectionModel().isEmpty() || comboBoxSelectDietLunch.getSelectionModel().isEmpty()
                        || comboBoxSelectDietDinner.getSelectionModel().isEmpty());
        dC = getDietChoice();
        String sql3 = "SELECT * FROM diettypenv"; // normal diet(nonvegan)
        String sql3a = "SELECT * FROM diettypev"; //vegans
        try {
            if (dC.equals("Normal diet")) {
                if (comboBoxSelectDietBreakfast.getSelectionModel().isEmpty())
                    comboBoxSelectDietBreakfast.getItems().clear();
                if (comboBoxSelectDietLunch.getSelectionModel().isEmpty())
                    comboBoxSelectDietLunch.getItems().clear();
                if (comboBoxSelectDietDinner.getSelectionModel().isEmpty())
                    comboBoxSelectDietDinner.getItems().clear();
                ps3 = connection.prepareStatement(sql3);
                rs3 = ps3.executeQuery();
                while (rs3.next()) {
                    comboBoxSelectDietBreakfast.getItems().addAll(rs3.getString("breakfast") + " " +
                            "(" + rs3.getInt("breakfastCal") + " Cal.)");
                    comboBoxSelectDietLunch.getItems().addAll(rs3.getString("Lunch") + " " +
                            "(" + rs3.getInt("LunchCal") + " Cal.)");
                    comboBoxSelectDietDinner.getItems().addAll(rs3.getString("Dinner") + " " +
                            "(" + rs3.getInt("DinnerCal") + " Cal.)");
                }
            } else {
                if (comboBoxSelectDietBreakfast.getSelectionModel().isEmpty())
                    comboBoxSelectDietBreakfast.getItems().clear();
                if (comboBoxSelectDietLunch.getSelectionModel().isEmpty())
                    comboBoxSelectDietLunch.getItems().clear();
                if (comboBoxSelectDietDinner.getSelectionModel().isEmpty())
                    comboBoxSelectDietDinner.getItems().clear();
                ps3a = connection.prepareStatement(sql3a);
                rs3a = ps3a.executeQuery();
                while (rs3a.next()) {
                    comboBoxSelectDietBreakfast.getItems().addAll(rs3a.getString("breakfast") + " " +
                            "(" + rs3a.getInt("breakfastCal") + " Cal.)");
                    comboBoxSelectDietLunch.getItems().addAll(rs3a.getString("Lunch") + " " +
                            "(" + rs3a.getInt("LunchCal") + " Cal.)");
                    comboBoxSelectDietDinner.getItems().addAll(rs3a.getString("Dinner") + " " +
                            "(" + rs3a.getInt("DinnerCal") + " Cal.)");
                }
            }
        }catch (Exception e){
            System.out.println("Clientul nu a selectat inca tipul de dieta");
        }
        boolean bln1 = (comboBoxSelectDiet.getSelectionModel().isEmpty());
        comboBoxSelectDietBreakfast.setDisable(bln1);
        comboBoxSelectDietLunch.setDisable(bln1);
        comboBoxSelectDietDinner.setDisable(bln1);

        buttonNextPageMembership.setDisable(bln);
    }
    /* comboBoxSelectDietBreakfast.getItems().addAll(rss.getString("breakfast") + " " +
                                    "(" + rss.getInt("breakfastCal") + " Cal.)");
                            comboBoxSelectDietLunch.getItems().addAll(rss.getString("Lunch") + " " +
                                    "(" + rss.getInt("LunchCal") + " Cal.)");
                            comboBoxSelectDietDinner.getItems().addAll(rss.getString("Dinner") + " " +
                                    "(" + rss.getInt("DinnerCal") + " Cal.)");*/
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
        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene2aSignUpClientCreateMembership.fxml"));
        Stage signUpClient2 = new Stage();
        signUpClient2.setScene(new Scene(root));
        signUpClient2.setTitle("RAW POWER GYM - Create your MEMBERSHIP");
        signUpClient2.show();
    }
}
