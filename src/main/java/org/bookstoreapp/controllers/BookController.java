package org.bookstoreapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;


public class BookController {

    @FXML
    private Text Author;
    @FXML
    private Label Title;
    @FXML
    private Label PriceNumber;

    @FXML
    public void initialize() {
        Author.setText("Dan Brown");
    }

    public void handleAddToCartAction(){

    }
}
