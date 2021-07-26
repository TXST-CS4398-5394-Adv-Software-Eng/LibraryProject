package edu.txstate.library.model;

import edu.txstate.library.util.GenerateData;

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

        for (int i = 0; i < 10; i++) {
            listOfUsers.add(GenerateData.generateUser());
            inventory.add(GenerateData.generateBook());
        }
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
     * Creates a report for a single user - the books they have checked out, their due dates,
     * the outstanding fee they owe.
     * @param user for whom to calculate a report
     */
    String calculateUserItems(User user)
    {
        return "";
    }

    /**
     * Creates a report for all users - the books they have checked out, their due dates,
     * the outstanding fee they owe.
     */
    String calculateUserItems() {
        return "";
    }
}
