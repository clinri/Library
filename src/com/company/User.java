package com.company;

import java.util.ArrayList;

public class User implements Reader, Librarian, Supplier, Administrator {
    protected String name;
    protected ArrayList<UsingBook> listBookUsing;

    // геттеры
    public String getName() {
        return name;
    }

    public ArrayList<UsingBook> getListBookUsing() {
        return listBookUsing;
    }

    // конструктор
    public User(String name) {
        this.name = name;
        this.listBookUsing = new ArrayList();
    }

    //==========================================================
    //интерфейс Администратор
    @Override
    public boolean findBook(String titleBook) {
        if (Book.listBook != null) {
            for (Book book : Book.listBook) {
                if (book.getTitleBook().equals(titleBook)) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return false;
    }

    @Override
    public void giveBook(User nameUser, Book book) {
        //выдаем книгу
        nameUser.listBookUsing.add(new UsingBook(30, book));
    }

    @Override
    public void notification(User nameUser) {
        //проверка на задолженность
        for (UsingBook usingBook : nameUser.getListBookUsing()) {
            if (usingBook.getDaysLeft() == 0) {
                System.out.println("Читатель " + nameUser.getName() + " должен вернуть книгу " + usingBook.book.getTitleBook());
            }
        }

    }

    //==========================================================
    //интерфейс Библиотекарь
    @Override
    public void orderBook(String titleBook) {

    }

    //==========================================================
    //интерфейс Читатель
    @Override
    public void getBook(String titleBook) {

    }

    @Override
    public void returnBook(String titleBook) {

    }

    //==========================================================
    //интерфейс Поставщик
    @Override
    public void deliverBook(String titleBook) {

    }
}
