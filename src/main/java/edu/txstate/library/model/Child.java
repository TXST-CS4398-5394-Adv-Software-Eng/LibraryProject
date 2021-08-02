package edu.txstate.library.model;

public class Child extends  User {
    private static final int ITEM_LIMIT = 5;

    public Child(String name, String address, String phoneNum) {
        super(name, address, phoneNum);
    }

    @Override
    public boolean checkoutItem(String itemNumber) {
        if (this.items.size() < ITEM_LIMIT) {
            return super.checkoutItem(itemNumber);
        }

        return false;
    }
}
