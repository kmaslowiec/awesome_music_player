package com.example.android.awesomemusicplayer;

/**
 * Class to create Songs list
 */

public class Songs {

    private String songName;
    private String artistName;
    private String genre;

    public Songs(String songName, String artistName, String genre) {
        this.songName = songName;
        this.artistName = artistName;
        this.genre = genre;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getGenre() {
        return genre;
    }
}
