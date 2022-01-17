package com.company;

import com.company.interfaces.*;

import java.util.ArrayList;

public class User implements Reader, Librarian, Supplier, Administrator {
    protected String name;

    // геттер
    public String getName() {
        return name;
    }

    // конструктор
    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "пользователь(я) " + name;
    }

    //==========================================================
    //реализация интерфейса Администратор
    @Override
    public Book findBook(Reader reader, String titleBook) {
        if (Book.listBook != null) {
            for (Book book : Book.listBook) {
                if (book.getTitleBook().equals(titleBook)) {
                    System.out.println(book + " найдена в библиотеке по запросу " + reader);
                    return book;
                } else {
                    System.out.println(titleBook + " не найдена в библиотеке по запросу " + reader);
                    return null;
                }
            }
        } else {
            return null;
        }
        return null;
    }

    @Override
    public void giveBook(Reader reader, Book book) {
        //выдаем книгу
        Book.listBook.remove(book);
        if (UsingBook.listBookUsing == null) {
            UsingBook.listBookUsing = new ArrayList();
        }
        UsingBook.listBookUsing.add(new UsingBook(reader, book, 30));
        System.out.println("Выдана " + book + " читателю [" + reader + "]");
    }

    @Override
    public void overdueNotification(Reader reader) {
        //проверка на задолженность
        for (UsingBook usingBook : UsingBook.listBookUsing) {
            if (reader.getName().equals(usingBook.getReader().getName())) {
                if (usingBook.getDaysLeft() == 0) {
                    System.out.println("Уведомление: читатель [" + reader.getName() +
                            "] должен вернуть " + usingBook.getBook());
                }
            }
        }
    }

    //==========================================================
    //реализация интерфейса Библиотекарь
    @Override
    public void orderBook(Supplier supplier, String titleBook) {
        //заказываем книгу
        OrderingBook.listOrderBook.add(new OrderingBook(supplier, titleBook));
        System.out.println("Заказана " + titleBook + " поставщику [" + supplier + "]");

    }

    //==========================================================
    //реализация интерфейса Читатель
    @Override
    public void getBook(Librarian librarian, String titleBook) {
        Book book = findBook(this, titleBook);
        if (book != null)
            giveBook(this, book);
        System.out.println("Взята " + book + " читателем [" + this + "] у библиотекаря [" + librarian + "]");
    }

    @Override
    public void returnBook(Librarian librarian, String titleBook) {
        if (UsingBook.listBookUsing != null) {
            for (UsingBook usingBook : UsingBook.listBookUsing) {
                if (usingBook.getBook().getTitleBook().equals(titleBook)) {
                    Book.listBook.add(usingBook.getBook());
                    System.out.println("Пользователь [" + usingBook.getReader() + "] вернул " + usingBook.getBook() +
                            " библиотекарю [" + librarian + "]");
                    UsingBook.listBookUsing.remove(usingBook);
                    return;
                }
            }
            System.out.println("Книга [" + titleBook + "] не выдавалась библиотекой");
        }
    }

    //==========================================================
    //реализация интерфейса Поставщик
    @Override
    public void deliverBook(Librarian librarian, String titleBook) {
        if (OrderingBook.listOrderBook != null) {
            for (OrderingBook orderingBook : OrderingBook.listOrderBook) {
                if (orderingBook.getTitleBook().equals(titleBook)) {
                    Book book = new Book(titleBook);
                    System.out.println("Поставщик [" + orderingBook.getSupplier() + "] осуществил поставку " + book +
                            " библиотекарю [" + librarian + "]");
                    Book.listBook.add(book);
                    UsingBook.listBookUsing.remove(orderingBook);
                    return;
                }
            }
            System.out.println("Книга " + titleBook + " не заказывалась библиотекой");
        }
    }
}
