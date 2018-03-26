package com.example.android.awesomemusicplayer;

import android.support.annotation.NonNull;

import java.util.Comparator;

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

    public static Comparator<Songs> songNameCompare = new Comparator<Songs>() {

        @Override
        public int compare(Songs songs1, Songs songs2) {

            String songName1 = songs1.getSongName().toUpperCase();
            String songName2 = songs2.getSongName().toUpperCase();

            return songName1.compareTo(songName2);
        }
    };

}
