package com.example.android.awesomemusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {



    //ArrayList<Songs> mainSongsArray = new ArrayList<>();
    private TextView songs;
    boolean flagSongButton = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        // SONGS ON CLICK EVENT

        songsListener();

        // ARTISTS ON CLICK EVENT
        TextView artists = findViewById(R.id.button_artists);
        artists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ArtistsActivity.class);
                startActivity(i);
            }
        });

        // ARTISTS ON CLICK EVENT
        TextView genre = findViewById(R.id.button_genre);
        genre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, GenreActivity.class);
                startActivity(i);
            }
        });
    }

    public void songsListener(){
        songs = findViewById(R.id.button_songs);

        songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    songs.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_style_clicked));
                    Thread.sleep(250);
                    Intent i = new Intent(MainActivity.this, SongsActivity.class);
                    startActivity(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
