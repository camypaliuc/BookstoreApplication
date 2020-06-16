package org.bookstoreapp.model;

import java.util.List;



public class Cart {

    private String user;
    public static List<Book> CartBooks;

    public Cart(){

    }

    public Cart(String user) {
        this.user = user;
    }
}
