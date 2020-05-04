package org.bookstoreapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.bookstoreapp.exceptions.WrongUsernameorPasswordException;
import org.bookstoreapp.services.UserService;

public class LoginController {
    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox role;
    @FXML
    public void initialize() {
        role.getItems().addAll("Client", "Admin");
    }
    @FXML
    public void handleLoginAction() {
        try {
           UserService.checkUserCredentials(usernameField.getText(), passwordField.getText());
            registrationMessage.setText("You are logged in!");
        } catch (WrongUsernameorPasswordException e) {
            registrationMessage.setText(e.getMessage());
        }
    }
}
