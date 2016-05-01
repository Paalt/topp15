package com.app.bc.bladansvarligapp;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by alkan on 23.04.2016.
 */
public class MakeItShine extends Activity
{

    // .DATA
    String name = null;
    boolean selected = false;

    // .CODE
    public MakeItShine(String name, boolean selected) {
        super();
        this.name = name;
        this.selected = selected;
    }

    private void sendToChecklist()
    {
        Intent intent = new Intent(this, Checklist.class);
        startActivity(intent);
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
