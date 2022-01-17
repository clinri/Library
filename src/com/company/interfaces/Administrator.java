package com.company.interfaces;

import com.company.Book;

public interface Administrator {
    public Book findBook(Reader reader, String titleBook);
    public void giveBook(Reader reader, Book book);
    public void overdueNotification(Reader reader);
}
