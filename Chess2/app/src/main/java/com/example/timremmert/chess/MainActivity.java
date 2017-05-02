package com.example.timremmert.chess;
import android.app.Notification;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.Editable;
import android.widget.ImageButton;
import android.view.*;
import android.widget.Toast;
import game.*;
import android.widget.Button;
import android.widget.LinearLayout;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import android.widget.EditText;
import android.content.Intent;

import java.io.Serializable;
import java.util.ArrayList;
import java.net.MalformedURLException;
import java.util.Random;
import android.content.res.Resources;


import pieces.*;
import android.app.AlertDialog.*;

import static com.example.timremmert.chess.R.drawable.chess_bbishop;
import static com.example.timremmert.chess.R.drawable.chess_bking;
import static com.example.timremmert.chess.R.drawable.chess_bknight;
import static com.example.timremmert.chess.R.drawable.chess_bpawn;
import static com.example.timremmert.chess.R.drawable.chess_bqueen;
import static com.example.timremmert.chess.R.drawable.chess_brook;
import static com.example.timremmert.chess.R.drawable.chess_wbishop;
import static com.example.timremmert.chess.R.drawable.chess_wking;
import static com.example.timremmert.chess.R.drawable.chess_wknight;
import static com.example.timremmert.chess.R.drawable.chess_wpawn;
import static com.example.timremmert.chess.R.drawable.chess_wqueen;
import static com.example.timremmert.chess.R.drawable.chess_wrook;


//commit test
public class MainActivity extends AppCompatActivity {

    boolean done = false;

    boolean wturn = true;

    boolean bturn = false;

    boolean wCheck = false;

    boolean bCheck = false;

    ImageButton start;

    ImageButton finish;

    public static ImageButton a1, b1, c1, d1, e1, f1, g1, h1;
    public static ImageButton a2, b2, c2, d2, e2, f2, g2, h2;
    public static ImageButton a3, b3, c3, d3, e3, f3, g3, h3;
    public static ImageButton a4, b4, c4, d4, e4, f4, g4, h4;
    public static ImageButton a5, b5, c5, d5, e5, f5, g5, h5;
    public static ImageButton a6, b6, c6, d6, e6, f6, g6, h6;
    public static ImageButton a7, b7, c7, d7, e7, f7, g7, h7;
    public static ImageButton a8, b8, c8, d8, e8, f8, g8, h8;

    Board board;

    String first_mov;

    String second_mov;

    public static Game game;

    ArrayList<String> moves = new ArrayList<String>();

    String undo_mov;

    int[] wK = {7, 4};

    int[] bK = {0, 4};

    int sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create board
        Board board = new Board(8, 8);
        this.board = board;
        board.getPlayer(7, 0).toggleTurn();
        setContentView(R.layout.activity_main);

