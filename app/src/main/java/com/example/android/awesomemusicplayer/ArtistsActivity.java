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

/**
 * Class for Artists category
 */
public class ArtistsActivity extends AppCompatActivity {

    final int listNum = 1; // number of the list. Put the list in correct order
    private boolean toast = false; // enables or disables the Toast

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_songs);
        SongListForAll app = new SongListForAll();
        Bundle intentToast = getIntent().getExtras();

        if (intentToast != null) {
            toast = intentToast.getBoolean("toast"); // gets boolean from MainActivity
        }

        if(toast){ // prints Toast if needed
            Toast.makeText(this, "Artists in alphabetical order", Toast.LENGTH_SHORT).show();
            toast=false;
        }

        ArrayList<Songs> artistsArrayList = app.getArraySongs();

        Collections.sort(artistsArrayList, Songs.artistNameCompare);

        /**
         * The last in adapter parameter sets the layout that is visible under the activity to make it in specific order.
         * Alphabetical order based on titles, artists or genre
         */

        final SongsAdapter adapter = new SongsAdapter(this, artistsArrayList, R.layout.list_artists);

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

                Intent intent = new Intent(ArtistsActivity.this, PlayerActivity.class);

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
