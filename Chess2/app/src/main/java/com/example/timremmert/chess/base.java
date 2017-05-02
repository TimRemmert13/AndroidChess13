package com.example.timremmert.chess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import game.Game;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import game.Game;

import static com.example.timremmert.chess.R.layout.activity_base;

public class base extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<Game> games = new ArrayList<Game>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_base);

        /*
        try {
            read();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        Game game = (Game) getIntent().getExtras().get("GAME");
        games.add(game);

        ListView listview = (ListView) findViewById(R.id.content);
        ListAdapter adapter = new ListAdapter(this, games);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(base.this);
    }


    private void save(Game game) {
        try {

            FileOutputStream fileOut =
                    new FileOutputStream("game.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(game);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in moves.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void read() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("game.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        boolean done = true;
        games = (ArrayList<Game>) ois.readObject();
        ois.close();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Game game = (Game) parent.getItemAtPosition(position);
        Intent intent = new Intent(base.this, PlayBack.class);
        intent.putExtra("GAME", game);
        startActivity(intent);
    }

}
