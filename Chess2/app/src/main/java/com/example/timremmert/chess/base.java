package com.example.timremmert.chess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import game.Game;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;


import game.Game;

import static com.example.timremmert.chess.R.layout.activity_base;

public class base extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static ArrayList<Game> games = new ArrayList<Game>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_base);

        ListView listview = (ListView) findViewById(R.id.content);

        try {
            read();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (getIntent().getExtras().get("GAME") != null) {
            Game game = (Game) getIntent().getExtras().get("GAME");
            games.add(game);
            save();
        }

        save();
        ArrayAdapter<Game> adapter = new ArrayAdapter<Game>(this,
                android.R.layout.simple_list_item_1, games);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(base.this);


        Button sorttitle = (Button) findViewById(R.id.sortTitle);
        Button sortdate = (Button) findViewById(R.id.sortDate);
        Button newGame = (Button) findViewById(R.id.newGame);

        sorttitle(sorttitle);
        sortdate(sortdate, adapter);
        newGame(newGame);

    }

    public void sorttitle(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(games, new titleSorter());
            }
        });
    }
    public void sortdate(final Button button, final ArrayAdapter<Game> adapter) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Collections.sort(games, new Comparator<Game>() {
                 @Override
                 public int compare(Game o1, Game o2) {
                     return o1.getDate().compareTo(o2.getDate());
                 }
             });
            }
        });
    }


    public void newGame(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(base.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    private void save() {
        try {
            File folder = new File(getFilesDir() + "/sample");
            File file = new File(folder.getAbsolutePath() + "/games.ser");
            if (!folder.exists()) {
                folder.mkdir();
            }
            if(!file.exists()){
                file.createNewFile();
            }
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos); //Select where you wish to save the file...
                oos.writeObject(games);
                System.out.println("saved");// write the class as an 'object'
                oos.flush(); // flush the stream to insure all of the information was written to 'save_object.bin'
                oos.close();// close the

        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void read() throws IOException, ClassNotFoundException {
        File folder = new File(getFilesDir() + "/sample");
        File file = new File(folder.getAbsolutePath() + "/games.ser");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            games = (ArrayList<Game>) ois.readObject();
            ois.close();
            fis.close();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Game game = (Game) parent.getItemAtPosition(position);
        Intent intent = new Intent(base.this, PlayBack.class);
        intent.putExtra("GAME", game);
        startActivity(intent);
    }

    public class dateSorter implements Comparator<Game> {

        @Override
        public int compare(Game o1, Game o2) {
            return o1.getDate().compareTo(o2.getDate());
        }
    }

    public class titleSorter implements Comparator<Game>{
        @Override
        public int compare(Game o1, Game o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }

    }
}
