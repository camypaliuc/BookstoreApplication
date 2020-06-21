package org.bookstoreapp.controllers;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.apache.commons.io.FileUtils;
import org.bookstoreapp.services.FileSystemService;
import org.bookstoreapp.services.UserService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.bookstoreapp.services.BookService;
import org.bookstoreapp.services.CartService;
import org.bookstoreapp.model.Book;
import org.testfx.framework.junit.ApplicationTest;

import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class BookControllerTest extends ApplicationTest {
    public static final String TEST_BOOK = "testBook";
    private BookController bookController;

    @BeforeClass
    public static void setupClass() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".test-registration-example";
        FileSystemService.initApplicationHomeDirIfNeeded();
        BookService.loadBooksFromFile();
    }

    @Before
    public void setUp() throws Exception {
        FileUtils.cleanDirectory(FileSystemService.getPathToFile().toFile());
        BookService.loadBooksFromFile();

        bookController = new BookController();
        bookController.author = new Text();
        bookController.title = new Text();
        bookController.priceNumber = new Text();

        bookController.author.setText("testautor");
        bookController.title.setText("testtitle");
        bookController.priceNumber.setText("35");
    }

    @Test
    public void testHandleAddToCart() {
        bookController.handleAddToCartAction();
        assertEquals(1, CartService.getAllOrderedBooks().size());

    }

}