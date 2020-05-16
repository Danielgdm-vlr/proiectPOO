package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

public class Scene3DashboardClientController {
    @FXML
    private Hyperlink hyperlinkGoToNextPage;
    @FXML
    private Hyperlink hyperlinkGoToPreviousPage;

    public void initialize(){

    }

    public void onClickGoToNextPage()throws Exception{
        hyperlinkGoToNextPage.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene3aDashboardClient.fxml"));
        Stage dashboardAClient = new Stage();
        dashboardAClient.setScene(new Scene(root));
        dashboardAClient.setTitle("RAW POWER GYM - Client`s Dashboard");
        dashboardAClient.show();
    }

    public void onClickGoToPreviousPage()throws Exception{
        hyperlinkGoToPreviousPage.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene3DashboardClient.fxml"));
        Stage dashboardClient = new Stage();
        dashboardClient.setTitle("RAW POWER GYM - Client`s Dashboard");
        dashboardClient.setScene(new Scene(root));
        dashboardClient.show();
    }
}
