package com.LLD.LLD.VendingMachine;


import com.LLD.LLD.VendingMachine.changeReturner.Returner1;
import com.LLD.LLD.VendingMachine.changeReturner.Returner10;
import com.LLD.LLD.VendingMachine.changeReturner.Returner20;
import com.LLD.LLD.VendingMachine.changeReturner.Returner5;
import com.LLD.LLD.VendingMachine.vendingMachineState.IdleState;

import java.util.*;

public class VendingMachine {

    private double money;
    private List<Note> notes;

    private VendingMachineState vendingMachineState;

    private List<Shelf> shelves = new ArrayList<>();

    private static VendingMachine vendingMachineInstance = null;

    private int userMoney = 0;

    private ChangeReturner returner1;

    private ChangeReturner returner5;
    private ChangeReturner returner10;
    private ChangeReturner returner20;

    public static VendingMachine getInstance() {
        if (vendingMachineInstance == null) {
            vendingMachineInstance = new VendingMachine();
        }
        return vendingMachineInstance;
    }

    private VendingMachine() {
        this.vendingMachineState = new IdleState();
        fillProducts();
        notes = new ArrayList<>();
        addNotes();

        returner1 = new Returner1(null);
        returner5 = new Returner5(returner1);
        returner10 = new Returner10(returner5);
        returner20 = new Returner20(returner10);



    }

    private void addNotes() {
        for (int i = 0; i < 5; i++) {
            notes.add(Note.ONE);
        }
        for (int i = 0; i < 3; i++) {
            notes.add(Note.FIVE);
        }
        for (int i = 0; i < 2; i++) {
            notes.add(Note.TEN);
        }
        for (int i = 0; i < 2; i++) {
            notes.add(Note.TWENTY);
        }
        this.money = 80;
    }


    private void fillProducts() {
        shelves.add(new Shelf(101, 10, new Product("coke", ProductTypeEnum.COLD, 13)));
        shelves.add(new Shelf(102, 10, new Product("cassata", ProductTypeEnum.ICECREAM, 2)));
        shelves.add(new Shelf(103, 10, new Product("bhujia", ProductTypeEnum.HOT, 9)));
        shelves.add(new Shelf(104, 10, new Product("moongdal", ProductTypeEnum.HOT, 22)));
        shelves.add(new Shelf(105, 10, new Product("basundi", ProductTypeEnum.SWEET, 1)));
        shelves.add(new Shelf(106, 10, new Product("mazza", ProductTypeEnum.COLD, 4)));
    }

    public void updateStock(int shelfId, Product product, int quantity) throws Exception {
        Shelf shelf = shelves.stream().filter(shelf1 -> shelf1.getShelfId() == shelfId).toList().get(0);
        if (shelf.getProduct() == product) {
            if (10 - shelf.getQuantity() > quantity) {
                throw new Exception("limit reached");
            } else {
                shelf.updateQuantity(quantity);
            }
        }
    }

    public void insertMoney(List<Note> notes) throws Exception {
        this.vendingMachineState.insertNote(notes, this);
    }

    public void selectProduct(int id, int quantity) throws Exception {
        this.vendingMachineState.selectProduct(id, quantity, this);
        this.vendingMachineState.dispenseProduct(this, id, quantity);
    }

    public void updateUserMoney(int userMoney) {
        this.userMoney = userMoney;
    }

    public void updateNotes(List<Note> notes) {
        this.notes.addAll(notes);
    }

    public void returnChangeToUser(int money) {
        // remove coins from machine
        returner20.returnChange(this,money);
        this.setUserMoney(0);
        System.out.println("refund succeeded" + money);
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        if (Objects.equals(vendingMachineState, new IdleState())) {
            this.userMoney = 0;
        }
        this.vendingMachineState = vendingMachineState;
    }

    public List<Shelf> getShelves() {
        return shelves;
    }

    public void setShelves(List<Shelf> shelves) {
        this.shelves = shelves;
    }

    public static VendingMachine getVendingMachineInstance() {
        return vendingMachineInstance;
    }

    public static void setVendingMachineInstance(VendingMachine vendingMachineInstance) {
        VendingMachine.vendingMachineInstance = vendingMachineInstance;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(int userMoney) {
        this.userMoney = userMoney;
    }
}