        //initialize Listeners
        clicked("a8", (ImageButton) findViewById(R.id.zerozero));
        clicked("b8", (ImageButton) findViewById(R.id.zeroone));
        clicked("c8", (ImageButton) findViewById(R.id.zerotwo));
        clicked("d8", (ImageButton) findViewById(R.id.zerothree));
        clicked("e8", (ImageButton) findViewById(R.id.zerofour));
        clicked("f8", (ImageButton) findViewById(R.id.zerofive));
        clicked("g8", (ImageButton) findViewById(R.id.zerosix));
        clicked("h8", (ImageButton) findViewById(R.id.zeroseven));
        //second row
        clicked("a7", (ImageButton) findViewById(R.id.onezero));
        clicked("b7", (ImageButton) findViewById(R.id.oneone));
        clicked("c7", (ImageButton) findViewById(R.id.onetwo));
        clicked("d7", (ImageButton) findViewById(R.id.onethree));
        clicked("e7", (ImageButton) findViewById(R.id.onefour));
        clicked("f7", (ImageButton) findViewById(R.id.onefive));
        clicked("g7", (ImageButton) findViewById(R.id.onesix));
        clicked("h7", (ImageButton) findViewById(R.id.oneseven));
        //third row
        clicked("a6", (ImageButton) findViewById(R.id.twozero));
        clicked("b6", (ImageButton) findViewById(R.id.twoone));
        clicked("c6", (ImageButton) findViewById(R.id.twotwo));
        clicked("d6", (ImageButton) findViewById(R.id.twothree));
        clicked("e6", (ImageButton) findViewById(R.id.twofour));
        clicked("f6", (ImageButton) findViewById(R.id.twofive));
        clicked("g6", (ImageButton) findViewById(R.id.twosix));
        clicked("h6", (ImageButton) findViewById(R.id.twoseven));
        //fourth row
        clicked("a5", (ImageButton) findViewById(R.id.threezero));
        clicked("b5", (ImageButton) findViewById(R.id.threeone));
        clicked("c5", (ImageButton) findViewById(R.id.threetwo));
        clicked("d5", (ImageButton) findViewById(R.id.threethree));
        clicked("e5", (ImageButton) findViewById(R.id.threefour));
        clicked("f5", (ImageButton) findViewById(R.id.threefive));
        clicked("g5", (ImageButton) findViewById(R.id.threesix));
        clicked("h5", (ImageButton) findViewById(R.id.threeseven));
        //fifth row
        clicked("a4", (ImageButton) findViewById(R.id.fourzero));
        clicked("b4", (ImageButton) findViewById(R.id.fourone));
        clicked("c4", (ImageButton) findViewById(R.id.fourtwo));
        clicked("d4", (ImageButton) findViewById(R.id.fourthree));
        clicked("e4", (ImageButton) findViewById(R.id.fourfour));
        clicked("f4", (ImageButton) findViewById(R.id.fourfive));
        clicked("g4", (ImageButton) findViewById(R.id.foursix));
        clicked("h4", (ImageButton) findViewById(R.id.fourseven));
        //sixth row
        clicked("a3", (ImageButton) findViewById(R.id.fivezero));
        clicked("b3", (ImageButton) findViewById(R.id.fiveone));
        clicked("c3", (ImageButton) findViewById(R.id.fivetwo));
        clicked("d3", (ImageButton) findViewById(R.id.fivethree));
        clicked("e3", (ImageButton) findViewById(R.id.fivefour));
        clicked("f3", (ImageButton) findViewById(R.id.fivefive));
        clicked("g3", (ImageButton) findViewById(R.id.fivesix));
        clicked("h3", (ImageButton) findViewById(R.id.fiveseven));
        //seventh row
        clicked("a2", (ImageButton) findViewById(R.id.sixzero));
        clicked("b2", (ImageButton) findViewById(R.id.sixone));
        clicked("c2", (ImageButton) findViewById(R.id.sixtwo));
        clicked("d2", (ImageButton) findViewById(R.id.sixthree));
        clicked("e2", (ImageButton) findViewById(R.id.sixfour));
        clicked("f2", (ImageButton) findViewById(R.id.sixfive));
        clicked("g2", (ImageButton) findViewById(R.id.sixsix));
        clicked("h2", (ImageButton) findViewById(R.id.sixseven));
        //eighth row
        clicked("a1", (ImageButton) findViewById(R.id.sevenzero));
        clicked("b1", (ImageButton) findViewById(R.id.sevenone));
        clicked("c1", (ImageButton) findViewById(R.id.seventwo));
        clicked("d1", (ImageButton) findViewById(R.id.seventhree));
        clicked("e1", (ImageButton) findViewById(R.id.sevenfour));
        clicked("f1", (ImageButton) findViewById(R.id.sevenfive));
        clicked("g1", (ImageButton) findViewById(R.id.sevensix));
        clicked("h1", (ImageButton) findViewById(R.id.sevenseven));

