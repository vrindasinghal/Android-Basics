package com.android.example.registrationexample;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by vrinda on 03-07-2017.
 */

public class GetActivity extends AppCompatActivity {

    DataHelp dataHelp;
    Cursor c1;
    ListView listView_custom;
    private ArrayList<Integer> RollNo;
    private ArrayList<String> Password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_activity);
        dataHelp = new DataHelp(GetActivity.this);
        listView_custom = (ListView) findViewById(R.id.listView_custom);
        RollNo = new ArrayList<Integer>();
        Password = new ArrayList<String>();
        getRecordsFromDatabase();
        CustomAdapter adpt = new CustomAdapter(GetActivity.this, R.layout.list_view, RollNo, Password);
        listView_custom.setAdapter(adpt);
    }

    private void getRecordsFromDatabase() {
        /** tryCatch block for GetAll Records from database & set to arrayList **/
        try {
            /**** OPEN OR CREATE DATABASE *****/
            dataHelp.db = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME, 0, null);
            /** THIS METHOD IS USED TO GET ALL RECORDS FROM DB */
            c1 = dataHelp.getRecords();
            /** check if returned cursor not null **/
            if (c1.moveToFirst()) {
                Log.v("Message in C1", "Not Null");
                do {
                    //int a = c1.getColumnCount();
                    String rollno = c1.getString(0);
                    String password = c1.getString(1);
                    if (password.equals("")) {
                        Log.v("TAG pwd", "Null");
                    }

                    Log.v("TAG", rollno);
                    Log.v("TAG pwd", password);
                    RollNo.add(Integer.parseInt(rollno));
                    Password.add(password);
                } while (c1.moveToNext());
            } else {
                Log.v("TAG", "Database Null");

            }
            //dh.db.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
