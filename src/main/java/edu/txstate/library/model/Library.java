package edu.txstate.library.model;

import edu.txstate.library.util.GenerateData;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Library {
    private static ArrayList<User> listOfUsers;
    private static ArrayList<Item> inventory;
    private static HashMap<UUID, ArrayList<Item>> itemRequests;

    static {
        listOfUsers = new ArrayList<>();
        inventory = new ArrayList<>();

        // create 10 users and 10 books
        for (int i = 0; i < 10; i++) {
            listOfUsers.add(GenerateData.generateUser());
            inventory.add(GenerateData.generateBook());
        }

        addPredefinedData();
    }

    private Library() {
        // prevent creation of instances
    }

    public static ArrayList<User> getListOfUsers() {
        return listOfUsers;
    }

    public static void setListOfUsers(ArrayList<User> usersList) {
        listOfUsers = usersList;
    }

    public static ArrayList<Item> getInventory() {
        return inventory;
    }

    public static void setInventory(ArrayList<Item> libraryItems) {
        inventory = libraryItems;
    }

    public static HashMap<UUID, ArrayList<Item>> getItemRequests() {
        return itemRequests;
    }

    public static void setItemRequests(HashMap<UUID, ArrayList<Item>> itemsRequested) {
        itemRequests = itemsRequested;
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
    private static void addPredefinedData() {
        User highBalUser = new User("Boris", "55 Way", "555-555-5555");
        highBalUser.card.setCardNumber("1");

        Book lateBook = new Book("Carlos", "Where my money at?", "Wu Tang Inc.",
                "Mythology", 10.0f, true);
        LocalDate pastDate = LocalDate.now(ZoneId.of("America/Chicago")).minusWeeks(3);
        LocalDate dueDate = pastDate.plusWeeks(2);
        lateBook.setCheckoutDate(pastDate);
        lateBook.setDueDate(dueDate);
        lateBook.setItemNumber("1");

        listOfUsers.add(highBalUser);
        inventory.add(lateBook);
    }

}
