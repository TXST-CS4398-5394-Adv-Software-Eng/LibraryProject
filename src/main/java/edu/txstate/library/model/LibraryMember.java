package edu.txstate.library.model;

public interface LibraryMember {
    boolean checkoutItem(Item i);
    void returnItem(Item i);
    void requestItem(Item i);
    boolean renewItem(Item i);
    void payFine(float balance);
    Item searchItem(String s);
    void queryAccount();
}
