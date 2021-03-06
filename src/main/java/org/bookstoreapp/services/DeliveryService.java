package org.bookstoreapp.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.bookstoreapp.exceptions.CouldNotWriteOrderException;
import org.bookstoreapp.exceptions.CouldNotWriteUsersException;
import org.bookstoreapp.exceptions.UsernameAlreadyExistsException;
import org.bookstoreapp.exceptions.WrongUsernameorPasswordException;
import org.bookstoreapp.model.Book;
import org.bookstoreapp.model.Order;
import org.bookstoreapp.model.User;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DeliveryService {
     static  Path ORDERS_PATH = FileSystemService.getPathToFile("config", "orders.json");
     static List<Order> orders= new ArrayList<>();

    public static void loadOrdersFromFile() throws IOException {

        if (!Files.exists(ORDERS_PATH)) {
            FileUtils.copyURLToFile(DeliveryService.class.getClassLoader().getResource("orders.json"), ORDERS_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        orders = objectMapper.readValue(ORDERS_PATH.toFile(), new TypeReference<List<Order>>() {
        });
    }

    public static void addOrder(String username ,String FullName, String DeliveryAdress, String Email, String PhoneNr, int accepted) {
        orders.add(new Order(username, FullName, DeliveryAdress, Email, PhoneNr, 0));
        persistOrders();
    }

    public static void updateOrder(String username ,String FullName, String DeliveryAdress, String Email, String PhoneNr, int accepted) {
        orders.remove("username");
        persistOrders();
        orders.add(new Order(username, FullName, DeliveryAdress, Email, PhoneNr, 1));
        persistOrders();
    }

    private static void persistOrders() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(ORDERS_PATH.toFile(), orders);
        } catch (IOException e) {
            throw new CouldNotWriteOrderException();
        }
    }

    public static List<Order> getAllOrders() {
        return orders;
    }
}
