package org.bookstoreapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.bookstoreapp.services.BookService;
import org.bookstoreapp.services.DeliveryService;
import org.bookstoreapp.services.UserService;
public class Main extends Application {
    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        UserService.loadUsersFromFile();
        BookService.loadBooksFromFile();
        DeliveryService.loadOrdersFromFile();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        primaryStage.setTitle("Bookstore Application");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
}
