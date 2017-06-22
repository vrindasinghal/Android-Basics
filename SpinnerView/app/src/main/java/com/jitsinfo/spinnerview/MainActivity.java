package com.jitsinfo.spinnerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] stateList = {"Maharashtra", "Gujarat", "Tamilnadu", "Goa", "Aasam"};

    Spinner spinnerCountryList, spinnerStateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerCountryList = (Spinner) findViewById(R.id.spinner_country);
        spinnerStateList = (Spinner) findViewById(R.id.spinner_state);

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, stateList);
        spinnerStateList.setAdapter(arrayAdapter);


        //spinnerStateList.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, stateList));
        spinnerStateList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String getSelectedState = spinnerStateList.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, getSelectedState, Toast.LENGTH_LONG).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
