package com.example.musicfy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    public static int SPLASH_TIME_IS_FINISHED = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent SongsPage = new Intent(MainActivity.this, Home.class);
                startActivity(SongsPage);
                finish();
            }
        }, SPLASH_TIME_IS_FINISHED);
    }
}