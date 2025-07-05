package com.LLD.LLD.Swiggy.dto;

import com.LLD.LLD.Swiggy.FoodItem;

public class FoodItemRequestObj {

    private String name;

    private int price;

    private int count;

    private String description;


    public FoodItemRequestObj(builder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.count = builder.count;
        this.description = builder.description;
    }

    public static class builder{
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
        public FoodItemRequestObj build(){
            return new FoodItemRequestObj(this);
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public String getDescription() {
        return description;
    }
}
