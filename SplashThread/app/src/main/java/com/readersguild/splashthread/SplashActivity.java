package com.readersguild.splashthread;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by vrinda on 03-07-2017.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /* Run Thread for 3 seconds */

        Thread timer = new Thread() {

            public void run() {

                try {
                    sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent HomeActivity = new Intent(SplashActivity.this,
                            MainActivity.class);
                    startActivity(HomeActivity);
                }

            }
        };

        timer.start();


    }
}
