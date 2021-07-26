package edu.txstate.library.model;

import java.util.UUID;

public class Book extends Item {
    String author;
    String title;
    String publisher;
    String genre;
    boolean isBestSeller;

    Book() {}

    public Book(String author, String title, String publisher, String genre, boolean isBestSeller)
    {
        super();
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
        this.isBestSeller = isBestSeller;
    }
}
