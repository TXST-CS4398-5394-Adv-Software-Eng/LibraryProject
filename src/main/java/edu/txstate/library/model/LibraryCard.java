package edu.txstate.library.model;

import java.util.UUID;

public class LibraryCard {
    String cardNumber;

    LibraryCard()
    {
        this.cardNumber = UUID.randomUUID().toString();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