        //Initialize buttons
        a8 = (ImageButton) findViewById(R.id.zerozero);
        b8 = (ImageButton) findViewById(R.id.zeroone);
        c8= (ImageButton) findViewById(R.id.zerotwo);
        d8= (ImageButton) findViewById(R.id.zerothree);
        e8 = (ImageButton) findViewById(R.id.zerofour);
        f8 = (ImageButton) findViewById(R.id.zerofive);
        g8= (ImageButton) findViewById(R.id.zerosix);
        h8 = (ImageButton) findViewById(R.id.zeroseven);
        //second row
        a7 = (ImageButton) findViewById(R.id.onezero);
        b7 = (ImageButton) findViewById(R.id.oneone);
        c7 = (ImageButton) findViewById(R.id.onetwo);
        d7 = (ImageButton) findViewById(R.id.onethree);
        e7 = (ImageButton) findViewById(R.id.onefour);
        f7 = (ImageButton) findViewById(R.id.onefive);
        g7 = (ImageButton) findViewById(R.id.onesix);
        h7= (ImageButton) findViewById(R.id.oneseven);
        //third row
        a6 = (ImageButton) findViewById(R.id.twozero);
        b6 = (ImageButton) findViewById(R.id.twoone);
        c6 = (ImageButton) findViewById(R.id.twotwo);
        d6 = (ImageButton) findViewById(R.id.twothree);
        e6 = (ImageButton) findViewById(R.id.twofour);
        f6 = (ImageButton) findViewById(R.id.twofive);
        g6 = (ImageButton) findViewById(R.id.twosix);
        h6 = (ImageButton) findViewById(R.id.twoseven);
        //fourth row
        a5 = (ImageButton) findViewById(R.id.threezero);
        b5 = (ImageButton) findViewById(R.id.threeone);
        c5 = (ImageButton) findViewById(R.id.threetwo);
        d5 = (ImageButton) findViewById(R.id.threethree);
        e5 = (ImageButton) findViewById(R.id.threefour);
        f5 = (ImageButton) findViewById(R.id.threefive);
        g5 = (ImageButton) findViewById(R.id.threesix);
        h5 = (ImageButton) findViewById(R.id.threeseven);
        //fifth row
        a4 = (ImageButton) findViewById(R.id.fourzero);
        b4  = (ImageButton) findViewById(R.id.fourone);
        c4 = (ImageButton) findViewById(R.id.fourtwo);
        d4 = (ImageButton) findViewById(R.id.fourthree);
        e4 = (ImageButton) findViewById(R.id.fourfour);
        f4 = (ImageButton) findViewById(R.id.fourfive);
        g4 = (ImageButton) findViewById(R.id.foursix);
        h4 = (ImageButton) findViewById(R.id.fourseven);
        //sixth row
        a3 = (ImageButton) findViewById(R.id.fivezero);
        b3 = (ImageButton) findViewById(R.id.fiveone);
        c3  = (ImageButton) findViewById(R.id.fivetwo);
        d3  = (ImageButton) findViewById(R.id.fivethree);
        e3  = (ImageButton) findViewById(R.id.fivefour);
        f3  = (ImageButton) findViewById(R.id.fivefive);
        g3 = (ImageButton) findViewById(R.id.fivesix);
        h3  = (ImageButton) findViewById(R.id.fiveseven);
        //seventh row
        a2 = (ImageButton) findViewById(R.id.sixzero);
        b2 = (ImageButton) findViewById(R.id.sixone);
        c2 = (ImageButton) findViewById(R.id.sixtwo);
        d2= (ImageButton) findViewById(R.id.sixthree);
        e2 = (ImageButton) findViewById(R.id.sixfour);
        f2 = (ImageButton) findViewById(R.id.sixfive);
        g2 = (ImageButton) findViewById(R.id.sixsix);
        h2= (ImageButton) findViewById(R.id.sixseven);
        //eigth row
        a1 = (ImageButton) findViewById(R.id.sevenzero);
        b1 = (ImageButton) findViewById(R.id.sevenone);
        c1 = (ImageButton) findViewById(R.id.seventwo);
        d1 = (ImageButton) findViewById(R.id.seventhree);
        e1 = (ImageButton) findViewById(R.id.sevenfour);
        f1= (ImageButton) findViewById(R.id.sevenfive);
        g1= (ImageButton) findViewById(R.id.sevensix);
        h1= (ImageButton) findViewById(R.id.threeseven);


