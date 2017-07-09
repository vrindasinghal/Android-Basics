package com.android.example.registrationexample;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] qualifications = {"BTech", "MBBS", "CA", "Post Graduate"};
    Spinner spinnerQualificationList;
    private EditText rollNumber, name, mobileNumber, password, address,changepass_rollNo,changepass_oldpass,changepass_newpass;
    private Button insert, delete, update, get;
    DataHelp dataHelp;
    MyOpenHelper myOpenHelper;
    String getSelectedQualification;
    Cursor c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myOpenHelper = new MyOpenHelper(this);
        dataHelp = new DataHelp(this);

        spinnerQualificationList = (Spinner) findViewById(R.id.spinner_qualification);
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, qualifications);
        spinnerQualificationList.setAdapter(arrayAdapter);

        spinnerQualificationList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                getSelectedQualification = spinnerQualificationList.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        rollNumber = (EditText) findViewById(R.id.RollNo);
        name = (EditText) findViewById(R.id.Name);
        mobileNumber = (EditText) findViewById(R.id.MobileNo);
        password = (EditText) findViewById(R.id.Password);
        address = (EditText) findViewById(R.id.Address);
        changepass_rollNo= (EditText) findViewById(R.id.rollNoEditPassword);
        changepass_oldpass= (EditText) findViewById(R.id.oldPassword);
        changepass_newpass= (EditText) findViewById(R.id.newPassword);


        final String pass = password.getText().toString();
        final String nam = name.getText().toString();
        final String mobno = mobileNumber.getText().toString();
        final String add = address.getText().toString();

        insert = (Button) findViewById(R.id.button_insert);
        delete = (Button) findViewById(R.id.button_del);
        update = (Button) findViewById(R.id.button_update);
        get = (Button) findViewById(R.id.button_get);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Integer rollNum = Integer.parseInt(rollNumber.getText().toString());
                if(rollNum.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter roll number", Toast.LENGTH_SHORT).show();
                }
                /*if(pass.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                }*/
                else {
                    Integer isInserted = dataHelp.insertNewRecord(rollNum, pass, nam, mobno, getSelectedQualification, add);
                    if (isInserted == 1) {
                        Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                    } else if (isInserted == 2) {
                        Toast.makeText(MainActivity.this, "Duplicate RollNumber", Toast.LENGTH_SHORT).show();
                    } else if (isInserted == 0) {
                        Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int isDeleted = dataHelp.deleteRecords();
                if (isDeleted == 1) {
                    Toast.makeText(MainActivity.this, "All Records Deleted", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Could not delete records", Toast.LENGTH_SHORT).show();
                }
            }
        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GetActivity.class);
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDailog();
            }
        });

    }

    private void showDailog(){
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.change_password);
       // dialog.setTitle("Change Password");

        Button changeButton = (Button) dialog.findViewById(R.id.dialog_buttonChange);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Integer changeRollNo=Integer.parseInt(changepass_rollNo.getText().toString());
                final String changeOldPass = changepass_oldpass.getText().toString();
                final String changeNewPass = changepass_newpass.getText().toString();
                long isUpdated = dataHelp.UpdateRecords(changeRollNo,changeNewPass,changeOldPass);
                if (isUpdated == 1) {
                    Toast.makeText(MainActivity.this, "Password Changed", Toast.LENGTH_LONG).show();
                }
                else if (isUpdated == 2) {
                    Toast.makeText(MainActivity.this, "Wrong old password", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
        }
    });
        Button dialogButton = (Button) dialog.findViewById(R.id.dialog_buttonOk);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
