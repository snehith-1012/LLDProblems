package com.LLD.LLD.LibraryManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class LibraryDemo {

    public static void main(String[] args) {
        Library library = Library.getInstance();


        User user1 = new User("101", "snehith", "snehith@gmail.com", new LinkedList<>(), new HashMap<>());
        User user2 = new User("102", "avinash", "avinash@gmail.com", new LinkedList<>(), new HashMap<>());
        User user3 = new User("103", "jayanth", "jayanth@gmail.com", new LinkedList<>(), new HashMap<>());

        library.getUserService().addUser(user1);
        library.getUserService().addUser(user2);
        library.getUserService().addUser(user3);

        Book book1 = new Book("201", "pirates", "james", 2, true, new LinkedList<>());
        Book book2 = new Book("202", "of", "sne", 2, true, new LinkedList<>());
        Book book3 = new Book("203", "carribean", "odd", 2, true, new LinkedList<>());

        library.getBookService().addBook(book1);
        library.getBookService().addBook(book2);
        library.getBookService().addBook(book3);


        Order order1 = library.orderBook("201", "101");
        Order orderLimitReached = library.orderBook("202", "101"); // should get limit reached

        Order orderAlreadyTaken = library.orderBook("201", "103"); // cannot book, book is already taken and will be notified to user

        library.returnBook("201", "101", order1.getOrderId());

        Order order2 = library.orderBook("201", "102");
        library.returnBook("201", "102", order2.getOrderId());
    }
}
