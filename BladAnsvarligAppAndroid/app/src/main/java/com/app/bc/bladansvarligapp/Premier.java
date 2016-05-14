package com.app.bc.bladansvarligapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by alkan on 2016/05/14.
 */
public class Premier extends Activity{

    // .DATA
    final int DUMMYBOKER = 1500;
    final int MAXBOKER = 3000;

    // .DATA?
    String bokerStrig;
    int bokerProsent;

    ImageView barcelonaFlag;
    ImageView sverigeFlag;
    ImageView norgeFlag;
    ProgressBar progressBar;
    TextView poeng;
    TextView nestePremie;

     // .CODE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premier);

        barcelonaFlag = (ImageView) findViewById(R.id.barcelona_flag);
        sverigeFlag = (ImageView) findViewById(R.id.sverige_flag);
        norgeFlag = (ImageView) findViewById(R.id.norge_flag);
        progressBar = (ProgressBar) findViewById(R.id.poengProgress);
        poeng = (TextView) findViewById(R.id.poeng);
        nestePremie = (TextView) findViewById(R.id.neste_premie);

        bokerStrig = "Bøker solgt: " + DUMMYBOKER;
        poeng.setText(bokerStrig);
        bokerProsent = (DUMMYBOKER *100)/ MAXBOKER;

        if (bokerProsent > MAXBOKER)
            bokerProsent = MAXBOKER;

        progressBar.setProgress(bokerProsent);

        bokerStrig = "Neste premie låses opp ved 1000 bøker solgt";
        if (DUMMYBOKER >= MAXBOKER /3)
        {
            norgeFlag.setImageResource(R.drawable.norge_flag);
            bokerStrig = "Neste premie låses opp ved 2000 bøker solgt";
            if (DUMMYBOKER >= (MAXBOKER /3)*2)
            {
                sverigeFlag.setImageResource(R.drawable.sverige_flag);
                bokerStrig = "Neste premie låses opp ved 3000 bøker solgt";
                if (DUMMYBOKER >= MAXBOKER)
                {
                    barcelonaFlag.setImageResource(R.drawable.barcelona_flag);
                    bokerStrig = "Gratulerer, du er nå med i trekningen av alle premiene";
                }
            }
        }
        nestePremie.setText(bokerStrig);
    }
}
