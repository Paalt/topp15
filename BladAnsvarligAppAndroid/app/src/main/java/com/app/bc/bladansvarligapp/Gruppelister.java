package com.app.bc.bladansvarligapp;

/**
 * Created by alkan on 02.05.2016.
 */
public class Gruppelister {

    // .DATA
    String name = null;
    int members = 0;

    // .CODE
    public Gruppelister(String name, int members) {
        this.name = name;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers (int amount) {
        this.members = amount;
    }
}
