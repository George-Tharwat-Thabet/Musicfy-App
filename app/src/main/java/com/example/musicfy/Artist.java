package com.example.musicfy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class Artist extends AppCompatActivity {

    Button songs_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        songs_btn = (Button) findViewById(R.id.songs_btn);
        songs_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentToSongsPage();
            }
        });


    }

    private void IntentToSongsPage() {
        Intent artistIntent = new Intent(getApplicationContext(), Home.class);
        startActivity(artistIntent);
        Toast.makeText(getApplicationContext(), R.string.SongsToast, LENGTH_LONG).show();
    }
}