package org.bookstoreapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.bookstoreapp.services.BookService;
import java.io.IOException;
public class NewBookController {
    @FXML
    private TextField title;
    @FXML
    private TextField author;
    @FXML
    private TextField price;
    @FXML
    private TextField imageurl;
    @FXML
    public void initialize() {
    }
    @FXML
    public void handleFinishButton (ActionEvent event) throws IOException{
        BookService.addBook(title.getText(), author.getText(), Double.parseDouble(price.getText()),imageurl.getText());
        Parent home_page_parent = FXMLLoader.load(getClass().getClassLoader().getResource("BookstoreLibrary.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
}
