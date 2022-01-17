package com.company.interfaces;

public interface Reader {
    void getBook(Librarian librarian, String titleBook);
    void returnBook(Librarian librarian, String titleBook);
    String getName();

}
