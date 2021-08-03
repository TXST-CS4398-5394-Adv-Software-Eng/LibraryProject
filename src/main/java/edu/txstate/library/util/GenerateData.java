package edu.txstate.library.util;

import com.github.javafaker.Faker;
import edu.txstate.library.controllers.LibraryController;
import edu.txstate.library.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Random;
import java.util.logging.Logger;

/**
 *
 */
public class GenerateData {
    private final static Logger logger = Logger.getLogger(LibraryController.class.getName());
    private static DecimalFormat decimalFormat = new DecimalFormat("0.00");
    private final static Faker FAKER = new Faker();
    private final static String DATA_FILE_NAME = "data.csv";
    private final static String ITEMS_FILE_NAME = "itemsData.csv";

    private GenerateData() {
    } // prevent creation of instances

    /**
     * helper method to generate a user
     *
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
     *
     * @return a Book object
     */
    public static Book generateBook() {
        final int MAX_VAL = 20;
        final int MIN_VAL = 1;
        Random random = new Random();
        decimalFormat.setRoundingMode(RoundingMode.UP);
        Float randValue = (random.nextFloat() * (MAX_VAL - MIN_VAL));
        String formattedFloat = decimalFormat.format(randValue);

        return new Book(FAKER.book().author(), FAKER.book().title(), FAKER.book().publisher(),
                FAKER.book().genre(), Float.parseFloat(formattedFloat), random.nextBoolean());
    }

    /**
     * userID, name, addr, phone, author, title, publisher, genre, value, bestseller
     * if genre is AVMAT then ignore bestseller
     * <p>
     * predefinedUsers.data
     * 12 data lines - 3 users with 4 items (book or AVMAT) per person
     * Total 30 data lines
     * <p>
     * Book that is a best seller:
     * 1, Boris, 55 Way, 555-555-5555, Carlos, Wu Tang Inc., Mythology, 10.0, true
     * <p>
     * AVMaterial:
     * 1, Boris, 55 Way, 555-555-5555, Carlos, Wu Tang Inc., AVMAT, 10.0, false
     */
    public static void addPredefinedData() {
        processDataFile();
        processItemDataFile();
    }

    public static User generateSinglePredefinedUser() {
        User highBalUser = new User("Boris", "55 Way", "555-555-5555");
        highBalUser.getCard().setCardNumber("1");
        return highBalUser;
    }

    public static Book generateSinglePredefinedBook() {
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
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        GenerateData.class.getResourceAsStream("/" + DATA_FILE_NAME)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                logger.info("Processing line: " + line);
                String[] components = line.split(",");

                // if user does not exist, create a user
                // otherwise process the items, where we do not require uniqueness
                // i.e., we can have multiple copies of any one item.
                if (Library.getUser(components[0]) == null) {
                    processUserFromParts(components);
                }

                processItemFromParts(components);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * parts[0] - UID
     * parts[1] - Name
     * parts[2] - Addr
     * parts[3] - Phone
     * parts[10] - isChild
     *
     * @param parts String array of data needed for unmarshalling a User
     */
    private static void processUserFromParts(String[] parts) {
        boolean isChild = Boolean.parseBoolean(parts[10]);
        User user;

        if (isChild) {
            user = new Child(parts[1], parts[2], parts[3]);
        } else {
            user = new User(parts[1], parts[2], parts[3]);
        }

        user.getCard().setCardNumber(parts[0]);
        Library.addUser(user);
    }

    /**
     * We must add the Item to both the user's inventory and the library's.
     * An item can be either a Book or Audio/Visual Material. If a book, it can be a bestseller.
     * parts[4] - author
     * parts[5] - title
     * parts[6] - publisher
     * parts[7] - genre; if AVMAT, this is AV Material and we do not sue the last field (bestseller)
     * parts[8] - value as a float
     * parts[9] - isBestSeller (not used if genre is AVMAT)
     *
     * For all books, checkout date was 4 weeks ago.
     * Due date is then either 2 weeks ago for Audio/Visual material and best selleing books
     * Or 1 week ago for standard books
     *
     * @param parts String array of data needed for unmarshalling an Item
     */
    private static void processItemFromParts(String[] parts) {
        Item item;
        float value = getFloatValue(parts[8]);

        LocalDate checkoutDate = LocalDate.now(ZoneId.of("America/Chicago")).minusWeeks(4);
        LocalDate dueDate;

        if (parts[7].trim().toLowerCase().equals("avmat")) {
            logger.info("Creating new AV Material item!");
            item = new AVMaterial(parts[4], parts[5], parts[6], parts[7], value);
            dueDate = checkoutDate.plusWeeks(2);
            item.setCheckoutDate(checkoutDate);
            item.setDueDate(dueDate);
        } else {  // a book
            boolean isBestSeller = Boolean.parseBoolean(parts[9].trim());
            item = new Book(parts[4], parts[5], parts[6], parts[7], value, isBestSeller);
            if (isBestSeller) {
                dueDate = checkoutDate.plusWeeks(2);
            } else {
                dueDate = checkoutDate.plusWeeks(3);
            }

            item.setCheckoutDate(checkoutDate);
            item.setDueDate(dueDate);
        }

        Library.getUser(parts[0]).addItem(item); // must add item to user's checked out list also
        Library.addItem(item);
    }

    private static void processItemDataFile() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        GenerateData.class.getResourceAsStream("/" + ITEMS_FILE_NAME)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                logger.info("Processing items data line: " + line);
                String[] parts = line.split(",");

                Item item;
                float value = getFloatValue(parts[4]);

                if (parts[3].trim().toLowerCase().equals("magz")) {
                    item = new Magazine(parts[0], parts[1], parts[2], parts[3], value);
                } else {  // a reference book
                    item = new ReferenceBook(parts[0], parts[1], parts[2], parts[3], value, false);
                }

                Library.addItem(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static float getFloatValue(String val) {
        float value = 0.0f;

        try {
            value = Float.parseFloat(val);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return value;
    }
}
