package com.app.bc.bladansvarligapp;

/**
 * Created by alkan on 23.04.2016.
 */
public class MakeItShine {

    String name = null;
    boolean selected = false;

    public MakeItShine(String name, boolean selected) {
        super();
        this.name = name;
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
