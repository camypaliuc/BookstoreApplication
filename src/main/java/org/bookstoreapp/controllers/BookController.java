package org.bookstoreapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.bookstoreapp.model.Book;
import org.bookstoreapp.services.CartService;

import java.io.File;
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
}
