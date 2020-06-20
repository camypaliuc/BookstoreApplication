package org.bookstoreapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.bookstoreapp.model.Book;
import org.bookstoreapp.model.Order;
import org.bookstoreapp.services.CartService;

import java.io.IOException;
import java.util.List;

public class ClientOrderItemController {

        private Order order;
        private Book book;
        @FXML
        private Text name;
        @FXML
        private Text adress;
        @FXML
        private Text email;
        @FXML
        private Text phoneNr;
        @FXML
        private Text status;
        @FXML
        private AnchorPane deliverybooksPane;
        @FXML
        private VBox deliverybooksVBox;

        public ClientOrderItemController(Order order) {
            this.order = order;
        }
        @FXML
        public void initialize() throws IOException {
            List<Book> deliveryBooks = CartService.getAllOrderedBooks();
            name.setText(order.getFullName());
            adress.setText(order.getDeliveryAdress());
            email.setText(order.getEmail());
            phoneNr.setText(order.getPhoneNr());
            if(order.getAccepted() == 1){
                status.setText("Order is shipping");
            }
            else{
                status.setText("Your order has been denied");
            }
            for (Book book : deliveryBooks) {
                OrderedBookController controller = new OrderedBookController(book);
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("OrderedBook.fxml"));
                fxmlLoader.setController(controller);
                AnchorPane deliverybooksPane = fxmlLoader.load();
                deliverybooksVBox.getChildren().add(deliverybooksPane);
            }
        }

}
