package org.example.chatapp.Client.LoginAndRegister;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RegisterController {
    public TextField username_textField;
    public TextField email_textField;
    public TextField password_textField;
    public TextField confirmpassword_textField;
    public Hyperlink loginLink;
    public Button register_btn;

    public void ClickRegisterBtn(ActionEvent actionEvent) {


    }

    public void LoginHyperlink(ActionEvent actionEvent) throws IOException {
        Scene registerScene = loginLink.getScene();
        registerScene.getWindow().hide();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/chatapp/LoginScreen.fxml")));

        Stage loginStage = new Stage();
        loginStage.setTitle("Đăng nhập");
        loginStage.setScene(new javafx.scene.Scene(root));
        loginStage.show();
    }
}
