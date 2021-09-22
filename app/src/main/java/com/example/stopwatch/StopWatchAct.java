package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchAct extends AppCompatActivity {

    Button btnstart, btnstop;
    ImageView icanchor;
    Animation roundingalone;
    Chronometer timeHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnstart= findViewById(R.id.btnStart);
        btnstop =findViewById(R.id.btnStop);
        icanchor= findViewById(R.id.icAnchor);
        timeHere=findViewById(R.id.timeHere);

        btnstop.setAlpha(0);

        roundingalone= AnimationUtils.loadAnimation(this,R.anim.roundingalone);

        Typeface MMedium= Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");


        btnstart.setTypeface(MMedium);
        btnstop.setTypeface(MMedium);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icanchor.startAnimation(roundingalone);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();

                timeHere.setBase(SystemClock.elapsedRealtime());
                timeHere.start();
            }
        });
    }
}