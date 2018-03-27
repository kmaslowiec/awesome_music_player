package com.example.android.awesomemusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_songs);
        MainActivity app = new MainActivity();

        Songs[] array = app.songsArray;

        ArrayList<Songs> songsArrayList = new ArrayList<>(Arrays.asList(array));

        Collections.sort(songsArrayList, Songs.songNameCompare);

        final SongsAdapter adapter = new SongsAdapter(this, songsArrayList, R.layout.list_title);

        ListView listView = (ListView)  findViewById(R.id.list_songs);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Songs item = (Songs) adapterView.getItemAtPosition(i);


                //final String title = songsArrayList.get(position).getSongName().toString(); ???


                Intent intent = new Intent(SongsActivity.this, PlayerActivity.class);

                startActivity(intent);
            }


        });


    }
}
