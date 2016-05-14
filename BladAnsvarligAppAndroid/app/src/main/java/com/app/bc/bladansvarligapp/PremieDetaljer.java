package com.app.bc.bladansvarligapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by alkan on 2016/05/14.
 */
public class PremieDetaljer extends Activity {

        // .DATA?
        TextView premieBy;
        ImageView premieFlag;
        ImageView premieBildet;
        TextView premieText;
        TextView premieKrav;

        // .CODE
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_premie_detaljer);

            premieBy = (TextView) findViewById(R.id.premieby);
            premieFlag = (ImageView) findViewById(R.id.premieflag);
            premieBildet = (ImageView) findViewById(R.id.premiebildet);
            premieText = (TextView) findViewById(R.id.premiestring);
            premieKrav = (TextView) findViewById(R.id.premiekrav);

            if (false)
            {
                premieBy.setText(R.string.barcelona);
                premieFlag.setImageResource(R.drawable.barcelona_flag);
                premieBildet.setImageResource(R.drawable.barcelona);
                premieText.setText(R.string.forste_premie);
                premieKrav.setText(R.string.krav1);
            } else if (false) {
                premieBy.setText(R.string.stockholm);
                premieFlag.setImageResource(R.drawable.sverige_flag);
                premieBildet.setImageResource(R.drawable.stockholm);
                premieText.setText(R.string.andre_premie);
                premieKrav.setText(R.string.krav2);
            } else {
                premieBy.setText(R.string.lillestrom);
                premieFlag.setImageResource(R.drawable.norge_flag);
                premieBildet.setImageResource(R.drawable.lilestrom);
                premieText.setText(R.string.tredje_premie);
                premieKrav.setText(R.string.krav3);
            }
        }
}
