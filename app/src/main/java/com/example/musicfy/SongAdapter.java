package com.example.musicfy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    Context context;
    int resource;
    private MediaPlayer mediaPlayerForAllSongs;
    private boolean isClicked = true;

    public SongAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Song> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource, parent, false);

        ImageView image = (ImageView) convertView.findViewById(R.id.image);
        TextView song_name = (TextView) convertView.findViewById(R.id.song_name);
        TextView singer_name = (TextView) convertView.findViewById(R.id.singer_name);
        final ImageView play_button = (ImageView) convertView.findViewById(R.id.play_button);
        final ImageView pause_button = (ImageView) convertView.findViewById(R.id.pause_button);

        final Song currentSong = getItem(position);

        image.setImageResource(currentSong.getSongPhoto());
        song_name.setText(currentSong.getSongName());
        singer_name.setText(currentSong.getSingerName());
        play_button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                if(isClicked){
                    mediaPlayerForAllSongs = MediaPlayer.create(context, currentSong.getAllSongs());
                    isClicked = false;
                }
                if (mediaPlayerForAllSongs.isPlaying()){
                    mediaPlayerForAllSongs.pause();
                }
                else {
                    mediaPlayerForAllSongs.start();
                }
            }
        });
        pause_button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                if(!isClicked){
                    mediaPlayerForAllSongs.pause();
                    mediaPlayerForAllSongs.release();
                    isClicked = true;
                }
            }
        });

        return convertView;
    }
}
