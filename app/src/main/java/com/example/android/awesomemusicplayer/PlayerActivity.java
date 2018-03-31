package com.example.android.awesomemusicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class PlayerActivity extends AppCompatActivity {

    private ArrayList<Songs> songsList;
    private int position;
    private int playerListNum;

    private TextView titleTextView;
    private TextView artistTextView;
    private TextView genreTextView;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        SongListForAll app = new SongListForAll();
        songsList = app.getArraySongs();
        Bundle songDes = getIntent().getExtras();

        initTextViews();

        if (songDes != null) {
            position = songDes.getInt("position");
        }

        pos = position;

        if (songDes != null) {
            playerListNum = songDes.getInt("listNum");
        }

        if (playerListNum == 0) {
            Collections.sort(songsList, Songs.songNameCompare);
        }
        if (playerListNum == 1) {
            Collections.sort(songsList, Songs.artistNameCompare);
        }
        if (playerListNum == 2) {
            Collections.sort(songsList, Songs.genreCompare);
        }

        if (songDes != null) {
            titleTextView.setText(songDes.getString("title"));
        }

        if (songDes != null) {
            artistTextView.setText(songDes.getString("artist"));
        }

        if (songDes != null) {
            genreTextView.setText(songDes.getString("genre"));
        }

        prevListener();
        nextListener();

    }

    public void initTextViews() {
        titleTextView = findViewById(R.id.player_title);
        artistTextView = findViewById(R.id.player_artist);
        genreTextView = findViewById(R.id.player_genre);
    }

    public void prevListener() {
        ImageView prev = findViewById(R.id.prev);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pos > 0) {
                    pos--;
                    Songs prevArray = songsList.get(pos);
                    titleTextView.setText(prevArray.getSongName());
                    artistTextView.setText(prevArray.getArtistName());
                    genreTextView.setText(prevArray.getGenre());
                }
            }
        });
    }

    public void nextListener(){
        ImageView prev = findViewById(R.id.next);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pos <songsList.size()-1) {
                    pos++;
                    Songs nextArray = songsList.get(pos);
                    titleTextView.setText(nextArray.getSongName());
                    artistTextView.setText(nextArray.getArtistName());
                    genreTextView.setText(nextArray.getGenre());
                }

                Log.i("Position: ", Integer.toString(pos));
            }

        });
    }
}
