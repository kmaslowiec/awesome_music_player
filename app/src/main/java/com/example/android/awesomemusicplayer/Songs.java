package com.example.android.awesomemusicplayer;

import java.util.Comparator;

/**
 * Class to create Songs object
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

    /**
     * Puts the titles form ArrayList in alphabetical orders
     */
    public static Comparator<Songs> songNameCompare = new Comparator<Songs>() {

        @Override
        public int compare(Songs songs1, Songs songs2) {

            String songName1 = songs1.getSongName().toUpperCase();
            String songName2 = songs2.getSongName().toUpperCase();

            return songName1.compareTo(songName2);
        }
    };

    /**
     * Puts the artists form ArrayList in alphabetical orders
     */
    public static Comparator<Songs> artistNameCompare = new Comparator<Songs>() {
        @Override
        public int compare(Songs songs1, Songs songs2) {
            String songName1 = songs1.getSongName().toUpperCase();
            String songName2 = songs2.getSongName().toUpperCase();
            String artistName1 = songs1.getArtistName().toUpperCase();
            String artistName2 = songs2.getArtistName().toUpperCase();

            if (artistName1.equals(artistName2)) {
                return songName1.compareTo(songName2);
            }

            return artistName1.compareTo(artistName2);
        }

    };

    /**
     * Puts the genre form ArrayList in alphabetical orders
     */
    public static Comparator<Songs> genreCompare = new Comparator<Songs>() {
        @Override
        public int compare(Songs songs1, Songs songs2) {
            String songName1 = songs1.getSongName().toUpperCase();
            String songName2 = songs2.getSongName().toUpperCase();
            String genre1 = songs1.getGenre().toUpperCase();
            String genre2 = songs2.getGenre().toUpperCase();

            if (genre1.equals(genre2)) {
                return songName1.compareTo(songName2);
            }

            return genre1.compareTo(genre2);
        }

    };
}
