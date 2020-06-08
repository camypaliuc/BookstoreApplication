package org.bookstoreapp.model;


public class Book {

    private String author;
    private String title;
    private Double price;
    private String url;

    public Book(){

    }

    public Book(String author2, String title2, double priceNumber2) {

    }


    public Book(String author, String title, double price, String url) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", url='" + url + '\'' +
                '}';
    }
}
