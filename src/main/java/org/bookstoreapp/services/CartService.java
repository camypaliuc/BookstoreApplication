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
import java.util.ArrayList;
import java.util.List;

public class
CartService {
    private static final Path BOOKS_PATH = FileSystemService.getPathToFile("config", "books.json");
    private static final Path USERS_PATH = FileSystemService.getPathToFile("config", "users.json");
    private static List<Book> Cartbooks = new ArrayList<>();


    public static void AddBooktoCart(Book e){
        Cartbooks.add( e );
    }

    public static List<Book> getAllOrderedBooks() {
        return Cartbooks;
    }

}
