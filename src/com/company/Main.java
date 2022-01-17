package com.company;

import com.company.interfaces.Librarian;
import com.company.interfaces.Reader;


public class Main {

    public static void main(String[] args) {
        Book book1 = new Book("Сказки Пушкина");
        Reader reader = new User("Вася");
        Librarian librarian = new User("Вениамин");
        System.out.println("зарегистрирована " + book1);
        System.out.println("зарегистрирован " + reader);
        reader.getBook(librarian, "Сказки Пушкина");
        reader.returnBook(librarian, "Сказки Пушкина");
    }
}
