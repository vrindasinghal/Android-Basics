package com.jitsinfo.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        Log.v("TAG", "Called to OnCreate");

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);


            }
        });
    }


    @Override
    protected void onDestroy() {
        Log.v("TAG", "Called to onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        Log.v("TAG", "Called to onStart");
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.v("TAG", "Called to onPause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.v("TAG", "Called to onRestart");
        super.onRestart();
    }

    @Override
    protected void onStop() {
        Log.v("TAG", "Called to onStop");
        super.onStop();


    }

    @Override
    protected void onResume() {
        Log.v("TAG", "Called to onResume");
        super.onResume();
    }
}
