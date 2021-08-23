package edu.txstate.library.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {
    private ArrayList<Item> ITEMS;
    private static final String CARD_NUM = "4321";

//    @BeforeEach
//    void setUp() {
//        // create predefined user with known card number 4321
//        User user = new User("Michael", "123 Somestreet", "555-555-5555");
//        user.getCard().setCardNumber(CARD_NUM);
//        //populate a list of items
//        Item item1 = new Item("Author One", "Book One", "Pub One", "Genre One", 9.99);
//        ITEMS.add(item1);
//        Item item2 = new Item("Author Two", "Book Two", "Pub Two", "Genre Two", 4.49);
//        ITEMS.add(item2);
//        // add predefined user with known set of items to the Library
//        user.setItems(ITEMS);
//        Library.addUser(user);
//    }

    @AfterEach
    void tearDown() {
    }

//    @Test
//    void getItems_existingUser_returnsArrayList(Items) {
//        User user = Library.getUser(CARD_NUM);
//        assertEquals(user.getItems(), ITEMS);
//    }
}