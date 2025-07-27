package com.LLD.LLD.LibraryManagement;

public class Notification {


    private String bookId;

    private String message;

    public Notification(String bookId, String message) {
        this.bookId = bookId;
        this.message = message;
    }

    public String getBookId() {
        return bookId;
    }

    public String getMessage() {
        return message;
    }


    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
