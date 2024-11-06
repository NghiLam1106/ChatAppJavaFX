package org.example.chatapp.Client.controller;

import org.example.chatapp.Client.Model.Client;
import org.example.chatapp.Client.ConnectToServer.Connection;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorLabel;
    private String username, password;
    private Client client;

    private Stage loadingStage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        handleInput();
    }

    private void handleInput() {

        usernameField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    checkCredential();
                }
            }
        });

        passwordField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    checkCredential();
                }
            }
        });
    }

    private boolean logIn() {

        grabData();

        client = Connection.getInstance();

        if (client.connectToServer()) {

            return client.login(username, password);
        } else {
            client.closeConnection();
        }

        return false;
    }

    private void checkCredential() {

        showLodingScreen();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                if (logIn()) {
                    updateSuccessView();
                } else {
                    updateFailedView();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();

    }

    private void updateSuccessView() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                try {
                    loadingStage.hide();
                    Stage currentStage = (Stage) errorLabel.getScene().getWindow();
                    currentStage.hide();

//                    FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/example/chatapp/fxml/Dashboard.fxml")));
//                    DashboardController controller = new DashboardController();
//                    loader.setController(controller);
//                    controller.setUser(username);
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/chatapp/fxml/Dashboard.fxml")));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setTitle(username + "'s Dashboard");
                    stage.setScene(scene);
                    stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResource("/org/example/chatapp/image/logo.png")).toExternalForm()));
                    stage.show();

                    playLoginSound();

                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

    }

    private void updateFailedView() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                usernameField.setText("");
                passwordField.setText("");
                errorLabel.setText("Login Failed!");
                loadingStage.hide();
            }
        });
    }

    private void grabData() {

        username = usernameField.getText().trim();
        password = passwordField.getText().trim();
    }

    @FXML
    public void handleLoginAction(ActionEvent event) {

        checkCredential();
    }

    @FXML
    public void handleRegisterAction(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/chatapp/fxml/Register.fxml")));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Register");
            stage.setScene(scene);
            stage.getIcons().add(new Image(getClass().getResource("/org/example/chatapp/image/logo.png").toExternalForm()));
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void showLodingScreen() {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/chatapp/fxml/Loading.fxml")));
            Scene scene = new Scene(root);
            loadingStage = new Stage();
            loadingStage.initStyle(StageStyle.UNDECORATED);
            loadingStage.setScene(scene);
            loadingStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void playLoginSound() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                try {

                    String path = "src/main/resources//org/example/chatapp/audio/login.mp3";
                    Media media = new Media(new File(path).toURI().toURL().toString());
                    MediaPlayer mediaPlayer = new MediaPlayer(media);
                    mediaPlayer.setAutoPlay(true);
                } catch (MalformedURLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
    }
}
