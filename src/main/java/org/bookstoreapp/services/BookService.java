package org.bookstoreapp.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.bookstoreapp.exceptions.CouldNotWriteBooksException;
import org.bookstoreapp.model.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;


public class BookService {
     static Path BOOKS_PATH = FileSystemService.getPathToFile("config", "books.json");
     static List<Book> books;

    public static void loadBooksFromFile() throws IOException {

        if (!Files.exists(BOOKS_PATH)) {
            FileUtils.copyURLToFile(BookService.class.getClassLoader().getResource("books.json"), BOOKS_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        books = objectMapper.readValue(BOOKS_PATH.toFile(), new TypeReference<List<Book>>() {
        });
    }

    public static void addBook(String author, String title, Double price, String url) {

        books.add(new Book(author, title, price, url));
        persistBooks();
    }

    private static void persistBooks() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(BOOKS_PATH.toFile(), books);
        } catch (IOException e) {
            throw new CouldNotWriteBooksException();
        }
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }

    public static List<Book> getAllBooks() {
        return books;
    }
}
