package com.jitsinfo.customlistview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vrinda on 14-06-2017.
 */

public class CustomAdapter extends ArrayAdapter {

    Context con;
    private ArrayList<String> arrayListNames;
    private ArrayList<Integer> arrayListImageId;
    int layout;
    int i;

    public CustomAdapter(@NonNull Context context, @LayoutRes int resource,
                         ArrayList<String> getNames, ArrayList<Integer> getIcons) {
        super(context, resource, getNames);


        this.con = context;
        this.arrayListNames = getNames;
        this.arrayListImageId = getIcons;
        this.layout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflter = (LayoutInflater) con
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflter.inflate(layout, parent, false);

        TextView textViewNames = (TextView) rowView
                .findViewById(R.id.textView_Names);

        ImageView img_profileicon = (ImageView) rowView
                .findViewById(R.id.imageView_profileIcn);
        String getNameFromArraylist = arrayListNames.get(position).toString();
        textViewNames.setText(getNameFromArraylist);
        Integer imageId = arrayListImageId.get(position);
        img_profileicon.setImageResource(imageId);
        return rowView;
    }
}
