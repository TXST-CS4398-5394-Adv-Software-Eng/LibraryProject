package edu.txstate.library.util;

import com.github.javafaker.Faker;
import edu.txstate.library.model.Book;
import edu.txstate.library.model.User;

/**
 *
 */
public class GenerateData {
    private GenerateData() {
    } // prevent creation of instances

    static Faker faker = new Faker();

    /**
     * helper method to generate a user
     * @return a User object
     */
    public static User generateUser() {
        String name = faker.name().firstName() + " " + faker.name().lastName();
        String addr = faker.address().buildingNumber() + " " + faker.address().streetAddress() + ", " +
                faker.address().city() + " " + faker.address().zipCode();
        return new User(name, addr, faker.phoneNumber().cellPhone());
    }

    /**
     * helper method to generate a book
     * @return a Book object
     */
    public static Book generateBook() {
        return new Book(faker.book().author(), faker.book().title(), faker.book().publisher(), faker.book().genre());
    }
}
