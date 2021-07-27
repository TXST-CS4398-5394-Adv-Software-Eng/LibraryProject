package edu.txstate.library.model;

public class Book extends Item {
    boolean isBestSeller;

    Book() {}

    public Book(String author, String title, String publisher, String genre, float value, boolean isBestSeller)
    {
        super(author, title, publisher, genre, value);
        this.isBestSeller = isBestSeller;
    }
}
