package com.example.timremmert.chess;

import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import game.Game;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by timremmert on 5/2/17.
 */

public class ListAdapter extends ArrayAdapter {

    ListAdapter(Context context, ArrayList<Game> games){
        super(context, R.layout.costume_row, games);
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customview = inflater.inflate(R.layout.costume_row, parent, false);
        TextView textView = (TextView) customview.findViewById(R.id.title);
        Game game = (Game) getItem(position);
        textView.setText(game.getTitle());
        return customview;
    }
}
