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
    private static final Path ORDERS_PATH = FileSystemService.getPathToFile("config", "orders.json");
    private static List<Order> orders= new ArrayList<>();

    public static void loadOrdersFromFile() throws IOException {

        if (!Files.exists(ORDERS_PATH)) {
            FileUtils.copyURLToFile(DeliveryService.class.getClassLoader().getResource("orders.json"), ORDERS_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        orders = objectMapper.readValue(ORDERS_PATH.toFile(), new TypeReference<List<Order>>() {
        });
    }

    public static void addOrder(String FullName, String DeliveryAdress, String Email, String PhoneNr) {

        orders.add(new Order(FullName, DeliveryAdress, Email, PhoneNr));
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
