package com.example.android.awesomemusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView titles;
    private TextView artists;
    private TextView genre;
    private boolean toast = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // SONGS ON CLICK EVENT
        titlesListener();

        // ARTISTS ON CLICK EVENT
        artistListener();

        // ARTISTS ON CLICK EVENT
        genreListener();

    }

    public void titlesListener(){
        titles = findViewById(R.id.button_songs);

        titles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    titles.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_style_clicked));
                    Thread.sleep(250);
                    Intent i = new Intent(MainActivity.this, SongsActivity.class);
                    i.putExtra("toast", toast);
                    startActivity(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void artistListener(){
        artists = findViewById(R.id.button_artists);
        artists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    artists.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_style_clicked));
                    Thread.sleep(250);
                    Intent i = new Intent(MainActivity.this, ArtistsActivity.class);
                    i.putExtra("toast", toast);
                    startActivity(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void genreListener(){
        genre = findViewById(R.id.button_genre);
        genre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    genre.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_style_clicked));
                    Thread.sleep(250);
                    Intent i = new Intent(MainActivity.this, GenreActivity.class);
                    i.putExtra("toast", toast);
                    startActivity(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
