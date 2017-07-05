package com.readersguild.datetimepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button datePicker, timePicker;
    private EditText date, time;
    private int mYear;
    private int mMonth;
    private int mDay;
    private int mHours;
    private int mMinutes;
    static final int DATE_DIALOG_ID = 1;
    static final int TIME_DIALOG_ID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = (EditText) findViewById(R.id.editTextDate);
        time = (EditText) findViewById(R.id.editTextTime);
        datePicker = (Button) findViewById(R.id.buttonDatePicker);
        timePicker = (Button) findViewById(R.id.buttonTimePicker);
        setCurrentDateTime();

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DATE_DIALOG_ID);

            }
        });

        timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(TIME_DIALOG_ID);
            }
        });


    }

    private void setCurrentDateTime() {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        StringBuilder sbd = new StringBuilder();
        sbd.append(mYear).append("/").append(mMonth + 1).append("/").append(mDay);
        date.setText(sbd.toString());


    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this, mTimeSetListener, mHours, mMinutes,
                        false);

            // date case
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateSetListener, mYear, mMonth,
                        mDay);

        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            updateDateDisplay();
        }
    };


    // the callback received when the user "sets" the time in the dialog
    private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mHours = hourOfDay;
            mMinutes = minute;
            updateTimeDisplay();
        }
    };

    private void updateDateDisplay() {
        date.setText(new StringBuilder()
                // Month is 0 based so add 1
                .append(mYear).append("-").append(mMonth + 1).append("-")
                .append(mDay).append(" "));
    }

    // updates the time we display in the TextView
    private void updateTimeDisplay() {
        time.setText(new StringBuilder().append(mHours).append(":")
                .append(mMinutes));
    }


}
