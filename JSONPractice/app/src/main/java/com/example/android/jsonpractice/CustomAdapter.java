package com.example.android.jsonpractice;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vrinda on 04-07-2017.
 */

public class CustomAdapter extends ArrayAdapter {
    Context con;
    private ArrayList<String> arrayListIds;
    private ArrayList<String> arrayListNames;
    private ArrayList<String> arrayListEmails;
    private ArrayList<String> arrayListAddress;
    private ArrayList<String> arrayListGender;
    //private ArrayList<String> arrayListMobileNos;

    int layout;
    int i;

    public CustomAdapter(@NonNull Context context, @LayoutRes int resource,
                         ArrayList<String> getId, ArrayList<String> getName, ArrayList<String> getEmail, ArrayList<String> getAddress, ArrayList<String> getGender) {
        super(context, resource, getId);

        this.con = context;
        this.arrayListIds = getId;
        this.arrayListNames = getName;
        this.arrayListAddress = getAddress;
        this.arrayListEmails = getEmail;
        this.arrayListGender = getGender;
        //this.arrayListMobileNos = getMobieNo;
        this.layout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflter = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflter.inflate(layout, parent, false);

        TextView textViewIds = (TextView) rowView.findViewById(R.id.id);
        String getIdFromArraylist = arrayListIds.get(position).toString();
        textViewIds.setText(getIdFromArraylist);

        TextView textViewNames = (TextView) rowView.findViewById(R.id.name);
        String getNameFromArraylist = arrayListNames.get(position).toString();
        textViewNames.setText(getNameFromArraylist);

        TextView textViewEmail = (TextView) rowView.findViewById(R.id.email);
        String getEmailFromArraylist = arrayListEmails.get(position).toString();
        textViewEmail.setText(getEmailFromArraylist);

        TextView textViewAddress = (TextView) rowView.findViewById(R.id.address);
        String getAddressFromArraylist = arrayListAddress.get(position).toString();
        textViewAddress.setText(getAddressFromArraylist);

        TextView textViewGender = (TextView) rowView.findViewById(R.id.gender);
        String getGenderFromArraylist = arrayListGender.get(position).toString();
        textViewGender.setText(getGenderFromArraylist);

        /*TextView textViewMobNo = (TextView) rowView.findViewById(R.id.mobileno);
        String getMobNoFromArraylist = arrayListMobileNos.get(position).toString();
        textViewMobNo.setText(getMobNoFromArraylist);*/

        return rowView;
    }

}