        undo((Button) findViewById(R.id.undo));

        ai((Button) findViewById(R.id.ai));

        resign((Button) findViewById(R.id.resign));

        draw((Button) findViewById(R.id.draw));

    }


    public void setImage(int start, int dest, ImageButton image){
        String actual = board.getPiece(start, dest).getName();
        switch(actual){
            case "wK" :
                image.setImageResource(chess_wking);
                break;
            case "bK" :
                image.setImageResource(chess_bking);
                break;
            case "wQ" :
                image.setImageResource(chess_wqueen);
                break;
            case "bQ" :
                image.setImageResource(chess_bqueen);
                break;
            case "wB" :
                image.setImageResource(chess_wbishop);
                break;
            case "bB" :
                image.setImageResource(chess_bbishop);
                break;
            case "wN" :
                image.setImageResource(chess_wknight);
                break;
            case "bN" :
                image.setImageResource(chess_bknight);
                break;
            case "wR" :
                image.setImageResource(chess_wrook);
                break;
            case "bR" :
                image.setImageResource(chess_brook);
                break;
            case "wp" :
                image.setImageResource(chess_wpawn);
                break;
            case "bp" :
                image.setImageResource(chess_bpawn);
                break;
        }
    }

    private void reset(){
        Board board = new Board(8, 8);
        this.board = board;
        board.getPlayer(7, 0).toggleTurn();
        start = null;
        finish = null;
        wturn = true;
        bturn = false;
        setContentView(R.layout.activity_main);
        moves = null;
    }

    public void clearImage(ImageButton image){
        image.setImageDrawable(image.getBackground());
    }

    public void move(String first_mov, String second_mov, ImageButton start, ImageButton finish) {
        if (wturn) {
            if (board.findCheck(wK[0], wK[1])) {
                if (board.findCheckMate(wK)) {
                    //put notification here
                    AlertDialog.Builder alert = new AlertDialog.Builder(this);
                    alert.setMessage("Checkmate! White wins!");
                    final EditText input = new EditText(this);
                    input.setHint("Game title");
                    alert.setTitle("Checkmate!");
                    alert.setMessage("Would you like to save this game?");
                    alert.setView(input);
                    alert.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface d, int arg){
                                    String title = input.getText().toString();
                                    Game game = new Game(moves,title);
                                    Intent intent = new Intent(MainActivity.this, base.class);
                                    intent.putExtra("GAME", game);
                                    startActivity(intent);
                                }
                            });
                    alert.setNegativeButton("No",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            reset();
                            finish();
                        }
                    });
                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                    return;
                } else {
                    //put notification here
                    Toast.makeText(MainActivity.this, "Check!", Toast.LENGTH_LONG).show();
                    System.out.println("Check");
                    System.out.println();
                    wCheck = true;
                }
            }
            System.out.println("white's turn");
            wturn = false;
            bturn = true;
        } else if (bturn) {
            if (board.findCheck(bK[0], bK[1])) {
                if (board.findCheckMate(bK)) {
                    //put notification here
                    AlertDialog.Builder alert = new AlertDialog.Builder(this);
                    alert.setMessage("Checkmate! White wins!");
                    final EditText input = new EditText(this);
                    input.setHint("Game title");
                    alert.setTitle("Checkmate!");
                    alert.setMessage("Would you like to save this game?");
                    alert.setView(input);
                    alert.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface d, int arg){
                                    String title = input.getText().toString();
                                    Game game = new Game(moves,title);
                                    Intent intent = new Intent(MainActivity.this, base.class);
                                    intent.putExtra("GAME", game);
                                    startActivity(intent);
                                }
                            });
                            alert.setNegativeButton("No",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            reset();
                            finish();
                        }
                    });
                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                    return;
                } else {
                    //put notification here
                    Toast.makeText(MainActivity.this, "Check!", Toast.LENGTH_LONG).show();
                    System.out.println("Check");
                    System.out.println();
                    bCheck = true;
                }
            }
            System.out.println("black's turn");
            wturn = true;
            bturn = false;
        }
        String move = first_mov + " " + second_mov;
        int piece[] = board.map(move);
        if (!board.getPlayer(piece[0], piece[1]).getTurn()) {
            //put toast here
            Toast.makeText(MainActivity.this, "It's not your turn", Toast.LENGTH_LONG).show();
            System.out.println("It's not your turn");
            System.out.println();
            if (bturn) {
                bturn = false;
                wturn = true;
            } else {
                bturn = true;
                wturn = false;
            }
            return;
        }

        if (board.getPiece(piece[0], piece[1]).validPath(board, move)) {
            int dest[] = board.map(move.substring(3, 5));
            boolean empty = false;
            Piece temp = null;
            if (board.emptyCheck(dest[0], dest[1])) {
                empty = true;
            }
            else{
                temp = board.getPiece(dest[0], dest[1]);
            }
            if (board.getPiece(piece[0], piece[1]) instanceof King) {
                board.getPiece(piece[0], piece[1]).setMoved();
            }
            if (board.getPiece(piece[0], piece[1]) instanceof Rook) {
                board.getPiece(piece[0], piece[1]).setMoved();
            }
            //update image here
            setImage(piece[0], piece[1], finish);
            clearImage(start);
            String save = first_mov + " " + second_mov;
            moves.add(save);
            System.out.println("reset");
            board.setOccuppiedTile(board.getPiece(piece[0], piece[1]), move.substring(3, 5));
            board.setEmptyTile(move.substring(0, 2));
            //check Promotion
            if (board.getPiece(dest[0], dest[1]) instanceof Pawn) {
                if (board.getPlayer(dest[0], dest[1]).getColor() == "white") {
                    if (dest[0] == 0) {
                        // need to update image here
                        Piece q2 = new Queen("wQ", board.getPlayer(dest[0], dest[1]));
                        board.setOccuppiedTile(q2, dest[0], dest[1]);
                        setImage(dest[0], dest[1], finish);
                    }
                } else if (board.getPlayer(dest[0], dest[1]).getColor() == "black") {
                    if (dest[0] == 7) {
                        //need to update image here
                        Piece q3 = new Queen("bQ", board.getPlayer(dest[0], dest[1]));
                        board.setOccuppiedTile(q3, dest[0], dest[1]);
                        setImage(dest[0], dest[1], finish);
                    }
                }
            }
            if(dest[0] == wK[0] && dest[1] == wK[1]){
                wK = board.map(move.substring(3,5));
            }
            if(dest[0] == bK[0] && dest[1] == bK[1]){
                bK = board.map(move.substring(3,5));
            }
            if (bCheck) {
                boolean bkingmov = false;
                boolean wkingmov = false;
                if (dest[0] == wK[0] && dest[1] == wK[1]) {
                    wK = board.map(move.substring(3, 5));
                    wkingmov = true;
                }
                if (dest[0] == bK[0] && dest[1] == bK[1]) {
                    bK = board.map(move.substring(3, 5));
                    bkingmov = true;
                }
                if (board.findCheck(bK[0], bK[1])) {
                    board.setOccuppiedTile(board.getPiece(dest[0], dest[1]), move.substring(0, 2));
                    if (empty) {
                        board.setEmptyTile(dest[0], dest[1]);
                    } else {
                        board.setOccuppiedTile(temp, dest[0], dest[1]);
                    }
                    if (wkingmov) {
                        wK = piece;
                    }
                    if (bkingmov) {
                        bK = piece;
                    }
                    else{
                        setImage(piece[0], piece[1], finish);
                        clearImage(start);
                    }
                    //put notification here
                    Toast.makeText(MainActivity.this,"Illegal move, try again", Toast.LENGTH_LONG).show();
                    System.out.println("Illegal move, try again");
                    System.out.println();
                    if (bturn) {
                        bturn = false;
                        wturn = true;
                    } else {
                        bturn = true;
                        wturn = false;
                    }
                    return;
                } else {
                    bCheck = false;
                    setImage(piece[0], piece[1], finish);
                    clearImage(start);
                }

            }
            if (wCheck) {
                boolean bkingmov = false;
                boolean wkingmov = false;
                if (piece[0] == wK[0] && piece[1] == wK[1]) {
                    wK = board.map(move.substring(3, 5));
                    wkingmov = true;
                }
                if (piece[0] == bK[0] && piece[1] == bK[1]) {
                    bK = board.map(move.substring(3, 5));
                    bkingmov = true;
                }
                if (board.findCheck(wK[0], wK[1])) {
                    board.setOccuppiedTile(board.getPiece(dest[0], dest[1]), move.substring(0, 2));
                    if (empty) {
                        board.setEmptyTile(move.substring(3, 5));
                    } else {
                        board.setOccuppiedTile(temp, move.substring(3, 5));
                    }
                    if (wkingmov) {
                        wK = piece;
                    }
                    if (bkingmov) {
                        bK = dest;
                    }
                    //put notification or toast here
                    Toast.makeText(MainActivity.this,"Illegal move, try again", Toast.LENGTH_LONG).show();
                    System.out.println("Illegal move, try again");
                    System.out.println();
                    if (bturn) {
                        bturn = false;
                        wturn = true;
                    } else {
                        bturn = true;
                        wturn = false;
                    }
                    return;
                } else {
                    wCheck = false;
                    setImage(piece[0], piece[1], finish);
                    clearImage(start);
                }
            }
        } else {
            //put notification here
            Toast.makeText(MainActivity.this,"Illegal move, try again", Toast.LENGTH_LONG).show();
            System.out.println("Illegal move, try again");
            System.out.println();
            if (bturn) {
                bturn = false;
                wturn = true;
            } else {
                bturn = true;
                wturn = false;
            }
            return;
        }
        board.toogleturns();
    }

    public void clicked(final String pos, final ImageButton currentButton) {

        currentButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (done == false) {
                    done = true;
                    first_mov = pos;
                    start = currentButton;
                    System.out.println("first click");
                    return;
                } else {
                    second_mov = pos;
                    done = false;
                    finish = currentButton;
                    System.out.println("second click");
                    System.out.println(first_mov + " " + second_mov);
                    undo_mov = second_mov + " " + first_mov;
                    move(first_mov, second_mov, start, finish);
                }

            }
        });
    }


    public void resign(final Button button){
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if(wturn){
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setMessage("Black wins!");
                    final EditText input = new EditText(MainActivity.this);
                    input.setHint("Game title");
                    alert.setTitle("You have Resigned");
                    alert.setMessage("Would you like to save this game?");
                    alert.setView(input);
                    alert.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface d, int arg){
                                    String title = input.getText().toString();
                                    Game game = new Game(moves,title);
                                    Intent intent = new Intent(MainActivity.this, base.class);
                                    intent.putExtra("GAME", game);
                                    startActivity(intent);
                                }
                            });
                    alert.setNegativeButton("No",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            reset();
                            finish();
                        }
                    });
                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();

                }else{
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setMessage("White wins!");
                    final EditText input = new EditText(MainActivity.this);
                    input.setHint("Game title");
                    alert.setTitle("You have Resigned");
                    alert.setMessage("Would you like to save this game?");
                    alert.setView(input);
                    alert.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface d, int arg){
                                    String title = input.getText().toString();
                                    Game game = new Game(moves,title);
                                    Intent intent = new Intent(MainActivity.this, base.class);
                                    intent.putExtra("GAME", game);
                                    startActivity(intent);
                                }
                            });
                    alert.setNegativeButton("No",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            reset();
                            finish();
                        }
                    });
                }
            }
        });
    }

    public void draw(final Button button){
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if(bturn){
                    Toast.makeText(MainActivity.this, "Black wants to draw", Toast.LENGTH_LONG).show();
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setMessage("Black wants to draw. Draw?");
                    alert.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface d, int arg){
                                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                                    alert.setMessage("Draw!");
                                    final EditText input = new EditText(MainActivity.this);
                                    input.setHint("Game title");
                                    alert.setTitle("It's a Draw!");
                                    alert.setMessage("Would you like to save this game?");
                                    alert.setView(input);
                                    alert.setPositiveButton("Ok",
                                            new DialogInterface.OnClickListener(){
                                                @Override
                                                public void onClick(DialogInterface d, int arg){
                                                    String title = input.getText().toString();
                                                    Game game = new Game(moves,title);
                                                    Intent intent = new Intent(MainActivity.this, base.class);
                                                    intent.putExtra("GAME", game);
                                                    startActivity(intent);
                                                }
                                            });
                                    alert.setNegativeButton("No",new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            reset();
                                            finish();
                                        }
                                    });
                                    AlertDialog alertDialog = alert.create();
                                    alertDialog.show();
                                }
                            });
                    alert.setNegativeButton("No",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "you clicked No, Game Resume", Toast.LENGTH_LONG).show();
                        }
                    });
                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();

                }else{
                    Toast.makeText(MainActivity.this, "White wants to draw", Toast.LENGTH_LONG).show();
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setMessage("White wants to draw. Draw?");
                    alert.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface d, int arg){
                                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                                    alert.setMessage("Draw!");
                                    final EditText input = new EditText(MainActivity.this);
                                    input.setHint("Game title");
                                    alert.setTitle("Its a Draw");
                                    alert.setMessage("Would you like to save this game?");
                                    alert.setView(input);
                                    alert.setPositiveButton("Ok",
                                            new DialogInterface.OnClickListener(){
                                                @Override
                                                public void onClick(DialogInterface d, int arg){
                                                    String title = input.getText().toString();
                                                    Game game = new Game(moves,title);
                                                    Intent intent = new Intent(MainActivity.this, base.class);
                                                    intent.putExtra("GAME", game);
                                                    startActivity(intent);
                                                }
                                            });
                                    alert.setNegativeButton("No",new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            reset();
                                            finish();
                                        }
                                    });
                                    AlertDialog alertDialog = alert.create();
                                    alertDialog.show();
                                }
                            });
                    alert.setNegativeButton("No",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "you clicked No, Game Resume", Toast.LENGTH_LONG).show();
                        }
                    });
                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();

                }


            }
        });

    }

    public void undo(final Button button){

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                int[] piece = board.map(undo_mov.substring(0,2));
                setImage(piece[0], piece[1], start);
                clearImage(finish);
                Piece temp = board.getPiece(piece[0], piece[1]);
                board.setOccuppiedTile(temp, undo_mov.substring(3,5));
                board.setEmptyTile(piece[0], piece[1]);
                if(wturn){
                    wturn = false;
                    bturn = true;
                    board.toogleturns();
                }
                else if(bturn){
                    bturn = false;
                    wturn = true;
                    board.toogleturns();
                }
            }


        });

    }

    public void ai(final Button button){
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                String a, b, sid;
                String c, d, fid;
                Random rand = new Random();
                boolean moved = false;
                while(!moved) {
                    int x = rand.nextInt(8);
                    int y = rand.nextInt(8);
                    if (bturn) {
                        if((!board.emptyCheck(x,y))) {
                            if (board.getPiece(x, y).getPlayer().getColor() == "black") {
                                Piece p = board.getPiece(x, y);
                                String move = p.randomMove(x, y);
                                if (p.validPath(board, move)) {
                                    String tile = move.substring(3,5);
                                    String empty = move.substring(0,2);
                                    start = findButton(empty);
                                    finish = findButton(tile);
                                    move(empty, tile, start, finish);
                                    break;
                                }
                            }

                        else{
                            continue;
                        }

                        }

                    }
                    if (wturn) {
                        if (!(board.emptyCheck(x, y))){
                            if (board.getPiece(x, y).getPlayer().getColor() == "white") {
                                Piece p = board.getPiece(x, y);
                                String move = p.randomMove(x,y);
                                if(p.validPath(board, move)){
                                    String tile = move.substring(3,5);
                                    String empty = move.substring(0,2);
                                    start = findButton(empty);
                                    finish = findButton(tile);
                                    move(empty, tile, start, finish);
                                    break;
                                }
                            }
                        }
                        else{
                            continue;
                        }
                    }
                }
            }
        });

    }

    public ImageButton findButton(String name){
        ImageButton image = null;
        switch (name){
            case "a1":
                image = a1;
                break;
            case "b1":
                image = b1;
                break;
            case "c1":
                image = c1;
                break;
            case "d1":
                image = d1;
                break;
            case "e1":
                image = e1;
                break;
            case "f1":
                image = f1;
                break;
            case "g1":
                image = g1;
                break;
            case "h1":
                image = h1;
                break;
            case "a2":
                image = a2;
                break;
            case "b2":
                image = b2;
                break;
            case "c2":
                image = c2;
                break;
            case "d2":
                image = d2;
                break;
            case "e2":
                image = e2;
                break;
            case "f2":
                image = f2;
                break;
            case "g2":
                image = g2;
                break;
            case "h2":
                image = h2;
                break;
            case "a3":
                image = a3;
                break;
            case "b3":
                image = b3;
                break;
            case "c3":
                image = c3;
                break;
            case "d3":
                image = d3;
                break;
            case "e3":
                image = e3;
                break;
            case "f3":
                image = f3;
                break;
            case "g3":
                image = g3;
                break;
            case "h3":
                image = h3;
                break;
            case "a4":
                image = a4;
                break;
            case "b4":
                image = b4;
                break;
            case "c4":
                image = c4;
                break;
            case "d4":
                image = d4;
                break;
            case "e4":
                image = e4;
                break;
            case "f4":
                image = f4;
                break;
            case "g4":
                image = g4;
                break;
            case "h4":
                image = h4;
                break;
            case "a5":
                image = a5;
                break;
            case "b5":
                image = b5;
                break;
            case "c5":
                image = c5;
                break;
            case "d5":
                image = d5;
                break;
            case "e5":
                image = e5;
                break;
            case "f5":
                image = f5;
                break;
            case "g5":
                image = g5;
                break;
            case "h5":
                image = h5;
                break;
            case "a6":
                image = a6;
                break;
            case "b6":
                image = b6;
                break;
            case "c6":
                image = c6;
                break;
            case "d6":
                image = d6;
                break;
            case "e6":
                image = e6;
                break;
            case "f6":
                image = f6;
                break;
            case "g6":
                image = g6;
                break;
            case "h6":
                image = h6;
                break;
            case "a7":
                image = a7;
                break;
            case "b7":
                image = b7;
                break;
            case "c7":
                image = c7;
                break;
            case "d7":
                image = d7;
                break;
            case "e7":
                image = e7;
                break;
            case "f7":
                image = f7;
                break;
            case "g7":
                image = g7;
                break;
            case "h7":
                image = h7;
                break;
            case "a8":
                image = a8;
                break;
            case "b8":
                image = b8;
                break;
            case "c8":
                image = c8;
                break;
            case "d8":
                image = d8;
                break;
            case "e8":
                image = e8;
                break;
            case "f8":
                image = f8;
                break;
            case "g8":
                image = g8;
                break;
            case "h8":
                image = h8;
                break;
        }
        return image;
    }
}