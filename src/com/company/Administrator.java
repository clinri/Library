package com.company;

public interface Administrator {
    public boolean findBook(String titleBook);
    public void giveBook(User user, Book book);
    public void notification(User nameUser);

}
