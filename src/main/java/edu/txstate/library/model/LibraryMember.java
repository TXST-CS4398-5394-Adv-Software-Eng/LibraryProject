package edu.txstate.library.model;

public interface LibraryMember {
    boolean checkoutItem(String itemNumber);
    void returnItem(String itemNumber);
    void requestItem(Item i);
    boolean renewItem(Item i);
    void payFine(float balance);
    Item searchItem(String s);
    void queryAccount();
}
