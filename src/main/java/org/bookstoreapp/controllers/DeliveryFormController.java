package org.bookstoreapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.bookstoreapp.model.Book;
import org.bookstoreapp.services.BookService;
import org.bookstoreapp.services.CartService;
import org.bookstoreapp.services.DeliveryService;

import java.io.IOException;
import java.util.List;

public class DeliveryFormController {
    @FXML
    private TextField fullName;
    @FXML
    private TextArea deliveryAdress;
    @FXML
    private TextField email;
    @FXML
    private TextField phoneNr;
    @FXML
    private TextField orderMessage;
    @FXML
    private AnchorPane orderedBooksPane;
    @FXML
    private VBox orderedBooksVBox;
    @FXML
    public void initialize() throws IOException {
        List<Book> orderedBooks = CartService.getAllOrderedBooks();

        for (Book book : orderedBooks) {

            OrderedBookController controller = new OrderedBookController(book);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("OrderedBook.fxml"));
            fxmlLoader.setController(controller);
            AnchorPane orderedBooksPane = fxmlLoader.load();

            orderedBooksVBox.getChildren().add(orderedBooksPane);
        }
    }

    @FXML
    public void handleyesButton(ActionEvent event)   throws IOException {
        DeliveryService.addOrder(fullName.getText(), deliveryAdress.getText(), email.getText(), phoneNr.getText());
        orderMessage.setText("Your order was registered succesfully!");

        Parent home_page_parent = FXMLLoader.load(getClass().getClassLoader().getResource("BookstoreLibrary.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    public void handlenoButton(ActionEvent event) throws IOException  {

        Parent home_page_parent = FXMLLoader.load(getClass().getClassLoader().getResource("BookstoreLibrary.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
}
