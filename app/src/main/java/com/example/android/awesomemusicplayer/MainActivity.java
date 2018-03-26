package com.example.android.awesomemusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Songs[] songsArray = {
            new Songs("Thriller", "Micheal Jackson", "Pop"),
            new Songs("Bloody roots", "Sepultura", "Heavy Metal"),
            new Songs("These Are The Days Of Our Lives", "Queen", "Rock"),
            new Songs("Nie pytaj mnie", "Tomek Lipiński", "Rock"),
            new Songs("Supergirl", "Anna Naklab feat. Alle Farben & Younotus", "Pop"),
            new Songs("Enjoy the silence", "Depeche Mode", "Electro Pop"),
            new Songs("Come with me", "P.Daddy", "Hip-hop"),
            new Songs("Hurt", "Johnny Cash", "Country"),
            new Songs("All along the watchtower", "Bob Dylan", "Rock"),
            new Songs("More Human Than Human", "White Zombie", "Trash Metal")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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
