package edu.txstate.library.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

public class User implements LibraryMember {
    LibraryCard card;
    String name;
    String address;
    String phoneNum;
    ArrayList<Item> items;
    float balance;

    public User(String name, String addr, String phone) {
        card = new LibraryCard();
        items = new ArrayList<>();
        this.name = name;
        this.address = addr;
        this.phoneNum = phone;
    }

    @Override
    public boolean checkoutItem(String uuid) {
        boolean isCheckoutSuccessful = false;

        LocalDate checkoutDate = LocalDate.now(ZoneId.of("America/Chicago"));


        return isCheckoutSuccessful;
    }

    @Override
    public void returnItem(Item i) {

    }

    @Override
    public void requestItem(Item i) {

    }

    @Override
    public boolean renewItem(Item i) {
        return false;
    }

    @Override
    public void payFine(float balance) {

    }

    @Override
    public Item searchItem(String s) {
        return null;
    }

    @Override
    public void queryAccount() {

    }

    /**
     * @author Carlos Jobe
     * @return a float representation of a user's past due balance
     */
    public float calculatePastDueBalance() {

        return 0.0f;
    }

    public LibraryCard getCard() {
        return card;
    }

    public void setCard(LibraryCard card) {
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
