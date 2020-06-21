package org.bookstoreapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.bookstoreapp.exceptions.UsernameAlreadyExistsException;
import org.bookstoreapp.exceptions.WrongUsernameorPasswordException;
import org.bookstoreapp.services.UserService;
import org.bookstoreapp.model.User;
import java.io.IOException;

public class RegistrationController {
    public static User currentuser;
    @FXML
    public Text registrationMessage;
    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField usernameField;
    @FXML
    public ChoiceBox role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Client", "Admin");
    }

    @FXML
    public void handleRegisterAction() {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("Account created successfully!");
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }

    @FXML
    public void handleLoginAction(ActionEvent event) throws IOException {
        try {
            currentuser=new User(usernameField.getText(),passwordField.getText(),(String)role.getValue());
            UserService.checkUserCredentials(usernameField.getText(), passwordField.getText());
            Parent home_page_parent = FXMLLoader.load(getClass().getClassLoader().getResource("BookstoreLibrary.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        } catch (WrongUsernameorPasswordException e) {
            registrationMessage.setText(e.getMessage());
        }
    }
}
