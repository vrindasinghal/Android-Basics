package com.jitsinfo.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView_custom;
    private ArrayList<String> names;
    private ArrayList<Integer> icons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView_custom = (ListView) findViewById(R.id.listView_custom);

        names = new ArrayList<String>();
        icons = new ArrayList<Integer>();
        bindDataInArrayList();
        CustomAdapter adapter = new CustomAdapter(MainActivity.this, R.layout.activity_customlistview, names, icons);
        listView_custom.setAdapter(adapter);


    }

    private void bindDataInArrayList() {
        names.add("Flipkart");
        names.add("Amezon");
        names.add("Abof");
        names.add("Ebay");

        icons.add(R.mipmap.ic_launcher);
        icons.add(R.mipmap.ic_launcher_round);
        icons.add(R.mipmap.ic_launcher);
        icons.add(R.mipmap.ic_launcher_round);


    }
}
