package com.example.ideal.share_animation;

import android.animation.Animator;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
LinearLayout revealLesson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        revealLesson = (LinearLayout)findViewById(R.id.linear_layout);

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onClick(View view)
    {
       int cx = (revealLesson.getLeft() + revealLesson.getRight())/2;
        int cy = (revealLesson.getTop() + revealLesson.getBottom())/2;

         // int cx= revealLesson.getRight();
         // int cy = revealLesson.getBottom();
        int finalRadius = (int) Math.hypot((double) revealLesson.getWidth(), (double) revealLesson.getHeight());

        Animator anim = ViewAnimationUtils.createCircularReveal(revealLesson, cx, cy, 0, finalRadius);
        revealLesson.setVisibility(View.VISIBLE);
        anim.setDuration(3000);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();
    }
}
