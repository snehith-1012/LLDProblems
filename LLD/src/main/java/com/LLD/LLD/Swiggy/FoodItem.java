package com.LLD.LLD.Swiggy;


public class FoodItem {
    private String name;

    private int price;

    private int count;

    private String description;

    private FoodItem(builder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.count = builder.count;
        this.description = builder.description;
    }

    public static class builder {
        private String name;
        private int price;
        private int count;
        private String description;

        public builder name(String name){
            this.name = name;
            return this;
        }

        public builder price(int price){
            this.price = price;
            return this;
        }

        public builder count(int count){
            this.count = count;
            return this;
        }

        public builder description(String description){
            this.description = description;
            return this;
        }

        public FoodItem build(){
            return new FoodItem(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
