package com.jitsinfo.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by vrinda on 09-06-2017.
 */

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("TAG", "Called to OnCreate");


    }

    @Override
    protected void onDestroy() {
        Log.d("TAG", "Called to onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        Log.d("TAG", "Called to onStart");
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.d("TAG", "Called to onPause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.d("TAG", "Called to onRestart");
        super.onRestart();
    }

    @Override
    protected void onStop() {
        Log.d("TAG", "Called to onStop");
        super.onStop();


    }

    @Override
    protected void onResume() {
        Log.d("TAG", "Called to onResume");
        super.onResume();
    }
}
