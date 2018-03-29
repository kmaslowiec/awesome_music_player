package com.example.android.awesomemusicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        final TextView titleTextView = findViewById(R.id.player_title);
        final TextView artistTextView = findViewById(R.id.player_artist);
        final TextView genreTextView = findViewById(R.id.player_genre);
        SongListForAll app = new SongListForAll();
        final ArrayList<Songs> songsList = app.getArraySongs();




        Bundle songDes = getIntent().getExtras();

        if(songDes!=null){

            titleTextView.setText(songDes.getString("title"));
        }

        if(songDes!=null){

            artistTextView.setText(songDes.getString("artist"));
        }

        if(songDes!=null){

            genreTextView.setText(songDes.getString("genre"));
        }

        final ImageView prev = findViewById(R.id.prev);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Songs prevArray = songsList.get(0);
                titleTextView.setText(prevArray.getSongName());
                artistTextView.setText(prevArray.getArtistName());
                genreTextView.setText(prevArray.getGenre());

            }
        });

    }
}
