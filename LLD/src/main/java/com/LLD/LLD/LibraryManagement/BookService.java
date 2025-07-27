package com.LLD.LLD.LibraryManagement;

import java.util.HashMap;
import java.util.Map;

public class BookService {

    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getBookId(), book);
    }

    public Book getBook(String bookId) {
        return books.get(bookId);
    }

    public void updateBookAvailabilityStatus(boolean isAvailable, String bookId) {
        Book book = books.get(bookId);
        book.setAvailable(isAvailable);
    }

    public void updateUserQueue(String bookId, String userId) {
        Book book = books.get(bookId);
        book.getUserIds().add(userId);
    }
}
