package com.example.android.awesomemusicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GenreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_songs);

        MainActivity app = new MainActivity();

        Songs[] array = app.songsArray;

        ArrayList<Songs> songsArrayList = new ArrayList<>(Arrays.asList(array));

        Collections.sort(songsArrayList, Songs.genreCompare);

        /**
         * The last parameter sets the layout that is visible under the activity
         */

        SongsAdapter adapter = new SongsAdapter(this, songsArrayList, R.layout.list_genre);

        ListView listView = (ListView)  findViewById(R.id.list_songs);

        listView.setAdapter(adapter);



    }
}
