package org.bookstoreapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.bookstoreapp.model.Book;
import org.bookstoreapp.model.User;
import org.bookstoreapp.services.CartService;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class BookController {

    private Book book;

    @FXML
    private Text author;
    @FXML
    private Text title;
    @FXML
    private Text priceNumber;
    @FXML
    private ImageView imageView;
    private File imageFile ;


    public BookController(Book book) {
        this.book = book;
    }

    @FXML
    public void initialize() {

        author.setText(book.getAuthor());
        title.setText(book.getTitle());
        priceNumber.setText(String.valueOf(book.getPrice()));
        imageFile = new File(String.valueOf(book.getUrl()));
        if (imageFile.exists()) {
            ImageView imageView = new ImageView();
            Image image = new Image(imageFile.toURI().toString());
            imageView.setImage(image);
        }


    }

    public void handleAddToCartAction() {
        CartService.AddBooktoCart(book);

    }

    public static User thisuser = RegistrationController.currentuser;
    @FXML

    public void handleEditPriceButton(ActionEvent event) throws IOException {
        if (((String) thisuser.getRole()) == "Admin"){
            Parent home_page_parent = FXMLLoader.load(getClass().getClassLoader().getResource("EditPrice.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
    }
}
