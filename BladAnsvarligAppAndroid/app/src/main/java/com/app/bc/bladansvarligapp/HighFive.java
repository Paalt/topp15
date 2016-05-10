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
    boolean mFinished;

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
        mFinished = intent.getBooleanExtra("finished", true);

        if (mFinished) {
            mHighFiveText.setText("High five dere har fått\n\n+ 15 poeng\n\nFortsett med den gode jobben");
            mHighFiveButton.setText("Videre");
            mHighFiveButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    sendToSupplering();
                }
            });
            // TODO: mHighFiveImage.setImageResource(R.drawable.
        }
        else {
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
            // TODO: mHighFiveImage.setImageResource(R.drawable.
        }
    }

    private void sendToSupplering()
    {
        Intent intent = new Intent(this, Supplering.class);
        startActivity(intent);
    }

    private void sendToChecklist()
    {
        Intent intent = new Intent(this, Checklist.class);
        startActivity(intent);
    }
}
