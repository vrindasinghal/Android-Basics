package com.jitsinfo.databaseexample;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    DataHelp dataHelp;
    MyOpenHelper myOpenHelper;
    Cursor c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myOpenHelper = new MyOpenHelper(this);
        dataHelp = new DataHelp(this);

        Integer isInserted = dataHelp.insertNewRecord("abc");
        if (isInserted == 1) {
            Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_LONG).show();

        }

        getRecordsFromDatabase();
        //int isDeleted=dataHelp.deleteRecords();
        long isUpdated = dataHelp.UpdateRecords(2);
        if (isUpdated == 1) {
            Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_LONG).show();
            getRecordsFromDatabase();
        }


    }

    public void getRecordsFromDatabase() {

        /** tryCatch block for GetAll Records from database & set to arrayList **/

        try {

            /**** OPEN OR CREATE DATABASE *****/
            dataHelp.db = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME, 0, null);

            /** THIS METHOD IS USED TO GET ALL RECORDS FROM DB */
            c1 = dataHelp.getRecords();
            /** check if returned cursor not null **/

            if (c1.moveToFirst())

            {

                Log.v("Message in C1", "Not Null");

                do {

                    //int a = c1.getColumnCount();
                    String id = c1.getString(0).trim();
                    String pwd = c1.getString(1).trim();

                    Log.v("NoticeDesc", id);
                    Log.v("NoticeAuthoBy", pwd);


                    /***
                     * WHEN WE UNCOMMENT THIS CODE THEN PRINT ALL VALUES IN
                     * LOGCAT
                     *******/

                } while (c1.moveToNext());
            }

            //dh.db.close();

        } catch (Exception e) { // TODO: handle exception
            e.printStackTrace();

        }

    }
}
