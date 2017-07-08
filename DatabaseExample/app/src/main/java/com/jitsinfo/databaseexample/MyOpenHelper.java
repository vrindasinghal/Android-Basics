package com.jitsinfo.databaseexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vrinda on 27-06-2017.
 */

public class MyOpenHelper extends SQLiteOpenHelper {
    // TODO: Create public field for each column in your table.
    public static final String DATABASE_NAME = "mydatabas";
    private static final int DATABASE_VERSION = 1;

    public static final String TLoginDetails = "myTable";


    public MyOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
         * SQL Statement to create a new Table 'TLoginDetails' in "mydatabas"
		 * Database.*********
		 */

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TLoginDetails
                + "(uid INTEGER PRIMARY KEY AUTOINCREMENT,u_password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
