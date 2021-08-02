package edu.txstate.library.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;

public class User implements LibraryMember {
    private static final int TWO_WEEKS = 14;
    private static final int THREE_WEEKS = 21;

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
     * @return a float representation of a user's past due balance
     * @author Carlos Jobe
     */
    public float calculatePastDueBalance() {
        int days = 0;
        float pastDueBalance = 0.0f;
        float itemFineDue;

        for (Item i : items) {
            if (i instanceof Book) {
                days = calculateBookLateDays((Book) i);
            } else if (i instanceof AVMaterial) {
                days = calculateAVMLateDays(i);
            }

            itemFineDue = days * Item.DAILY_OVERDUE_FINE;
            if (itemFineDue > i.value) {
                itemFineDue = i.value;
            }
            pastDueBalance = pastDueBalance + itemFineDue;
        }

        return pastDueBalance;
    }

    // helper for calculating number of days past due for Books
    public int calculateBookLateDays(Book i) {
        int days;
        Period difference = Period.between(i.checkoutDate, LocalDate.now(ZoneId.of("America/Chicago")));
        if (i.isBestSeller) {
            days = (difference.getDays() - TWO_WEEKS);
        } else {
            days = (difference.getDays() - THREE_WEEKS);
        }

        if (days < 0) {
            days = 0;
        }

        return days;
    }

    // helper for calculating number of days past due for AV Materials
    public int calculateAVMLateDays(Item i) {
        Period difference = Period.between(i.checkoutDate, LocalDate.now(ZoneId.of("America/Chicago")));
        int days = (difference.getDays() - TWO_WEEKS);

        if (days < 0) {
            days = 0;
        }

        return days;
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

    /**
     * @author Boris
     * We must guard against ConcurrentModificationException.
     * Before finishing our iteration we are removing an element, which triggers the exception.
     */
    public void returnOverdueItems() {
        int days = 0;

        Iterator<Item> iter = items.iterator();
        while(iter.hasNext()) {
            Item i = iter.next();

            if (i instanceof Book) {
                days = calculateBookLateDays((Book) i);
            } else if (i instanceof AVMaterial) {
                days = calculateAVMLateDays(i);
            }

            // if days is more than zero, item is late. Return it.
            // reset dates for the item in Library inventory and remove
            // from user inventory
            if (days > 0) {
                iter.remove();
                Item tmpItem = Library.getInventoryItem(i.getItemNumber());
                if (tmpItem != null) {
                    tmpItem.setDueDate(null);
                    tmpItem.setCheckoutDate(null);
                }
            }
        }
    }
}
