package org.bookstoreapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.bookstoreapp.exceptions.UsernameAlreadyExistsException;
import org.bookstoreapp.exceptions.WrongUsernameorPasswordException;
import org.bookstoreapp.services.UserService;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import java.io.IOException;

public class RegistrationController {

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
    public void handleRegisterAction() {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("Account created successfully!");
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }
    @FXML
    public void handleLoginAction(ActionEvent event) throws IOException{
        try {
            UserService.checkUserCredentials(usernameField.getText(), passwordField.getText());
        } catch (WrongUsernameorPasswordException e) {
            registrationMessage.setText(e.getMessage());
        }
        Parent home_page_parent=FXMLLoader.load(getClass().getClassLoader().getResource("BookstoreLibrary.fxml"));
        Scene home_page_scene=new Scene(home_page_parent);
        Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
}