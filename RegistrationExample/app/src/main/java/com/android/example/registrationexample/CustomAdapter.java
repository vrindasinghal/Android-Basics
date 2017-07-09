package com.android.example.registrationexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vrinda on 14-06-2017.
 */

public class CustomAdapter extends ArrayAdapter {

    Context con;
    private ArrayList<Integer> arrayListRollNo;
    private ArrayList<String> arrayListPassword;
    int layout;
    int i;


    public CustomAdapter(Context context, int resource,
                         ArrayList<Integer> getRollNo, ArrayList<String> getPassword) {
        super(context, resource, getRollNo);


        this.con = context;
        this.arrayListRollNo = getRollNo;
        this.arrayListPassword = getPassword;
        this.layout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) con
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout, parent, false);
        TextView textViewRollNo = (TextView) rowView
                .findViewById(R.id.textView_RollNo);
        TextView textViewPassword = (TextView) rowView
                .findViewById(R.id.textView_Password);
        Integer getRollNoFromArraylist = arrayListRollNo.get(position);
        textViewRollNo.setText("" + getRollNoFromArraylist);

        String getPasswordFromArraylist = arrayListPassword.get(position).toString();
        Log.v("Adapter", getPasswordFromArraylist);
        textViewPassword.setText(getPasswordFromArraylist);
        return rowView;
    }
}
