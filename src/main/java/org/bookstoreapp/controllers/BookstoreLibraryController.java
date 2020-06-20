package org.bookstoreapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.bookstoreapp.model.Book;
import org.bookstoreapp.services.BookService;
import java.io.IOException;
import java.util.List;
import org.bookstoreapp.model.User;

public class BookstoreLibraryController {
    @FXML
    public AnchorPane booksPane;
    @FXML
    private VBox booksVBox;
    @FXML
    private Text rightsMessage;
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

    @FXML
    public void handleFinishOrderAction(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getClassLoader().getResource("Deliveryform.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    public static User thisuser = RegistrationController.currentuser;
    @FXML
    public void handleAddBookButton(ActionEvent event) throws IOException {
        if (((String) thisuser.getRole()) == "Admin") {
            Parent home_page_parent = FXMLLoader.load(getClass().getClassLoader().getResource("NewBook.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else {
            rightsMessage.setText("You do not own the rights for this operation!");
        }
    }
    @FXML
    public void handleViewOrdersButton(ActionEvent event) throws IOException {
        if (((String) thisuser.getRole()) == "Admin") {
            Parent home_page_parent = FXMLLoader.load(getClass().getClassLoader().getResource("OrdersProcessing.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        if (((String) thisuser.getRole()) == "Client") {
            Parent home_page_parent = FXMLLoader.load(getClass().getClassLoader().getResource("ClientOrders.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
    }
    @FXML
    public void handleLogOutButton (ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

}
