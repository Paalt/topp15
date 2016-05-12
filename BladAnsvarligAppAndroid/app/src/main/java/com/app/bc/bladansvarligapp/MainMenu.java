package com.app.bc.bladansvarligapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by alkan on 18.04.2016.
 */
public class MainMenu extends Activity {

    // .DATA?
    private TextView mWelcome;
    private TextView mBokerSolgt;
    private TextView mPoeng;
    private TextView mMakeItShine;
    private TextView mTheGame;

    // .CODE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Intent intent = getIntent();
        final String godJobb ="God jobb, ";
        String butikk = intent.getStringExtra("butikk");
        String welcome = godJobb + butikk;


        mWelcome = (TextView) findViewById(R.id.welcome);
        mBokerSolgt = (TextView) findViewById(R.id.bokerSolgt);
        mPoeng = (TextView) findViewById(R.id.poeng);
        mMakeItShine = (TextView) findViewById(R.id.makeItShine);
        mTheGame = (TextView) findViewById(R.id.theGame);

        mWelcome.setText(welcome);
        mBokerSolgt.setText("16");
        mPoeng.setText("1");
        mMakeItShine.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sendToChecklist();
            }
        });
        mTheGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sendToRebus();
            }
        });
    }

    private void sendToChecklist()
    {
        Intent intent = new Intent(this, Checklist.class);
        startActivity(intent);
    }

    private void sendToRebus()
    {
        Intent intent = new Intent(this, Rebus.class);
        startActivity(intent);
    }
}
