package com.jitsinfo.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listViewCountry;
    String[] countryNames = {"India", "America", "Japan", "Nepal", "Rus", "Iran"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewCountry = (ListView) findViewById(R.id.listView_country);
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.custom_liststyle, countryNames);
        listViewCountry.setAdapter(adapter);


        listViewCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String getSelectedItem = countryNames[position].toString();

                Toast.makeText(MainActivity.this, "Position = " + position + " " + getSelectedItem, Toast.LENGTH_LONG).show();


            }
        });


    }
}
