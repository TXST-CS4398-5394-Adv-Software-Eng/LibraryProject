package edu.txstate.library.util;

import com.github.javafaker.Faker;
import edu.txstate.library.controllers.LibraryController;
import edu.txstate.library.model.Book;
import edu.txstate.library.model.Library;
import edu.txstate.library.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Random;
import java.util.logging.Logger;

/**
 *
 */
public class GenerateData {
    private final static Logger logger = Logger.getLogger(LibraryController.class.getName());
    private final static Faker FAKER = new Faker();
    private final static String DATA_FILE_NAME = "data.txt";

    private GenerateData() {
    } // prevent creation of instances

    /**
     * helper method to generate a user
     * @return a User object
     */
    public static User generateUser() {
        String name = FAKER.name().firstName() + " " + FAKER.name().lastName();
        String addr = FAKER.address().buildingNumber() + " " + FAKER.address().streetAddress() + ", " +
                FAKER.address().city() + " " + FAKER.address().zipCode();
        return new User(name, addr, FAKER.phoneNumber().cellPhone());
    }

    /**
     * helper method to generate a book
     * @return a Book object
     */
    public static Book generateBook() {
        final int MAX_VAL = 20;
        final int MIN_VAL = 1;
        Random random = new Random();

        return new Book(FAKER.book().author(), FAKER.book().title(), FAKER.book().publisher(),
                FAKER.book().genre(), random.nextFloat() * (MAX_VAL - MIN_VAL), random.nextBoolean());
    }

    /**
     * userID, name, addr, phone, author, title, publisher, genre, value, bestseller
     * if genre is AVMAT then ignore bestseller
     *
     * predefinedUsers.data
     * 12 data lines - 3 users with 4 items (book or AVMAT) per person
     * Total 30 data lines
     *
     * Book that is a best seller:
     * 1, Boris, 55 Way, 555-555-5555, Carlos, Wu Tang Inc., Mythology, 10.0, true
     *
     * AVMaterial:
     * 1, Boris, 55 Way, 555-555-5555, Carlos, Wu Tang Inc., AVMAT, 10.0, false
     */
    public static void addPredefinedData(Library library) {
        processDataFile();
    }

    private static User generateSinglePredefinedUser() {
        User highBalUser = new User("Boris", "55 Way", "555-555-5555");
        highBalUser.getCard().setCardNumber("1");
        return highBalUser;
    }

    private static Book generateSinglePredefinedBook() {
        Book lateBook = new Book("Carlos", "Where my money at?", "Wu Tang Inc.",
                "Mythology", 10.0f, true);
        LocalDate pastDate = LocalDate.now(ZoneId.of("America/Chicago")).minusWeeks(3);
        LocalDate dueDate = pastDate.plusWeeks(2);
        lateBook.setCheckoutDate(pastDate);
        lateBook.setDueDate(dueDate);
        lateBook.setItemNumber("1");

        return lateBook;
    }

    private static void processDataFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                logger.info("Processing line: " + line);
                String[] components = line.split(",");

                if (Library.getUser(components[0]) == null) {
                    processUserFromLineParts(components);
                } else {
                    processItemFromLineParts(components);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processUserFromLineParts(String[] parts) {

    }

    private static void processItemFromLineParts(String[] parts) {

    }
}
