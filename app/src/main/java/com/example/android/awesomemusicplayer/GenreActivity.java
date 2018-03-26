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

        GenreAdapter adapter = new GenreAdapter(this, songsArrayList);

        ListView listView = (ListView)  findViewById(R.id.list_songs);

        listView.setAdapter(adapter);



    }
}
