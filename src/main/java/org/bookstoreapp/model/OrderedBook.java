package org.bookstoreapp.model;


public class OrderedBook {

    private String author;
    private String title;
    private Double price;


    public OrderedBook(){

    }

    public OrderedBook(String title2, String author2, double priceNumber2) {
        this.author = author2;
        this.title = title2;
        this.price = priceNumber2;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    @Override
    public String toString() {
        return "OrderedBook{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}