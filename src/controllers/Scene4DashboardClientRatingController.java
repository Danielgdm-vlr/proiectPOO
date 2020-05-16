package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

public class Scene4DashboardClientRatingController {
    @FXML
    private Hyperlink hyperlinkGoBack;

    public void onClickGoBackToMainDashboard() throws Exception {
        hyperlinkGoBack.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene3DashboardClient.fxml"));
        Stage dashboardClientStage = new Stage();
        dashboardClientStage.setTitle("RAW POWER GYM - Client`s dashboard");
        dashboardClientStage.setScene(new Scene(root));
        dashboardClientStage.show();
    }
}