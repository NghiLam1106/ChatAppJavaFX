package org.example.chatapp.Client.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ErrorController implements Initializable {
    
    @FXML
    private Label errorLabel;
    private String message;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        errorLabel.setText(message);
    }
    
    public void setMessage(String message){
        
        this.message = message;
    }

}
