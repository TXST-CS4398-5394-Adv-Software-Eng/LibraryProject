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

    boolean isRenewed;
    boolean isRequested;
    String requestingUserId;

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
        this.checkoutDate = null;
        this.dueDate = null;
        this.isRenewed = false;
        this.isRequested = false;
        this.requestingUserId = "";
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

    public boolean isRenewed() {
        return isRenewed;
    }

    public void setRenewed(boolean renewed) {
        isRenewed = renewed;
    }

    public boolean isRequested() {
        return isRequested;
    }

    public void setRequested(boolean requested) {
        isRequested = requested;
    }

    public String getRequestingUserId() {
        return requestingUserId;
    }

    public void setRequestingUserId(String requestingUserId) {
        this.requestingUserId = requestingUserId;
    }
}
