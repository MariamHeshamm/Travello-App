package com.example.travelo_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class LogoActivity extends AppCompatActivity {
    private static int SplashTimeOut=2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                    Intent sliderIntent = new Intent(LogoActivity.this, SliderActivity.class);
                    startActivity(sliderIntent);
                    finish();


            }
        },SplashTimeOut);
    }
}