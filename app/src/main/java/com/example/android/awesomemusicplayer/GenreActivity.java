package com.example.android.awesomemusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class GenreActivity extends AppCompatActivity {

    final int listNum = 2;
    private boolean toast = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_songs);
        Bundle intentToast = getIntent().getExtras();

        if (intentToast != null) {
            toast = intentToast.getBoolean("toast");
        }

        if(toast){
            Toast.makeText(this, "Genre in alphabetical order", Toast.LENGTH_SHORT).show();
            toast=false;
        }

        SongListForAll app = new SongListForAll();

        ArrayList<Songs> genreArrayList = app.getArraySongs();

        Collections.sort(genreArrayList, Songs.artistNameCompare);

        Collections.sort(genreArrayList, Songs.genreCompare);

        /**
         * The last parameter sets the layout that is visible under the activity
         */

        final SongsAdapter adapter = new SongsAdapter(this, genreArrayList, R.layout.list_title);

        final ListView listView = findViewById(R.id.list_songs);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Songs item = (Songs) adapterView.getItemAtPosition(position);
                listView.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_style_clicked));

                String title = item.getSongName();
                String artist = item.getArtistName();
                String genre = item.getGenre();

                Intent intent = new Intent(GenreActivity.this, PlayerActivity.class);

                intent.putExtra("title", title );
                intent.putExtra("artist", artist);
                intent.putExtra("genre", genre);
                intent.putExtra("listNum", listNum);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });



    }
}
