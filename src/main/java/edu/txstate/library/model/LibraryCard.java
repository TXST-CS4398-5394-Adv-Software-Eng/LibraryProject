package edu.txstate.library.model;

import java.util.UUID;

public class LibraryCard {
    UUID cardNumber;

    LibraryCard()
    {
        this.cardNumber = UUID.randomUUID();
    }

    public UUID getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(UUID cardNumber) {
        this.cardNumber = cardNumber;
    }
}
