package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

public class Scene3DashboardManagerController {
    @FXML
    private Button buttonSeeGymHalls;
    @FXML
    private Button buttonAddTrainer;
    @FXML
    private Button buttonSeeClientsFeedback;
    @FXML
    private Button buttonSeeTotalWorkingHours;
    @FXML
    private Hyperlink hyperlinkGoToMainDashboard;

    public void initialize(){

    }

    public void onClickButtonSeeGymHalls()throws Exception{
        buttonSeeGymHalls.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene4DashboardManagerGymHalls.fxml"));
        Stage dashboardManagerGymHalls = new Stage();
        dashboardManagerGymHalls.setTitle("RAW POWER GYM - Manager`s Dashboard / GymH Halls");
        dashboardManagerGymHalls.setScene(new Scene(root));
        dashboardManagerGymHalls.show();
    }

    public void onClickButtonAddTrainer()throws Exception{
        buttonAddTrainer.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene4DashboardManagerAddTrainer.fxml"));
        Stage dashboardManagerAddTrainer = new Stage();
        dashboardManagerAddTrainer.setTitle("RAW POWER GYM - Manager`s Dashboard / Add a new Trainer");
        dashboardManagerAddTrainer.setScene(new Scene(root));
        dashboardManagerAddTrainer.show();
    }

    public void onClickButtonSeeClientsFeedback()throws Exception{
        buttonSeeClientsFeedback.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene4DashboardManagerSeeClientsFeedback.fxml"));
        Stage dashboardManagerClientsFeedback = new Stage();
        dashboardManagerClientsFeedback.setTitle("RAW POWER GYM - Manager`s Dashboard / See client`s feedback");
        dashboardManagerClientsFeedback.setScene(new Scene(root));
        dashboardManagerClientsFeedback.show();
    }

    public void onClickButtonSeeTotalWorkingHours()throws Exception{
        buttonSeeTotalWorkingHours.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene4DashboardManagerSeeTotalWorkingHours.fxml"));
        Stage dashboardManagerTotalHours = new Stage();
        dashboardManagerTotalHours.setTitle("RAW POWER GYM - Manager`s Dashboard / See trainer`s total working hours");
        dashboardManagerTotalHours.setScene(new Scene(root));
        dashboardManagerTotalHours.show();
    }

}
