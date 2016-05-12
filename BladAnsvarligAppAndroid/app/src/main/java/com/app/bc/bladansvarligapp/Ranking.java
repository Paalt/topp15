package com.app.bc.bladansvarligapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
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

    // .CODE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        data[0][0] = R.drawable.blue_cirlce;
        data[1][0] = R.drawable.red_circle;
        data[2][0] = R.drawable.high_five;
        data[3][0] = R.drawable.no_five;
        data[4][0] = R.drawable.mb2;

        for (int i = 0; i < 5; i++)
        {
            data[i][1] = (int)(Math.random() * (100 - 0) + 0);
        }

        // Sorts array high to low
        java.util.Arrays.sort(data, new java.util.Comparator<Integer[]>() {
            public int compare(Integer[] a, Integer[] b) {
                return b[1] - a[1];
            }
        });

        imageView = (ImageView) findViewById(R.id.rankingimg1);
        progressBar = (ProgressBar) findViewById(R.id.rankingprog1);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        imageView.setImageResource(data[0][0]);
        progressBar.setProgress(data[0][1]);

        imageView = (ImageView) findViewById(R.id.rankingimg2);
        progressBar = (ProgressBar) findViewById(R.id.rankingprog2);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        imageView.setImageResource(data[1][0]);
        progressBar.setProgress(data[1][1]);

        imageView = (ImageView) findViewById(R.id.rankingimg3);
        progressBar = (ProgressBar) findViewById(R.id.rankingprog3);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        imageView.setImageResource(data[2][0]);
        progressBar.setProgress(data[2][1]);

        imageView = (ImageView) findViewById(R.id.rankingimg4);
        progressBar = (ProgressBar) findViewById(R.id.rankingprog4);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        imageView.setImageResource(data[3][0]);
        progressBar.setProgress(data[3][1]);

        imageView = (ImageView) findViewById(R.id.rankingimg5);
        progressBar = (ProgressBar) findViewById(R.id.rankingprog5);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        imageView.setImageResource(data[4][0]);
        progressBar.setProgress(data[4][1]);
    }
}
