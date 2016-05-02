package com.app.bc.bladansvarligapp;

/**
 * Created by alkan on 26.04.2016.
 */
public class Books {

    // .DATA
    String name = null;
    int amount = 0;

    // .CODE
    public Books(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount (int amount) {
        this.amount = amount;
    }
}
