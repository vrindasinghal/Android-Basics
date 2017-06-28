package com.jitsinfo.alertdialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b1 = (Button) findViewById(R.id.show);

        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub


                showAlertDialogForOnlyConfirmation(MainActivity.this, R.mipmap.ic_launcher_round, "ALERT DIALOG", "Are you sure?");


            }
        });


    }


    /*** This method is used to Show Confirmation AlertDialog */
    public void showAlertDialogForOnlyConfirmation(Context c, Integer imgid,
                                                   String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(
                MainActivity.this, R.style.AlertDialogCustom);
        builder.setCancelable(true);
        builder.setIcon(imgid);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setInverseBackgroundForced(true);

        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {


                    }
                });

        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
}
