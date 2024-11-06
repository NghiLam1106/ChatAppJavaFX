package org.example.chatapp.Client.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HomeController {
    public Hyperlink loginLink;

    public void ClickLoginBtn(ActionEvent actionEvent) throws IOException {
        Scene homeScene = loginLink.getScene();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("org/example/chatapp/fxml/home-view.fxml")));

        Stage homeStage = new Stage();
        homeStage.setTitle("Trang chủ");
        homeStage.setScene(new Scene(root));
        homeStage.show();
    }

}
