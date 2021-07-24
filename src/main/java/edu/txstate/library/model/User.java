package edu.txstate.library.model;

public abstract class User implements LibraryMember {
    @Override
    public boolean checkoutItem(Item i) {
        return false;
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
}
