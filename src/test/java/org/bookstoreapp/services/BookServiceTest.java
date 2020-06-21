package org.bookstoreapp.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.bookstoreapp.model.User;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.bookstoreapp.model.Book;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import static org.junit.Assert.*;

public class BookServiceTest extends ApplicationTest {

    @BeforeClass
    public static void setupClass() {
        FileSystemService.APPLICATION_FOLDER = ".test-registration-example";
        FileSystemService.initApplicationHomeDirIfNeeded();
    }

    @Before
    public void setUp() throws IOException {
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomePath().toFile());
    }

    @Test
    public void testCopyDefaultFileIfNotExists() throws Exception {
        BookService.loadBooksFromFile();
        assertTrue(Files.exists(BookService.BOOKS_PATH));
    }

    @Test
    public void testLoadBooksFromFile() throws Exception {
        BookService.loadBooksFromFile();
        assertNotNull(BookService.books);
        assertEquals(0, BookService.books.size());
    }

    @Test
    public void testAddOneBook() throws Exception {
        BookService.loadBooksFromFile();
        BookService.addBook("testautor", "testtitle", 20.0,"/testurl");
        assertNotNull(BookService.books);
        assertEquals(1, BookService.books.size());
    }

    @Test
    public void testAddTwoBook() throws Exception {
        BookService.loadBooksFromFile();
        BookService.addBook("testautor1", "testtitle1", 21.0,"/testurl1");
        BookService.addBook("testautor2", "testtitle2", 22.0,"/testurl2");
        assertNotNull(BookService.books);
        assertEquals(2, BookService.books.size());
    }
    @Test
    public void testAddOneBookIsPersisted() throws Exception {
        BookService.loadBooksFromFile();
        BookService.addBook("testautor", "testtitle", 20.0,"/testurl");
        List<Book> books  = new ObjectMapper().readValue(BookService.BOOKS_PATH.toFile(), new TypeReference<List<Book>>() {
        });
        assertNotNull(books);
        assertEquals(1, books.size());
    }

    @Test
    public void testAddTwoBooksArePersisted() throws Exception {
        BookService.loadBooksFromFile();
        BookService.addBook("testautor1", "testtitle1", 23.0,"/testurl1");
        BookService.addBook("testautor2", "testtitle2", 27.0,"/testurl2");
        List<Book> books  = new ObjectMapper().readValue(BookService.BOOKS_PATH.toFile(), new TypeReference<List<Book>>() {
        });
        assertNotNull(books);
        assertEquals(2, books.size());
    }
}