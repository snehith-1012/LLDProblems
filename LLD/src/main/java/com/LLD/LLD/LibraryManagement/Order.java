package com.LLD.LLD.LibraryManagement;

public class Order {

    private String orderId;
    private String bookId;
    private String userId;
    private String startDate;
    private String endDate;
    private Integer fine;
    private Integer charge;
    private Integer duration;

    public static class OrderBuilder {
        private String orderId;
        private String bookId;
        private String userId;
        private String startDate;
        private String endDate;
        private Integer fine;
        private Integer charge;
        private Integer duration;

        public OrderBuilder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public OrderBuilder bookId(String bookId) {
            this.bookId = bookId;
            return this;
        }


        public OrderBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }


        public OrderBuilder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }


        public OrderBuilder endDate(String endDate) {
            this.endDate = endDate;
            return this;
        }


        public OrderBuilder fine(Integer fine) {
            this.fine = fine;
            return this;
        }


        public OrderBuilder charge(Integer charge) {
            this.charge = charge;
            return this;
        }


        public OrderBuilder duration(Integer duration) {
            this.duration = duration;
            return this;
        }

        public Order build() {
            return new Order(this);
        }

    }

    public Order(OrderBuilder builder) {
        this.orderId = builder.orderId;
        this.bookId = builder.bookId;
        this.userId = builder.userId;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.fine = builder.fine;
        this.charge = builder.charge;
        this.duration = builder.duration;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
