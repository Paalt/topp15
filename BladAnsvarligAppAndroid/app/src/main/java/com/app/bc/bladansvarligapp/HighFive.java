package com.app.bc.bladansvarligapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by alkan on 23.04.2016.
 */
public class HighFive extends Activity {

    // .DATA
    public final static int NO_FIVE = 0;
    public final static int HIGH_FIVE_CHECKLIST = 2;
    public final static int HIGH_FIVE_SUPPLERING = 3;
    public final static int HIGH_FIVE_REBUS = 5;
    public final static String POINTS = "points";
    private int mFinished;

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

        Intent intent = getIntent();
        mFinished = intent.getIntExtra(POINTS, NO_FIVE);

        if (mFinished > NO_FIVE) {
            mHighFiveImage.setImageResource(R.drawable.high_five);
            mHighFiveText.setText("High five dere har fått\n\n+ " + mFinished + " poeng\n\nFortsett med den gode jobben");
            if (mFinished == HIGH_FIVE_CHECKLIST) {
                mHighFiveButton.setText("Videre");
                mHighFiveButton.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        sendToFerdig();
                    }
                });
            }
            else {
                mHighFiveButton.setText("Hovedmeny");
                mHighFiveButton.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        sendToMainMenu();
                    }
                });
            }
        }
        else {
            mHighFiveImage.setImageResource(R.drawable.no_five);
            mHighFiveText.setText("Har du tenkt å gå videre?\n\nDu har ikke fullført listen\n\nVennligst gå tilbake");
            mHighFiveButton.setText("Tilbake");
            mHighFiveButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    sendToChecklist();
                }
            });
        }
    }

    private void sendToMainMenu()
    {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }

    private void sendToFerdig()
    {
        Intent intent = new Intent(this, Ferdig.class);
        startActivity(intent);
    }

    private void sendToChecklist()
    {
        Intent intent = new Intent(this, Checklist.class);
        startActivity(intent);
    }
}
