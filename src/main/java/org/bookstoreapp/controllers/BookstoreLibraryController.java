package org.bookstoreapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.bookstoreapp.model.Book;
import org.bookstoreapp.services.BookService;

import java.io.IOException;
import java.util.List;

public class BookstoreLibraryController {

    @FXML
    public AnchorPane booksPane;
    @FXML
    private VBox booksVBox;

    @FXML
    public void initialize() throws IOException {
        List<Book> books = BookService.getAllBooks();

        for (Book book : books) {

           BookController controller = new BookController(book);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Book.fxml"));
            fxmlLoader.setController(controller);
            AnchorPane bookPane = fxmlLoader.load();

            booksVBox.getChildren().add(bookPane);
        }
    }
}
