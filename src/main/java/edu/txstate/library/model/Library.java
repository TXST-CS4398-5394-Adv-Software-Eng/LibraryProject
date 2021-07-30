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

        // create 10 users and 10 books
        for (int i = 0; i < 10; i++) {
            listOfUsers.add(GenerateData.generateUser());
            inventory.add(GenerateData.generateBook());
        }
        addUser(GenerateData.generateSinglePredefinedUser());
        addItem(GenerateData.generateSinglePredefinedBook());
        GenerateData.addPredefinedData();
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

    public static void addUser(User user) {
        listOfUsers.add(user);
    }

    public static void addItem(Item item) {
        inventory.add(item);
    }

    public static User getUser(String cardNum) {
        User user = null;
        for (User u : listOfUsers) {
            if (u.getCard().getCardNumber().equals(cardNum)) {
                user = u;
            }
        }
        return user;
    }

    /**
     * @author Michael Brady
     * @param user
     * @return
     */
    public static ArrayList<Item> getUserItems(User user){
        return user.getItems();
    }

}
