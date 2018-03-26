package com.example.android.awesomemusicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_songs);
        MainActivity app = new MainActivity();

        Songs[] array = app.songsArray;

        /*Songs[] songsArray = {
                new Songs("Thriller", "Micheal Jackson", "Pop"),
                new Songs("bloody roots", "Sepultura", "Heavy Metal"),
                new Songs("These Are The Days Of Our Lives", "Queen", "Rock"),
                new Songs("Nie pytaj mnie", "Tomek Lipiński", "Rock"),
                new Songs("Supergirl", "Anna Naklab feat. Alle Farben & Younotus", "Pop"),
                new Songs("Enjoy the silence", "Depeche Mode", "Electro Pop"),
                new Songs("Come with me", "P.Daddy", "Hip-hop"),
                new Songs("Hurt", "Johnny Cash", "Country"),
                new Songs("All along the watchtower", "Bob Dylan", "Rock"),
                new Songs("More Human Than Human", "White Zombie", "Trash Metal")
        };*/



        ArrayList<Songs> songsArrayList = new ArrayList<>(Arrays.asList(array));

        Collections.sort(songsArrayList, Songs.songNameCompare);

        SongsAdapter adapter = new SongsAdapter(this, songsArrayList);

        ListView listView = (ListView)  findViewById(R.id.list_songs);

        listView.setAdapter(adapter);



    }
}
