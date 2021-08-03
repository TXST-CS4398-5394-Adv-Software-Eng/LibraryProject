package edu.txstate.library.util;

import edu.txstate.library.model.Book;
import edu.txstate.library.model.Item;
import edu.txstate.library.model.User;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerateDataTest {

    @BeforeEach
    void setUp() {
        System.out.println("Executing another test");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void generateUser_execute_returnsNonNullUserObj() {
        User testUser = GenerateData.generateUser();
        assertNotNull(testUser);
    }

    /**
     * @author Tyler Fain
     *
     */
    @Test
    void generateBook_execute_returnsBookObject() {
        // TODO: call the generateBook method and capture it in an Item object, not a Book obj
        //  test that item is instanceof Book for test case to pass
    }

    /**
     * @author
     */
    @Test
    void getFloatValue_obtainFloat() {

    }
}