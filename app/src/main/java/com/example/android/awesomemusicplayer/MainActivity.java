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



    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*mainSongsArray.add(new Songs("Thriller", "Micheal Jackson", "Pop"));
        mainSongsArray.add(new Songs("Bloody roots", "Sepultura", "Heavy Metal"));
        mainSongsArray.add(new Songs("These Are The Days Of Our Lives", "Queen", "Rock"));
        mainSongsArray.add(new Songs("Nie pytaj mnie", "Tomek Lipiński", "Rock"));
        mainSongsArray.add(new Songs("Supergirl", "Anna Naklab feat. Alle Farben & Younotus", "Pop"));
        mainSongsArray.add(new Songs("Enjoy the silence", "Depeche Mode", "Electro Pop"));
        mainSongsArray.add(new Songs("Come with me", "P.Daddy", "Hip-hop"));
        mainSongsArray.add(new Songs("Hurt", "Johnny Cash", "Country"));
        mainSongsArray.add(new Songs("All along the watchtower", "Bob Dylan", "Rock"));
        mainSongsArray.add(new Songs("More Human Than Human", "White Zombie", "Trash Metal"));*/


        // SONGS ON CLICK EVENT
        TextView songs = findViewById(R.id.button_songs);
        songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SongsActivity.class);
                startActivity(i);
            }
        });

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
}
