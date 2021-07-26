package edu.txstate.library.model;

import java.time.LocalDate;
import java.util.UUID;

public class Item {
    String itemNumber;
    final static float DAILY_OVERDUE_FINE = 0.10f;
    LocalDate checkoutDate;
    LocalDate dueDate;

    public Item() {
        this.itemNumber = UUID.randomUUID().toString();
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
}
