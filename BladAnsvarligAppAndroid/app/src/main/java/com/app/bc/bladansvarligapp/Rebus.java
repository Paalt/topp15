package com.app.bc.bladansvarligapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by alkan on 2016/05/10.
 */
public class Rebus extends Activity {

    // .DATA
    private int mProgressStatus = 547;
    private Handler mHandler = new Handler();
    private final int MAXBOKER = 2000;

    // .DATA?
    ProgressBar mProgress;
    TextView mProgressText;
    private int mProgressPercent;
    TextView mBokerSolgt;
    private float temp;
    private Button mSvar;
    private Button mRanking;

    // .CODE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rebus);

        GridView gridview = (GridView) findViewById(R.id.gridView);
        mProgress = (ProgressBar) findViewById(R.id.progressBar);
        mProgressText = (TextView) findViewById(R.id.progressPercentege);
        mBokerSolgt = (TextView) findViewById(R.id.boker);
        mSvar = (Button) findViewById(R.id.btnToSvar);
        mRanking = (Button) findViewById(R.id.btnToRanking);

        temp = ((mProgressStatus*100) / MAXBOKER);
        mProgressPercent = (int)temp;

        mProgressText.setText("Solgt " + mProgressPercent + "% oppnåelse");
        mProgress.setProgress(mProgressPercent);
        mBokerSolgt.setText(mProgressStatus + " av " + MAXBOKER + " Boker solgt");

        gridview.setAdapter(new ImageAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        }
        });
        mSvar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sendToRebusSvar();
            }
        });
        mRanking.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sendToRanking();
            }
        });
    }
    
    private void sendToRebusSvar()
    {
        Intent intent = new Intent(this, RebusSvar.class);
        startActivity(intent);
    }
    
    private void sendToRanking()
    {
        Intent intent = new Intent(this, Ranking.class);
        startActivity(intent);
    }
    
    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(400, 400));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(0, 0, 0, 0);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

        // references to our images
        private Integer[] mThumbIds = {
            R.drawable.blue_cirlce, R.drawable.red_circle,
            R.drawable.high_five, R.drawable.no_five
        };
    }
}
