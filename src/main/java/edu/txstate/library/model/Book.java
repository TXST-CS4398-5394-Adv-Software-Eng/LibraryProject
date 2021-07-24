package edu.txstate.library.model;

public class Book extends Item {
    String author;
    String title;
    String publisher;
    String genre;

    public Book(String author, String title, String publisher, String genre)
    {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
    }
}
