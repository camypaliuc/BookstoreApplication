package org.bookstoreapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.bookstoreapp.model.Order;
import org.bookstoreapp.model.User;
import org.bookstoreapp.services.BookService;
import org.bookstoreapp.services.DeliveryService;

import java.io.IOException;
import java.util.List;

public class ClientOrdersController {
    @FXML
    public AnchorPane deliveryPane;
    @FXML
    private VBox deliveryVbox;
    @FXML
    private Text rightsMessage;

    public static User thisuser = RegistrationController.currentuser;

    @FXML
    public void initialize() throws IOException {
        List<Order> orders = DeliveryService.getAllOrders();
        BookService.loadBooksFromFile();
        DeliveryService.loadOrdersFromFile();

        for (Order order : orders) {
            if (((String) thisuser.getUsername()).equals(order.getUserName())){
            ClientOrderItemController controller = new ClientOrderItemController(order);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("ClientOrderItem.fxml"));
            fxmlLoader.setController(controller);
            AnchorPane dPane = fxmlLoader.load();
            deliveryVbox.getChildren().add(dPane);
            }
        }
    }
    @FXML
    public void handleBackButton(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getClassLoader().getResource("BookstoreLibrary.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
}
