package com.example.musicfy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;

public class Home extends AppCompatActivity {

    ListView listOfSongs;

    Button artist_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listOfSongs = (ListView)findViewById(R.id.songs);
        ArrayList<Song> results = new ArrayList<>();
        results.add(new Song(R.drawable.allahshahid, getString(R.string.allashahidText),"تامر حسني", R.raw.allahshahid));
        results.add(new Song(R.drawable.tamer2, getString(R.string.erfa3edakText),"تامر حسني", R.raw.erfa3edak));
        results.add(new Song(R.drawable.kazem1, getString(R.string.saba7el5erText),"كاظم الساهر", R.raw.saba7el5er));
        results.add(new Song(R.drawable.kazem2, getString(R.string.eedeloshakText),"كاظم الساهر", R.raw.eedeloshak));
        results.add(new Song(R.drawable.om1, getString(R.string.entaomryText),"ام كلثوم", R.raw.entaomry));
        results.add(new Song(R.drawable.om2, getString(R.string.sirtelhobText),"ام كلثوم", R.raw.sirtelhob));
        results.add(new Song(R.drawable.amr1, getString(R.string.habibyText),"عمرو دياب", R.raw.habiby));
        results.add(new Song(R.drawable.amr2, getString(R.string.shoknaText),"عمرو دياب", R.raw.shokna));

        SongAdapter adapter = new SongAdapter(this, R.layout.songs_lists, results);

        listOfSongs.setAdapter(adapter);

        artist_btn = (Button) findViewById(R.id.artist_btn);

        artist_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentToArtistsPage();
            }
        });

    }

    private void IntentToArtistsPage() {
        Intent artistIntent = new Intent(getApplicationContext(), Artist.class);
        startActivity(artistIntent);
        Toast.makeText(getApplicationContext(), R.string.ArtistToast, LENGTH_LONG).show();
    }
}