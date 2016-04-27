package com.app.bc.bladansvarligapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by alkan on 26.04.2016.
 */
public class Supplering extends Activity{

    // .DATA
    MyCustomAdapter dataAdapter = null;

    // .DATA?
    ArrayList<Books> books;
    Button mBestill;
    AlertDialog.Builder builder;

    // .CODE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplering);

        mBestill = (Button) findViewById(R.id.bestill);

        createAlert();
        DisplayListView();

        mBestill.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        );
    }

    private void createAlert(){
        builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Bestill");
        builder.setMessage("Er du sikker på at du vil bestille de valgte bøkene?");
        builder.setPositiveButton("Confirm",
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            }
        );
        builder.setNegativeButton(android.R.string.cancel,
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            }
        );
    }

    private void DisplayListView(){
        books = new ArrayList<>();
        Books book = new Books("dummy");
        books.add(book);
        book = new Books("Another dummy");
        books.add(book);

        dataAdapter = new MyCustomAdapter(this, R.layout.activity_supplering, books);
        ListView listView = (ListView) findViewById(R.id.SuppleringListe);
        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Books supplering = (Books) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Clicked on " + supplering.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private class MyCustomAdapter extends ArrayAdapter<Books> {

        private ArrayList<Books> bookArrayList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<Books> Books) {
            super(context, textViewResourceId, Books);
            this.bookArrayList = new ArrayList<>();
            this.bookArrayList.addAll(Books);
        }

        private class ViewHolder {
            TextView name;
            EditText number;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.supplering_layout, null);

                holder = new ViewHolder();
                holder.name = (TextView) convertView.findViewById(R.id.textView8);
                holder.number = (EditText) convertView.findViewById(R.id.editText);
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

            Books supplering = bookArrayList.get(position);
            holder.name.setText(supplering.getName());
            //holder.name.setChecked(supplering.isSelected());
            holder.name.setTag(supplering);

            return convertView;
        }
    }
}
