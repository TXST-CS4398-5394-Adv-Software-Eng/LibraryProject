package edu.txstate.library.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Library {
    private ArrayList<User> listOfUsers;
    private ArrayList<Item> inventory;
    private HashMap<UUID, ArrayList<Item>> itemRequests;

    public ArrayList<User> getListOfUsers() {
        return listOfUsers;
    }

    public void setListOfUsers(ArrayList<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public HashMap<UUID, ArrayList<Item>> getItemRequests() {
        return itemRequests;
    }

    public void setItemRequests(HashMap<UUID, ArrayList<Item>> itemRequests) {
        this.itemRequests = itemRequests;
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
