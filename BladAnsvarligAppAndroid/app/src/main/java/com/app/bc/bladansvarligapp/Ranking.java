package com.app.bc.bladansvarligapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by alkan on 2016/05/11.
 */
public class Ranking extends Activity{

    // .DATA?
    ImageView imageView;
    ProgressBar progressBar;
    Integer data[][] = new Integer[5][2];
    private Button mPremier;
    private Button mRebus;
    
    
    // .CODE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        data[0][0] = R.drawable.meny;
        data[1][0] = R.drawable.kiwi;
        data[2][0] = R.drawable.narvesen;
        data[3][0] = R.drawable.rema_1000;
        data[4][0] = R.drawable.coop;
        mPremier = (Button) findViewById(R.id.btnToPremier);
        mRebus = (Button) findViewById(R.id.btnToRebus);

        for (int i = 0; i < 5; i++)
        {
            data[i][1] = ((i * 2) * 10);
        }
    
        mPremier.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sendToPremier();
            }
        });
        mRebus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {sendToRebus();
            }
        });
        
        // Sorts array high to low
        java.util.Arrays.sort(data, new java.util.Comparator<Integer[]>() {
            public int compare(Integer[] a, Integer[] b) {
                return b[1] - a[1];
            }
        });

        imageView = (ImageView) findViewById(R.id.rankingimg1);
        progressBar = (ProgressBar) findViewById(R.id.rankingprog1);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        imageView.setImageResource(R.drawable.meny);
        progressBar.setProgress(data[0][1]);

        imageView = (ImageView) findViewById(R.id.rankingimg2);
        progressBar = (ProgressBar) findViewById(R.id.rankingprog2);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        imageView.setImageResource(R.drawable.kiwi);
        progressBar.setProgress(data[1][1]);

        imageView = (ImageView) findViewById(R.id.rankingimg3);
        progressBar = (ProgressBar) findViewById(R.id.rankingprog3);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        imageView.setImageResource(R.drawable.narvesen);
        progressBar.setProgress(data[2][1]);

        imageView = (ImageView) findViewById(R.id.rankingimg4);
        progressBar = (ProgressBar) findViewById(R.id.rankingprog4);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        imageView.setImageResource(R.drawable.rema_1000);
        progressBar.setProgress(data[3][1]);

        imageView = (ImageView) findViewById(R.id.rankingimg5);
        progressBar = (ProgressBar) findViewById(R.id.rankingprog5);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        imageView.setImageResource(data[4][0]);
        progressBar.setProgress(data[4][1]);
    }
    
    private void sendToPremier()
    {
        Intent intent = new Intent(this, Premier.class);
        startActivity(intent);
    }
    
    private void sendToRebus()
    {
        Intent intent = new Intent(this, Rebus.class);
        startActivity(intent);
    }
}
