package com.example.android.awesomemusicplayer;

import android.content.Intent;
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
    private TextView songs;
    private TextView artists;
    private TextView genre;
    private ImageView prev;
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
        songsListener();
        artistListener();
        genreListener();

        prev.setImageResource(R.drawable.prev_button64);

    }

    public void initTextViews() {
        titleTextView = findViewById(R.id.player_title);
        artistTextView = findViewById(R.id.player_artist);
        genreTextView = findViewById(R.id.player_genre);
        songs = findViewById(R.id.button_songs_player);
        artists = findViewById(R.id.button_artists_player);
    }

    public void prevListener() {
        prev = findViewById(R.id.prev);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pos > 0) {

                    prev.setImageResource(R.drawable.prev_clicked);

                    pos--;
                    Songs prevArray = songsList.get(pos);
                    titleTextView.setText(prevArray.getSongName());
                    artistTextView.setText(prevArray.getArtistName());
                    genreTextView.setText(prevArray.getGenre());
                }

            }
        });





    }

    public void nextListener() {
        ImageView prev = findViewById(R.id.next);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pos < songsList.size() - 1) {
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

    public void songsListener() {


        songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    songs.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_style_clicked));
                    Thread.sleep(250);
                    Intent i = new Intent(PlayerActivity.this, SongsActivity.class);
                    startActivity(i);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });
    }

    public void artistListener() {

        artists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    artists.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_style_clicked));
                    Thread.sleep(250);
                    Intent i = new Intent(PlayerActivity.this, ArtistsActivity.class);
                    startActivity(i);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public void genreListener() {
        genre = findViewById(R.id.button_genre_player);

        genre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    genre.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_style_clicked));
                    Thread.sleep(250);
                    Intent i = new Intent(PlayerActivity.this, GenreActivity.class);
                    startActivity(i);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
