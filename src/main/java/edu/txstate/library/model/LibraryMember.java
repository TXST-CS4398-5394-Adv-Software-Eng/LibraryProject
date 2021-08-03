package edu.txstate.library.model;

public interface LibraryMember {
    String checkoutItem(String itemNumber);
    void returnItem(String itemNumber);
    void requestItem(Item i);
    boolean renewItem(Item i);
    void payFine();
}
