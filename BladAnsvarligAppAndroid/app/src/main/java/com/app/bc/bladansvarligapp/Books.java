package com.app.bc.bladansvarligapp;

/**
 * Created by alkan on 26.04.2016.
 */
public class Books {

    String name = null;
    int amount = 0;

    public Books(String name) {
        super();
        this.name = name;
        this.amount = amount;
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
