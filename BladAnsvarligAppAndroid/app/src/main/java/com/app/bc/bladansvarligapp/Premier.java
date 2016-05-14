package com.app.bc.bladansvarligapp;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by alkan on 2016/05/14.
 */
public class Premier extends Activity{

    // .DATA
    final int DUMMYPOENG = 500;
    final int MAXPOENG = 300;

    // .DATA?
    String poengString;
    int poengProsent;

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

        poengString = "Poeng: " + DUMMYPOENG;
        poeng.setText(poengString);
        poengProsent = (DUMMYPOENG*100)/MAXPOENG;

        if (poengProsent > MAXPOENG)
            poengProsent = MAXPOENG;

        progressBar.setProgress(poengProsent);

        poengString = "Neste premie låses opp ved 100 poeng";
        if (DUMMYPOENG >= MAXPOENG/3)
        {
            norgeFlag.setImageResource(R.drawable.norge_flag);
            poengString = "Neste premie låses opp ved 200 poeng";
            if (DUMMYPOENG >= (MAXPOENG/3)*2)
            {
                sverigeFlag.setImageResource(R.drawable.sverige_flag);
                poengString = "Neste premie låses opp ved 300 poeng";
                if (DUMMYPOENG >= MAXPOENG)
                {
                    barcelonaFlag.setImageResource(R.drawable.barcelona_flag);
                    poengString = "Gratulerer, du er nå med i trekningen av alle premiene";
                }
            }
        }
        nestePremie.setText(poengString);
    }
}
