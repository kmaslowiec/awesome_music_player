package com.example.android.awesomemusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;

public class SongsActivity extends AppCompatActivity {

    private final int listNum = 1;

    public int getListNum() {
        return listNum;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_songs);
        SongListForAll app = new SongListForAll();

        ArrayList<Songs> songsArrayList = app.getArraySongs();

        Collections.sort(songsArrayList, Songs.songNameCompare);

        final SongsAdapter adapter = new SongsAdapter(this, songsArrayList, R.layout.list_title);

        ListView listView = findViewById(R.id.list_songs);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Songs item = (Songs) adapterView.getItemAtPosition(position);

                String title = item.getSongName();
                String artist = item.getArtistName();
                String genre = item.getGenre();

                Intent intent = new Intent(SongsActivity.this, PlayerActivity.class);

                intent.putExtra("title", title );
                intent.putExtra("artist", artist);
                intent.putExtra("genre", genre);
                intent.putExtra("listNum", getListNum());



                startActivity(intent);
                Log.i("position", Integer.toString(position));
            }


        });


    }
}
