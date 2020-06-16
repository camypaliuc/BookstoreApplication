package org.bookstoreapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.bookstoreapp.model.Book;


public class OrderedBookController {
    public Book book;

    @FXML
    private TextField author;
    @FXML
    private TextField title;
    @FXML
    private TextField price;
    @FXML
    public void initialize(){
        author.setText(book.getAuthor());
        title.setText(book.getTitle());
       price.setText(String.valueOf(book.getPrice()));
    }

    public OrderedBookController(Book book) {
        this.book = book;
    }
}
