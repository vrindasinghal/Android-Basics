package com.jitsinfo.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextFirstInput, editTextSecondInput, editTextOutPut;
    private Button buttonPlus, buttonMinus, buttonMulti, buttonDiv;

    private int getFirstValue, getSecondValue, getResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextFirstInput = (EditText) findViewById(R.id.editText_firstInput);
        editTextSecondInput = (EditText) findViewById(R.id.editText_secondInput);
        editTextOutPut = (EditText) findViewById(R.id.editText_outPut);


        buttonPlus = (Button) findViewById(R.id.button_plus);
        buttonMinus = (Button) findViewById(R.id.button_minus);
        buttonMulti = (Button) findViewById(R.id.button_multi);
        buttonDiv = (Button) findViewById(R.id.button_div);

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFirstValue = Integer.parseInt(editTextFirstInput.getText().toString());
                getSecondValue = Integer.parseInt(editTextSecondInput.getText().toString());
                getResult = getFirstValue + getSecondValue;
                editTextOutPut.setText("" + getResult);


            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFirstValue = Integer.parseInt(editTextFirstInput.getText().toString());
                getSecondValue = Integer.parseInt(editTextSecondInput.getText().toString());
                getResult = getFirstValue - getSecondValue;
                editTextOutPut.setText("" + getResult);


            }
        });

        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFirstValue = Integer.parseInt(editTextFirstInput.getText().toString());
                getSecondValue = Integer.parseInt(editTextSecondInput.getText().toString());
                getResult = getFirstValue * getSecondValue;
                editTextOutPut.setText("" + getResult);


            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFirstValue = Integer.parseInt(editTextFirstInput.getText().toString());
                getSecondValue = Integer.parseInt(editTextSecondInput.getText().toString());
                getResult = getFirstValue / getSecondValue;
                editTextOutPut.setText("" + getResult);


            }
        });


    }
}
