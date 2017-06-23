package com.jitsinfo.smssendingexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button send_sms;
    EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send_sms = (Button) findViewById(R.id.send_sms);
        ed = (EditText) findViewById(R.id.editTextsms);


        send_sms.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                send_sms("9860560977", ed.getText().toString());

            }
        });
    }

    public void send_sms(String Mob, String sms) {

        try {
            SmsManager smsManager = SmsManager.getDefault();

            smsManager.sendTextMessage(Mob, null, sms, null, null);

            // ArrayList<String> parts = smsManager.divideMessage(sms);

            //smsManager.sendMultipartTextMessage(Mob, null, parts, null, null);

            // Log.d("multipart mag", "" + parts);
            Toast.makeText(getApplicationContext(),
                    "SMS Sent Successfully....", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),
                    "SMS Sending faild, please try again later!",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }
}
