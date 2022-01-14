package com.company;

import java.lang.ref.SoftReference;

public class UsingBook {
    protected int daysLeft;
    protected Book book;

    public UsingBook(int daysLeft, Book book) {
        this.daysLeft = daysLeft;
        this.book = book;
    }

    // геттеры
    public int getDaysLeft() {
        return daysLeft;
    }
    public Book getBook() {
        return book;
    }
}
