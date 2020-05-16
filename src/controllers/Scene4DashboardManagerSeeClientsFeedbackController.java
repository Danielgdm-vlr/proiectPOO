package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

public class Scene4DashboardManagerSeeClientsFeedbackController {
    @FXML
    private Hyperlink hyperlinkBackToDashboard;

    public void onClickGoBackToMainDashboard() throws Exception {
        hyperlinkBackToDashboard.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene3DashboardManager.fxml"));
        Stage dashboardManager = new Stage();
        dashboardManager.setScene(new Scene(root));
        dashboardManager.setTitle("RAW POWER GYM - Manager`s Dashboard");
        dashboardManager.show();
    }
}
