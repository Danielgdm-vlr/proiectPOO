package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public String title = "RAW POWER GYM";

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene1LogIn.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene3DashboardManager.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene3DashboardTrainer.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene3DashboardClient.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene2SignUpClientCreateMembership.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene2aSignUpClientCreateMembership.fxml"));
        primaryStage.setTitle(title);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}