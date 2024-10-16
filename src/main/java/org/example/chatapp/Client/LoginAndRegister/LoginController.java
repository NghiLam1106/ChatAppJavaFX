package org.example.chatapp.Client.LoginAndRegister;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    public TextField username_textField;
    public PasswordField password_textfield;
    public Hyperlink registerLink;
    public Button login_btn;

    public void registerHyperlink(ActionEvent actionEvent) throws IOException {
        Scene loginScene = registerLink.getScene();
        loginScene.getWindow().hide();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/chatapp/RegisterScreen.fxml")));

        Stage registerStage = new Stage();
        registerStage.setTitle("Đăng ký");
        registerStage.setScene(new javafx.scene.Scene(root));
        registerStage.show();

    }

    public void ClickLoginBtn(ActionEvent actionEvent) {
    }
}
