package edu.txstate.library.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.UUID;

public class Item {
    final static float DAILY_OVERDUE_FINE = 0.10f;

    String itemNumber;
    String author;
    String title;
    String publisher;
    String genre;
    float value;

    LocalDate checkoutDate;
    LocalDate dueDate;

    public Item() {
        this.itemNumber = UUID.randomUUID().toString();
    }

    public Item(String author, String title, String publisher, String genre, float value) {
        this();
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
        this.value = value;
        checkoutDate = null;
        dueDate = null;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }
}
