package com.example.homework1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import com.example.homework1.interfaces.Constants;
import com.example.homework1.R;

@SuppressLint("CustomSplashScreen")
public class GameSplashActivity extends AppCompatActivity implements Constants {
    private ImageView splash_IMG_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        findViews();
        splash_IMG_logo.setVisibility(View.INVISIBLE);
        showCarMoving(splash_IMG_logo);
    }

    private void showCarMoving(final View v) {
        v.setVisibility(View.VISIBLE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        v.setX(-width);
        v.setScaleX(1.0f);
        v.setScaleY(1.0f);
        v.animate()
                .scaleX(1.0f)
                .scaleY(1.0f)
                .translationX(width)
                .setDuration(ANIM_DUR)
                .setInterpolator(new AccelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        animationDone();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }

    private void animationDone() {
        Intent intent = new Intent(this, GameMenuActivity.class);
        startActivity(intent);
        finish();
    }

    private void findViews() {
        splash_IMG_logo = findViewById(R.id.splash_IMG_logo);
    }
}
