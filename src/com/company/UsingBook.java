package com.company;

import com.company.interfaces.Reader;

import java.util.ArrayList;

public class UsingBook {
    public static ArrayList<UsingBook> listBookUsing;
    protected Reader reader;
    protected int daysLeft;
    protected Book book;

    public UsingBook(Reader reader, Book book, int daysLeft) {
        this.reader = reader;
        this.daysLeft = daysLeft;
        this.book = book;
        if (listBookUsing == null){
            listBookUsing = new ArrayList();
        }
    }

    // геттеры
    public int getDaysLeft() {
        return daysLeft;
    }
    public Book getBook() {
        return book;
    }
    public Reader getReader() {
        return reader;
    }
}
