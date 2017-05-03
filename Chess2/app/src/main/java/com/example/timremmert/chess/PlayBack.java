package com.example.timremmert.chess;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


import game.Board;
import game.Game;
import pieces.King;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

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


public class PlayBack extends AppCompatActivity {

    ImageButton start;

    boolean wturn = true;

    boolean bturn = false;

    ImageButton finish;

    boolean wCheck;

    boolean bCheck;

    int[] wK = {7, 4};

    int[] bK = {0, 4};

    public static ImageButton a1, b1, c1, d1, e1, f1, g1, h1;
    public static ImageButton a2, b2, c2, d2, e2, f2, g2, h2;
    public static ImageButton a3, b3, c3, d3, e3, f3, g3, h3;
    public static ImageButton a4, b4, c4, d4, e4, f4, g4, h4;
    public static ImageButton a5, b5, c5, d5, e5, f5, g5, h5;
    public static ImageButton a6, b6, c6, d6, e6, f6, g6, h6;
    public static ImageButton a7, b7, c7, d7, e7, f7, g7, h7;
    public static ImageButton a8, b8, c8, d8, e8, f8, g8, h8;

    Board board;

    int movenum = 0;


    public static Game game;

    public static ArrayList<String> moves = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_back);
        Game game = (Game) getIntent().getExtras().get("GAME");
        this.game = game;
        this.moves = game.getMoves();

        Board board = new Board(8,8);

        board.getPlayer(7, 0).toggleTurn();

        this.board = board;

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

        Button next = (Button) findViewById(R.id.nextmove);
        clicked(next);

    }

    private void reset(){
        Board board = new Board(8, 8);
        this.board = board;
        board.getPlayer(7, 0).toggleTurn();
        movenum = 0;
        start = null;
        finish = null;
        wturn = true;
        bturn = false;
        setContentView(R.layout.activity_play_back);
    }

    public void clicked(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(movenum > moves.size()-1){
                    AlertDialog.Builder alert = new AlertDialog.Builder(PlayBack.this);
                    alert.setTitle("End of Play Back");
                    alert.setMessage("Would you like to play it again?");
                    alert.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface d, int arg){
                                    reset();
                                }
                            });
                    alert.setNegativeButton("No",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                    return;
                }
                String move = moves.get(movenum);
                String first = move.substring(0,2);
                String second = move.substring(3,5);
                start = findButton(first);
                finish = findButton(second);
                move(move, start, finish);
                movenum++;
            }
        });
    }

    public void move(String move, ImageButton start, ImageButton finish) {
        if (wturn) {
            if (board.findCheck(wK[0], wK[1])) {
                if (board.findCheckMate(wK)) {
                    Toast.makeText(PlayBack.this, "Checkmate!", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    //put notification here
                    Toast.makeText(PlayBack.this, "Check!", Toast.LENGTH_LONG).show();
                    System.out.println("Check");
                    System.out.println();
                    wCheck = true;
                }
            }
            wturn = false;
            bturn = true;
        } else if (bturn) {
            if (board.findCheck(bK[0], bK[1])) {
                if (board.findCheckMate(bK)) {
                    //put notification here
                    Toast.makeText(PlayBack.this, "Check!", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    //put notification here
                    Toast.makeText(PlayBack.this, "Check!", Toast.LENGTH_LONG).show();
                    bCheck = true;
                }
            }
            System.out.println("black's turn");
            wturn = true;
            bturn = false;
        }
        int piece[] = board.map(move);
        if (!board.getPlayer(piece[0], piece[1]).getTurn()) {
            //put toast here
            Toast.makeText(PlayBack.this, "It's not your turn", Toast.LENGTH_LONG).show();
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
                        wK = dest;
                    }
                    if (bkingmov) {
                        bK = piece;
                    }
                    else{
                        setImage(piece[0], piece[1], finish);
                        clearImage(start);
                    }
                    //put notification here
                    Toast.makeText(PlayBack.this,"Illegal move, try again", Toast.LENGTH_LONG).show();
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
                    Toast.makeText(PlayBack.this,"Illegal move, try again", Toast.LENGTH_LONG).show();
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
            Toast.makeText(PlayBack.this,"Illegal move, try again", Toast.LENGTH_LONG).show();
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

    public void clearImage(ImageButton image){
        image.setImageDrawable(image.getBackground());
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
