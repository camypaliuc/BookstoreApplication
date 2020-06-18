package org.bookstoreapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.bookstoreapp.model.Book;
import org.bookstoreapp.model.Order;
import javafx.scene.control.TextField;
import org.bookstoreapp.services.CartService;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class OrderItemController {
    private Order order;
    private Book book;
    @FXML
    private TextField name;
    @FXML
    private TextField adress;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private Text deliveryprocessMessage;
    @FXML
    private AnchorPane deliverybooksPane;
    @FXML
    private VBox deliverybooksVBox;
    public OrderItemController(Order order) {
        this.order = order;
    }
    @FXML
    public void initialize() throws IOException {
        List<Book> deliveryBooks = CartService.getAllOrderedBooks();
        name.setText(order.getFullName());
        adress.setText(order.getDeliveryAdress());
        email.setText(order.getEmail());
        phone.setText(order.getPhoneNr());
        for (Book book : deliveryBooks) {
            OrderedBookController controller = new OrderedBookController(book);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("OrderedBook.fxml"));
            fxmlLoader.setController(controller);
            AnchorPane deliverybooksPane = fxmlLoader.load();
            deliverybooksVBox.getChildren().add(deliverybooksPane);
        }
    }
    @FXML
    public void handleApproveButton() {
        order.setAccepted();
        deliveryprocessMessage.setText("You have succesfully approved this order!");
    }
    @FXML
    public void handleDenyButton() {
        deliveryprocessMessage.setText("This order is denyed!");
    }

}
