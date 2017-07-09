package com.android.example.registrationexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by vrinda on 28-06-2017.
 */

public class DataHelp {
    SQLiteDatabase db;
    SQLiteOpenHelper mhelper;
    MyOpenHelper myhelp;
    Context context;
    Cursor c1;

    public DataHelp(Context con) {
        this.context = con;
        mhelper = new MyOpenHelper(this.context);
        myhelp = new MyOpenHelper(this.context);
        // create a instance of SQLite Database
        this.db = mhelper.getWritableDatabase();
    }

    public long UpdateRecords(Integer rollno, String passw, String oldpass) {
        long count = 0;

        try {
            if ("u_password".equals(oldpass)) {
                ContentValues conV = new ContentValues();
                conV.put("u_password", passw);
                count = db.update(MyOpenHelper.TLoginDetails, conV, "rollNo='"
                        + rollno + "'", null);
                // db.close();
                Log.v("DataHelp", "" + count);
                Log.v("DataHelp", "Updated ReferenceMaster Registration  Successfully");
            } else {
                count = 2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public Cursor getRecords() {
        Cursor c;
        try {
            c = db.rawQuery("select * from  " + MyOpenHelper.TLoginDetails, null);
            return c;
        } catch (Exception e) {
            Log.e("Error At", " " + e);
            e.printStackTrace();
            return null;
        }
    }

    public Integer deleteRecords() {
        try {
            db.execSQL("delete from " + MyOpenHelper.TLoginDetails);
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;

        }
    }

    public Integer insertNewRecord(Integer rollno, String password, String name, String mobileno, String qualification, String address) {

        try {
            Cursor c = db.rawQuery("SELECT  * FROM " + MyOpenHelper.TLoginDetails + " WHERE rollNo = "
                    + rollno, null);
            if (c.moveToFirst()) {
                Log.v("Duplicate rollno", "This rollno is allready exist");
                return 2;
            } else {
                ContentValues conV = new ContentValues();
                conV.put("rollNo", rollno);
                conV.put("u_password", password);
                conV.put("u_name", name);
                conV.put("mobileNo", mobileno);
                conV.put("qualification", qualification);
                conV.put("address", address);
                db.insert(MyOpenHelper.TLoginDetails, null, conV);
                return 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
