package com.jitsinfo.radiobuttonexample;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private RadioGroup radioGroupGender;
    private String getGender;
    private CheckBox sound, silent, vibrate;
    Button buttonShow;
    StringBuilder sbd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroupGender = (RadioGroup) findViewById(R.id.radioGroup_gender);
        sound = (CheckBox) findViewById(R.id.checkbox_sound);
        silent = (CheckBox) findViewById(R.id.checkbox_silent);
        vibrate = (CheckBox) findViewById(R.id.checkbox_vibrate);
        buttonShow = (Button) findViewById(R.id.button_show);
        sbd = new StringBuilder();


        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

                if (i == R.id.radioButton_male) {
                    getGender = "Male";


                } else if (i == R.id.radioButton_female) {
                    getGender = "FeMale";


                }

                Toast.makeText(MainActivity.this, "You Have Selected" + getGender, Toast.LENGTH_LONG).show();


            }
        });


        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sbd = new StringBuilder();
                if (sound.isChecked()) {

                    sbd.append("Sound");

                }
                if (vibrate.isChecked()) {

                    sbd.append("Vibrate");

                }
                if (silent.isChecked()) {

                    sbd.append("silent");

                }

                Toast.makeText(MainActivity.this, "You Have Selected" + sbd.toString(), Toast.LENGTH_LONG).show();


            }
        });


    }
}
