package com.jitsinfo.andriodversions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] versionNo = {"1.5", "1.6", "2.0", "2.1", "2.2", "2.3", "3.0", "3.1", "3.2", "4.0", "4.1", "4.2", "5.0", "5.1", "6.0", "6.1", "7"};

    private Spinner versionNumber, versionName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        versionNumber = (Spinner) findViewById(R.id.versionnumber);
        versionName = (Spinner) findViewById(R.id.versionname);

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, versionNo);
        versionNumber.setAdapter(arrayAdapter);

        versionNumber.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String getSelectedVersionNumber = versionNumber.getSelectedItem().toString();
                String getSelectedVersionName = versionName.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, getSelectedVersionName + " " + getSelectedVersionNumber, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
