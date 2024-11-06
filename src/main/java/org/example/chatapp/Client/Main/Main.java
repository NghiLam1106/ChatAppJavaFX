package org.example.chatapp.Client.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/chatapp/fxml/Login.fxml")));
            Scene scene = new Scene(root);
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.getIcons().add(new Image(getClass().getResource("/org/example/chatapp/image/logo.png").toExternalForm()));
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
