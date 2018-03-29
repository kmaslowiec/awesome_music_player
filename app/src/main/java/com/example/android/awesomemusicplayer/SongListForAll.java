package com.example.android.awesomemusicplayer;

import java.util.ArrayList;

/**
 * This is data base of the Songs Objects
 */

public class SongListForAll {

    private ArrayList<Songs> array = new ArrayList<>();

    public ArrayList<Songs> getArraySongs() {


        array.add(new Songs("Thriller", "Micheal Jackson", "Pop"));
        array.add(new Songs("Bloody roots", "Sepultura", "Heavy Metal"));
        array.add(new Songs("These Are The Days Of Our Lives", "Queen", "Rock"));
        array.add(new Songs("Nie pytaj mnie", "Tomek Lipiński", "Rock"));
        array.add(new Songs("Supergirl", "Anna Naklab feat. Alle Farben & Younotus", "Pop"));
        array.add(new Songs("Enjoy the silence", "Depeche Mode", "Electro Pop"));
        array.add(new Songs("Come with me", "P.Daddy", "Hip-hop"));
        array.add(new Songs("Hurt", "Johnny Cash", "Country"));
        array.add(new Songs("All along the watchtower", "Bob Dylan", "Rock"));
        array.add(new Songs("More Human Than Human", "White Zombie", "Trash Metal"));

        return array;

    }


}
