package com.LLD.LLD.LibraryManagement;

import java.util.Queue;

public class Book {

    private String bookId;
    private String bookName;
    private String author;
    private int price;
    private boolean isAvailable;
    private Queue<String> userIds;

    public Book(String bookId, String bookName, String author, int price, boolean isAvailable, Queue<String> userIds) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
        this.userIds = userIds;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Queue<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(Queue<String> userIds) {
        this.userIds = userIds;
    }
}
