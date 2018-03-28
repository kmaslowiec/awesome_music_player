package com.example.android.awesomemusicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Bundle title = getIntent().getExtras();

        if(title!=null){
            TextView titleTextView = findViewById(R.id.player_title);
            titleTextView.setText(title.getString("title"));
        }

        if(title!=null){
            TextView artistTextView = findViewById(R.id.player_artist);
            artistTextView.setText(title.getString("artist"));
        }

        if(title!=null){
            TextView genreTextView = findViewById(R.id.player_genre);
            genreTextView.setText(title.getString("genre"));
        }



    }
}
