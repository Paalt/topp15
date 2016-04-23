package com.app.bc.bladansvarligapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by alkan on 16.04.2016.
 */
public class WelcomeMenu extends Activity {

    // .DATA?
    private TextView mButikkNavn;
    private TextView mDate;
    private TextView mDay;
    private TextView mTaskDue;
    private TextView mMonthYear;

    // .CODE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_menu);

        Calendar today = Calendar.getInstance();

        String navn = "COOP Mega Skøyen";
        String aar = getMonth(today.get(Calendar.MONTH)) + " " + String.valueOf(today.get(Calendar.YEAR));
        String tasks = "8";

        mButikkNavn = (TextView) findViewById(R.id.ButikkNavn);
        mDate = (TextView) findViewById(R.id.Date);
        mDay = (TextView) findViewById(R.id.Day);
        mTaskDue = (TextView) findViewById(R.id.TaskDue);
        mMonthYear = (TextView) findViewById(R.id.MonthYear);
        mButikkNavn.setText(navn);
        mTaskDue.setText(tasks);
        mDate.setText(String.valueOf(today.get(Calendar.DAY_OF_MONTH)));
        mDay.setText(getDay(today.get(Calendar.DAY_OF_WEEK)));
        mMonthYear.setText(aar);
    }

    private String getDay (int day_of_the_week){
        switch (day_of_the_week){
            case 1: return "SØN";
            case 2: return "MAN";
            case 3: return "TIR";
            case 4: return "ONS";
            case 5: return "TOR";
            case 6: return "FRE";
            case 7: return "LØR";
            default: return "";
        }
    }

    private String getMonth (int month_of_year){
        switch (month_of_year){
            case 0: return "Januar";
            case 1: return "Februar";
            case 2: return "Mars";
            case 3: return "April";
            case 4: return "Mai";
            case 5: return "Juni";
            case 6: return "Juli";
            case 7: return "August";
            case 8: return "September";
            case 9: return "Oktober";
            case 10: return "November";
            case 11: return "Desember";
            default: return "";
        }
    }
}
