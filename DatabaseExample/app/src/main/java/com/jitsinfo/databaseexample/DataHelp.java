package com.jitsinfo.databaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by vrinda on 27-06-2017.
 */

public class DataHelp {

    /* Initialization SQLiteDatabase & create reference variable */
    SQLiteDatabase db;

    /**
     * Database open/upgrade helper
     */
    SQLiteOpenHelper mhelper;
    MyOpenHelper myhelp;
    /**
     * Context of the application using the database.
     */
    Context context;
    Cursor c1;

    public DataHelp(Context con) {

        this.context = con;
        mhelper = new MyOpenHelper(this.context);
        myhelp = new MyOpenHelper(this.context);
        // create a instance of SQLite Database
        this.db = mhelper.getWritableDatabase();


    }


    public Integer insertNewRecord(String password) {

        try {
            ContentValues conV = new ContentValues();
            conV.put("u_password", password);
            db.insert(MyOpenHelper.TLoginDetails, null, conV);
            return 1;

        } catch (Exception e) {
            return 0;


        }

    }

    // Get All Departments Notifications
    public Cursor getRecords() {
        Cursor c;
        try {
            c = db.rawQuery("select * from  " + MyOpenHelper.TLoginDetails, null);
            return c;
        } catch (Exception e) {
            Log.e("Error At", " " + e);
            e.printStackTrace();
            // TODO: handle exception
            return null;
        }
    }

    /**
     * Delete AllNotifications records
     */
    public Integer deleteRecords() {
        try {
            db.execSQL("delete from " + MyOpenHelper.TLoginDetails);
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;

        }
    }

    /****** Update Status YES or NO ***********/
    public long UpdateRecords(Integer Id) {
        long count = 0;

        try {

            ContentValues conV = new ContentValues();
            conV.put("u_password", "xyz");
            count = db.update(MyOpenHelper.TLoginDetails, conV, "uid='"
                    + Id + "'", null);

            // db.close();

            Log.v("DataHelp", "" + count);
            Log.v("DataHelp", "Updated ReferenceMaster Registration  Successfully");

        } catch (Exception e) {

            e.printStackTrace();

        }
        return count;

    }


}
