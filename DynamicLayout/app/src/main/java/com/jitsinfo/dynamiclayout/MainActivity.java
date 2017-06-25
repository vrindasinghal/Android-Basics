package com.jitsinfo.dynamiclayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lLayout = (LinearLayout) findViewById(R.id.linear_layout);
        lLayout.setGravity(Gravity.CENTER_VERTICAL);

//new linear layout
        LinearLayout ratingImgLayout = new LinearLayout(this);
        ratingImgLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));


        // Label
        TextView txt = new TextView(this);
        txt.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        txt.setGravity(Gravity.CENTER_VERTICAL);
        txt.setText("Rating");


        // Rating Bar
        RatingBar ratingBar = new RatingBar(this);
        ratingBar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        ratingBar.setNumStars(5);
        ratingBar.setStepSize((float) 1.0);
        ratingBar.setSaveEnabled(false);


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                Toast.makeText(ratingBar.getContext(),
                        "Rating " + Float.toString(rating), Toast.LENGTH_SHORT)
                        .show();
            }
        });

        ratingImgLayout.addView(txt);
        ratingImgLayout.addView(ratingBar);
        lLayout.addView(ratingImgLayout);


    }
}
