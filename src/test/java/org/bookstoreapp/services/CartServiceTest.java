package org.bookstoreapp.services;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.bookstoreapp.model.Book;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CartServiceTest extends ApplicationTest{

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
    public void testAddOneBooktoCart() {
        Book Booktest = new Book("testautor","testtitle",30.0,"/testurl");
        CartService.AddBooktoCart(Booktest);
        assertNotNull(CartService.Cartbooks);
        assertEquals(1, CartService.Cartbooks.size());
    }

    @Test
    public void testAddTwoBookstoCart() {
        Book Booktest1 = new Book("testautor1","testtitle1",33.0,"/testurl1");
        Book Booktest2 = new Book("testautor2","testtitle2",35.0,"/testurl2");
        CartService.AddBooktoCart(Booktest1);
        CartService.AddBooktoCart(Booktest2);
        assertNotNull(CartService.Cartbooks);
        assertEquals(2, CartService.Cartbooks.size());
    }
}