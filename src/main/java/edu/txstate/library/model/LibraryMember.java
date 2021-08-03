package edu.txstate.library.model;

public interface LibraryMember {
    String checkoutItem(String itemNumber);
    void returnItem(String itemNumber);
    boolean requestItem(String itemNumber);
    boolean renewItem(String itemNumber);
    void payFine();
}
