package com.app.bc.bladansvarligapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by alkan on 20.04.2016.
 */
public class Checklist extends Activity{

    // .DATA
    MyCustomAdapter dataAdapter = null;

    // .DATA?
    private ListView mChecklist;
    private Button mFerdigButton;

    // .CODE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);

        //Generate list View from ArrayList
        displayListView();

        //checkButtonClick();
        mFerdigButton = (Button) findViewById(R.id.ferdig);
        mFerdigButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // TODO check if tasks are done and handle if not
                // if tasks done, high five, else no five;
                sendToHighFive(HighFive.HIGH_FIVE_CHECKLIST);
            }
        });

    }

    private void displayListView() {

        //Array list of countries
        ArrayList<MakeItShine> shineList = new ArrayList<MakeItShine>();
        MakeItShine makeItShine = new MakeItShine("Rydde hyllen",false);
        shineList.add(makeItShine);
        makeItShine = new MakeItShine("Legge opp nye bøker",false);
        shineList.add(makeItShine);
        makeItShine = new MakeItShine("Organiser bøkene i topp 15",false);
        shineList.add(makeItShine);
        makeItShine = new MakeItShine("Sende tilbake utgåtte bøker",false);
        shineList.add(makeItShine);
        makeItShine = new MakeItShine("Rydde i bladene",false);
        shineList.add(makeItShine);

        //create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(this, R.layout.activity_checklist, shineList);
        ListView listView = (ListView) findViewById(R.id.checklist);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                MakeItShine makeItShine = (MakeItShine) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                               "Clicked on Row: " + makeItShine.getName(),
                               Toast.LENGTH_LONG).show();
            }
        });
    }

    private class MyCustomAdapter extends ArrayAdapter<MakeItShine> {

        private ArrayList<MakeItShine> shineArrayList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<MakeItShine> shineList) {
            super(context, textViewResourceId, shineList);
            this.shineArrayList = new ArrayList<MakeItShine>();
            this.shineArrayList.addAll(shineList);
        }

        private class ViewHolder {
            TextView code;
            CheckBox name;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.checklist_layout, null);

                holder = new ViewHolder();
                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);

                holder.name.setOnClickListener( new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v ;
                        MakeItShine makeItShine = (MakeItShine) cb.getTag();
                        if (cb.isChecked()) {
                            Toast.makeText(getApplicationContext(),
                                           cb.getText() +
                                                   " er ferdig",
                                           Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),
                                           cb.getText() +
                                                   " er ikke ferdig",
                                           Toast.LENGTH_LONG).show();
                        }
                        makeItShine.setSelected(cb.isChecked());
                    }
                });
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            MakeItShine makeItShine = shineArrayList.get(position);
            holder.name.setText(makeItShine.getName());
            holder.name.setChecked(makeItShine.isSelected());
            holder.name.setTag(makeItShine);

            return convertView;
        }
    }

    private void sendToHighFive(int points)
    {
        Intent intent = new Intent(this, HighFive.class);
        intent.putExtra(HighFive.POINTS, points);
        startActivity(intent);
    }

// private void checkButtonClick() {
//
//
//  Button myButton = (Button) findViewById(R.id.findSelected);
//  myButton.setOnClickListener(new OnClickListener() {
//
//   @Override
//   public void onClick(View v) {
//
//    StringBuffer responseText = new StringBuffer();
//    responseText.append("The following were selected...\n");
//
//    ArrayList<Country> countryList = dataAdapter.countryList;
//    for(int i=0;i<countryList.size();i++){
//     Country country = countryList.get(i);
//     if(country.isSelected()){
//      responseText.append("\n" + country.getName());
//     }
//    }
//
//    Toast.makeText(getApplicationContext(),
//      responseText, Toast.LENGTH_LONG).show();
//
//   }
//  });
//
// }

}
