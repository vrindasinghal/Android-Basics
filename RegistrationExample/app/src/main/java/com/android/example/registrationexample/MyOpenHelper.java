package com.android.example.registrationexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vrinda on 28-06-2017.
 */

public class MyOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "mydatabas";
    private static final int DATABASE_VERSION = 1;

    public static final String TLoginDetails = "myTable";

    public MyOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TLoginDetails
                + "(rollNo INTEGER PRIMARY KEY,u_password TEXT,u_name TEXT,mobileNo TEXT,qualification TEXT, address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
