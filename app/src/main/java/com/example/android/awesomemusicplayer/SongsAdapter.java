package com.example.android.awesomemusicplayer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * At this moment I have no idea what it does :)
 */

public class SongsAdapter extends ArrayAdapter<Songs> {

    private static final String LOG_TAG = SongsAdapter.class.getSimpleName();

    private int listNum;

    public int getListNum() {
        return listNum;
    }



    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param songs A List of AndroidFlavor objects to display in a list
     */

    public SongsAdapter(@NonNull Context context, @NonNull ArrayList<Songs> songs, int listNum) {


        super(context, 0, songs);
        this.listNum = listNum;

    }





    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
// Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    getListNum(), parent, false);
        }

        // Get the {@link Songs} object located at this position in the list
        Songs songs = getItem(position);

        // Find the TextView in the list_title.xmll layout with the ID version_name
        TextView songTextView = listItemView.findViewById(R.id.song_word);
        // set this text on the name TextView



        songTextView.setText(songs.getSongName());



        // Find the TextView in the list_title.xmll layout with the ID version_number
        TextView artistTextView = listItemView.findViewById(R.id.artist_word);
        // set this text on the number TextView
        artistTextView.setText(songs.getArtistName());

        // Find the TextView in the list_title.xmll layout with the ID version_number
        TextView genreTextView = listItemView.findViewById(R.id.genre_word);
        // set this text on the number TextView
        genreTextView.setText(songs.getGenre());

        // THIS WOULD BE WHEN WE ADD THE PIC :)
        //ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        //iconView.setImageResource(songs.getImageResourceId());

        return listItemView;
    }
}
