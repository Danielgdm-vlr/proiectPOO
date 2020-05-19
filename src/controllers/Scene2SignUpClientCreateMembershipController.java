package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene2SignUpClientCreateMembershipController {
    @FXML
    private Hyperlink hyperlinkGotoNextPageMembership;

    public void onClickGoToNextPage() throws IOException {
        hyperlinkGotoNextPageMembership.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/Scene2aSignUpClientCreatMembership.fxml"));
        Stage signUpClient2 = new Stage();
        signUpClient2.setScene(new Scene(root));
        signUpClient2.setTitle("RAW POWER GYM - Create your MEMBERSHIP");
        signUpClient2.show();
    }
}
