package com.example.musicfy;

public class Song {
    private String songName;
    private String singerName;
    private int songPhoto;
    private int AllSongs;

    public Song(int songPhoto, String songName, String singerName, int AllSongs) {
        this.songName = songName;
        this.singerName = singerName;
        this.songPhoto = songPhoto;
        this.AllSongs = AllSongs;

    }

    public String getSongName() {
        return songName;
    }

    public String getSingerName() {
        return singerName;
    }

    public int getSongPhoto() {
        return songPhoto;
    }

    public int getAllSongs() { return AllSongs; }

}
