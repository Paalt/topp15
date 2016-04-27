package com.app.bc.bladansvarligapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by alkan on 23.04.2016.
 */
public class HighFive extends Activity {

    // .DATA
    boolean dummy = false;

    // .DATA?
    TextView mHighFiveText;
    ImageView mHighFiveImage;
    Button mHighFiveButton;

    // .CODE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_five);

        mHighFiveText = (TextView) findViewById(R.id.high_five);
        mHighFiveButton = (Button) findViewById(R.id.high_five_button);
        mHighFiveImage = (ImageView) findViewById(R.id.high_five_image);

        if (dummy) {
            mHighFiveText.setText("High five dere har fått\n\n+ 15 poeng\n\nFortsett med den gode jobben");
            mHighFiveButton.setText("Videre");
            // TODO: mHighFiveImage.setImageResource(R.drawable.
        }
        else {
            mHighFiveText.setText("Har du tenkt å gå videre?\n\nDu har ikke fullført listen\n\nVennligst gå tilbake");
            mHighFiveButton.setText("Tilbake");
            // TODO: mHighFiveImage.setImageResource(R.drawable.
        }
    }
}
