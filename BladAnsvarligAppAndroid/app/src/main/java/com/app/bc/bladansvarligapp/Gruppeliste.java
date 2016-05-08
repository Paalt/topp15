package com.app.bc.bladansvarligapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by alkan on 02.05.2016.
 */
public class Gruppeliste extends Activity {

    // .DATA
    MyCustomAdapter dataAdapter = null;

    // .DATA?
    private ListView mGruppeliste;

    // .CODE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gruppeliste);

        //Generate list View from ArrayList
        displayListView();

        //checkButtonClick();

    }

    private void displayListView() {

        //Array list of countries
        ArrayList<Gruppe> gruppeliste = new ArrayList<Gruppe>();
        Gruppe gruppe = new Gruppe("Rydde hyllen", 15);
        gruppeliste.add(gruppe);
        gruppe = new Gruppe("Legge opp nye bøker", 24);
        gruppeliste.add(gruppe);
        gruppe = new Gruppe("Organiser bøkene i topp 15", 50);
        gruppeliste.add(gruppe);
        gruppe = new Gruppe("Sende tilbake utgåtte bøker", 0);
        gruppeliste.add(gruppe);
        gruppe = new Gruppe("Rydde i bladene", 6);
        gruppeliste.add(gruppe);

        //create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(this,
            R.layout.activity_gruppeliste, gruppeliste);
        ListView listView = (ListView) findViewById(R.id.gruppeliste);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View view,
//                int position, long id) {
//                // When clicked, show a toast with the TextView text
//                MakeItShine makeItShine = (MakeItShine) parent.getItemAtPosition(position);
//                Toast.makeText(getApplicationContext(),
//                    "Clicked on Row: " + makeItShine.getName(),
//                    Toast.LENGTH_LONG).show();
//            }
//        });
    }

    private class MyCustomAdapter extends ArrayAdapter<Gruppe> {

        private ArrayList<Gruppe> gruppeArrayList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<Gruppe> Gruppelister) {
            super(context, textViewResourceId, Gruppelister);
            this.gruppeArrayList = new ArrayList<>();
            this.gruppeArrayList.addAll(Gruppelister);
        }

        private class ViewHolder {
            TextView name;
            TextView number;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.gruppeliste_layout, null);

                holder = new ViewHolder();
                holder.name = (TextView) convertView.findViewById(R.id.textView10);
                holder.number = (TextView) convertView.findViewById(R.id.textView11);
                convertView.setTag(holder);

                holder.name.setOnClickListener( new View.OnClickListener() {
                    public void onClick(View v) {
                        //TODO: Write ths
                        Toast.makeText(getApplicationContext(), "Clicked on text", Toast.LENGTH_LONG).show();
                    }
                });
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            Gruppe grupper = gruppeArrayList.get(position);
            String memberCount = grupper.getMembers() + "/50 medlemmer";
            holder.name.setText(grupper.getName());
            holder.number.setText(memberCount);
            holder.name.setTag(grupper);

            return convertView;
        }
    }

    private void sendToHighFive()
    {
        Intent intent = new Intent(this, HighFive.class);
        startActivity(intent);
    }
}
