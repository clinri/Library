package com.company;

import com.company.interfaces.Supplier;

import java.util.ArrayList;

public class OrderingBook {
    public static ArrayList<OrderingBook> listOrderBook;
    protected Supplier supplier;
    protected String titleBook;

    public OrderingBook(Supplier supplier, String titleBook) {
        this.supplier = supplier;
        this.titleBook = titleBook;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public String getTitleBook() {
        return titleBook;
    }
}
