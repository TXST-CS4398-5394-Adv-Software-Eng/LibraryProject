package edu.txstate.library.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private static final String CARD_NUM = "1234";

    @BeforeEach
    void setUp() {
        // create predefined user with known card number 1234
        User user = new User("Boris", "55 Way", "555-555-5555");
        user.getCard().setCardNumber(CARD_NUM);
        Library.addUser(user);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUser_existingUser_returnsValidObj() {
        User user = Library.getUser(CARD_NUM);
        assertEquals(user.getCard().getCardNumber(), CARD_NUM);
    }
}