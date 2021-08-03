package edu.txstate.library.model;

public class Child extends  User {
    private static final int ITEM_LIMIT = 5;

    public Child(String name, String address, String phoneNum) {
        super(name, address, phoneNum);
    }

    @Override
    public String checkoutItem(String itemNumber) {
        if (this.items.size() < ITEM_LIMIT) {
            return super.checkoutItem(itemNumber);
        } else {
            return "User is child; limit of " + ITEM_LIMIT + " items reached!";
        }
    }
}
