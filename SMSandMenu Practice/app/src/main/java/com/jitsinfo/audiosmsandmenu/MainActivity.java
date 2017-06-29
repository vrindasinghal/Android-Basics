package com.jitsinfo.audiosmsandmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import static com.jitsinfo.audiosmsandmenu.R.id.sendsms_menu;

public class MainActivity extends AppCompatActivity {


    final int OPEN_CAMERA_MENU=1;
    final int OPEN_GALLERY = 2;
    private static final int SELECT_IMAGE =3 ;

    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text= (EditText) findViewById(R.id.contentOfSMS);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.removeItem(OPEN_CAMERA_MENU);
        menu.removeItem(OPEN_GALLERY);

        menu.add(0,OPEN_CAMERA_MENU,0,"Camera");
        menu.add(0,OPEN_GALLERY,0,"Gallery");
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== OPEN_CAMERA_MENU)
        {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivityForResult(intent, 0);
        }
        else if(item.getItemId()==OPEN_GALLERY)
        {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);//
            startActivityForResult(Intent.createChooser(intent, "Select Picture"),SELECT_IMAGE);
        }
        else if(item.getItemId()== sendsms_menu){
            sendsms_menu("9860560977", text.getText().toString());
        }

        else if(item.getItemId()==R.id.Close_menu)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void sendsms_menu(String Mob, String sms) {
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
