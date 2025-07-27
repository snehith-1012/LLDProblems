package com.LLD.LLD.LibraryManagement;

import org.springframework.util.CollectionUtils;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Library {

    private UserService userService;
    private BookService bookService;
    private Random random = new Random();

    int currentOrderId = 500;

    private static Library library = null;

    private Library() {
        userService = new UserService();
        bookService = new BookService();
    }

    public static Library getInstance() {
        if (library == null) {
            return library = new Library();
        }
        return library;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public Order orderBook(String bookId, String userId) {
        Book book = bookService.getBook(bookId);
        User user = userService.getUser(userId);

        if (book.isAvailable()) {
            if (!user.isBookLimitReached()) {
                book.setAvailable(false);
                Order order = new Order.OrderBuilder().userId(userId).orderId("order id " + currentOrderId).bookId(bookId).startDate(LocalDateTime.now().toString()).build();
                user.addOrder(order);
                currentOrderId++;
                user.setBookLimitReached(true);
                return order;
            } else {
                System.out.println("Book limit reached for user" + user.getName());
            }
        } else {
            System.out.println("currentlyt book is not available, you will be notified when it becomes available");
            book.getUserIds().add(userId);
        }
        return null;
    }

    public void returnBook(String bookId, String userId, String orderId) {
        Book book = bookService.getBook(bookId);
        User user = userService.getUser(userId);
        user.setBookLimitReached(false);
        book.setAvailable(true);
        if (!CollectionUtils.isEmpty(book.getUserIds())) {
            userService.notifyUser(book.getUserIds().stream().toList(), book);
            book.setUserIds(new LinkedList<>());
        }

        Order order = user.getOrders().get(orderId);
        order.setEndDate(LocalDateTime.now().toString());
    }
}

