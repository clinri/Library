package com.company;

import java.util.ArrayList;

public class Book {
    // допущение в библиотеке по одному экземпляру каждой книги
    public static ArrayList<Book> listBook;

    protected String titleBook;

    public Book(String titleBook) {
        this.titleBook = titleBook;
        if (listBook == null){
            listBook = new ArrayList();
        }
        listBook.add(this);
    }

    public String getTitleBook() {
        return titleBook;
    }

    @Override
    public String toString() {
        return "книга(у) [" + titleBook + ']';
    }
}
