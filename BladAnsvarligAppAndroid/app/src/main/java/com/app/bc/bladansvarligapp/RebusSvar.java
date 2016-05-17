package com.app.bc.bladansvarligapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by alkan on 2016/05/10.
 */
public class RebusSvar extends Activity {

    // .DATA
    int dummySolgt = 547;
    int dummyMax = 2000;

    // .DATA?
    private Button mSvar;
    EditText mEditText;

    // .CODE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rebus_svar);

        GridView gridview = (GridView) findViewById(R.id.gridView);
        mSvar = (Button) findViewById(R.id.btnSvar);

        gridview.setAdapter(new ImageAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                //Toast.makeText(HelloGridView.this, "" + position,
                //Toast.LENGTH_SHORT).show();
            }
        });
        mSvar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (mEditText.getText().toString().equalsIgnoreCase("regnvate"))
                    sendToHighFive(HighFive.HIGH_FIVE_REBUS);
                else 
                    sendToHighFive(HighFive.NO_FIVE);
                //TODO Send til no five
            }
        });
    }

    private void sendToHighFive(int points)
    {
        Intent intent = new Intent(this, HighFive.class);
        intent.putExtra(HighFive.POINTS, points);
        startActivity(intent);
    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
            populateInteger();
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
            if (position == 0 || position == 3)
                imageView.setBackgroundColor(Color.parseColor("#446CB3"));
            else
                imageView.setBackgroundColor(Color.parseColor("#DB455E"));
            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

        // references to our images
        private Integer[] mThumbIds = {
            R.drawable.rebus_en, R.drawable.rebus_to,
            R.drawable.rebus_tre, R.drawable.rebus_fire
        };
        private void populateInteger (){
        if (dummyMax / 4 > dummySolgt)
            mThumbIds[0] = R.drawable.las;
        if (dummyMax / 2 > dummySolgt)
            mThumbIds[1] = R.drawable.las;
        if ((dummyMax * 3) / 4 > dummySolgt)
            mThumbIds[2] = R.drawable.las;
        if (dummyMax > dummySolgt)
            mThumbIds[3] = R.drawable.las;
        }
    }
}