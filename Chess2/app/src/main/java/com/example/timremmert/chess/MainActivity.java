package com.example.timremmert.chess;
import android.app.Notification;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.*;
import android.widget.Toast;
import game.*;
import android.widget.Button;


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

    Board board;

    String first_mov;

    String second_mov;

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

        //initialize buttons
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

        undo((Button) findViewById(R.id.undo));

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
                    alert.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface d, int arg){
                                    Toast.makeText(MainActivity.this, "you clicked Ok", Toast.LENGTH_LONG).show();
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
                    alert.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface d, int arg){
                                    Toast.makeText(MainActivity.this, "you clicked Ok", Toast.LENGTH_LONG).show();
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
            public void onClick(View v){
                if(done == false){
                    done = true;
                    first_mov = pos;
                    start = currentButton;
                    System.out.println("first click");
                    return;
                }
                else{
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



}