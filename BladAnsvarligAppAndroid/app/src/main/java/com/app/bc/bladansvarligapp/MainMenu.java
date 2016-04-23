package com.app.bc.bladansvarligapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by alkan on 18.04.2016.
 */
public class MainMenu extends Activity {

    // .DATA?
    private TextView mWelcome;
    private TextView mBokerSolgt;
    private TextView mPoeng;

    // .CODE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mWelcome = (TextView) findViewById(R.id.welcome);
        mBokerSolgt = (TextView) findViewById(R.id.bokerSolgt);
        mPoeng = (TextView) findViewById(R.id.poeng);
        mWelcome.setText("God jobb, Meny Coloseum!");
        mBokerSolgt.setText("16");
        mPoeng.setText("1");

    }
}
