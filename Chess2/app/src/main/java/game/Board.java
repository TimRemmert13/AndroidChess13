package game;

import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import pieces.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.timremmert.chess.R;


/**
 * Class to represent the board of a chess game.
 * @author Tim Remmert
 *
 */
public class Board {
    /**
     * This is a 8x8 2D array of tiles to represent the actual
     * board the game is played on
     */
    Tile[][] board;
    /**
     * A hash map to translate a tiles String coordinate second value
     * to the integer value of its column in the 2D array
     */
    private static final Map<Character,Integer> columns = buildColumnsMap();
    /**
     * A hash map to translate a tiles string coordinate first value to
     * the integer value of its row in the 2D array
     */
    private static final Map<Character,Integer> rows = buildRowsMap();
    /**
     * The player with the black pieces
     */
    final Player black = new Player("black");
    /**
     * The player with the with pieces
     */
    final Player white = new Player("white");

    /**
     * initializes the board to the starting position of all pieces
     * @param x This is the number of rows and it will always be 8
     * @param y This is the number of columns and it will always be 8
     */
    public Board(int x, int y){
        this.board = new Tile[x][y];

        //create black pieces
        Piece lbR = new Rook("bR", black);
        Piece lbN = new Knight("bN", black);
        Piece lbB = new Bishop("bB", black);
        Piece bQ = new Queen("bQ", black);
        Piece bK = new King("bK", black);
        Piece rbB = new Bishop("bB", black);
        Piece rbN = new Knight("bN", black);
        Piece rbR = new Rook("bR", black);
        Piece bp1 = new Pawn("bp", black);
        Piece bp2 = new Pawn("bp", black);
        Piece bp3 = new Pawn("bp", black);
        Piece bp4 = new Pawn("bp", black);
        Piece bp5 = new Pawn("bp", black);
        Piece bp6 = new Pawn("bp", black);
        Piece bp7 = new Pawn("bp", black);
        Piece bp8 = new Pawn("bp", black);

        //create white pieces
        Piece lwR = new Rook("wR", white);
        Piece lwN = new Knight("wN", white);
        Piece lwB = new Bishop("wB", white);
        Piece wQ = new Queen("wQ", white);
        Piece wK = new King("wK", white);
        Piece rwB = new Bishop("wB", white);
        Piece rwN = new Knight("wN", white);
        Piece rwR = new Rook("wR", white);
        Piece wp1 = new Pawn("wp", white);
        Piece wp2 = new Pawn("wp", white);
        Piece wp3 = new Pawn("wp", white);
        Piece wp4 = new Pawn("wp", white);
        Piece wp5 = new Pawn("wp", white);
        Piece wp6 = new Pawn("wp", white);
        Piece wp7 = new Pawn("wp", white);
        Piece wp8 = new Pawn("wp", white);

        //create occupied tiles black
        Tile a8 = new Tile.OccupiedTile("a8",lbR);
        Tile b8 = new Tile.OccupiedTile("b8",lbN);
        Tile c8 = new Tile.OccupiedTile("c8",lbB);
        Tile d8 = new Tile.OccupiedTile("d8",bQ);
        Tile e8 = new Tile.OccupiedTile("e8",bK);
        Tile f8 = new Tile.OccupiedTile("f8",rbB);
        Tile g8 = new Tile.OccupiedTile("g8",rbN);
        Tile h8 = new Tile.OccupiedTile("h8",rbR);
        Tile a7 = new Tile.OccupiedTile("a7", bp1);
        Tile b7 = new Tile.OccupiedTile("b7", bp2);
        Tile c7 = new Tile.OccupiedTile("c7", bp3);
        Tile d7 = new Tile.OccupiedTile("d7", bp4);
        Tile e7 = new Tile.OccupiedTile("e7", bp5);
        Tile f7 = new Tile.OccupiedTile("f7", bp6);
        Tile g7 = new Tile.OccupiedTile("g7", bp7);
        Tile h7 = new Tile.OccupiedTile("h7", bp8);

        //create empty tiles in the middle row 3
        Tile a3 = new Tile.EmptyTile("a3");
        Tile b3 = new Tile.EmptyTile("b3");
        Tile c3 = new Tile.EmptyTile("c3");
        Tile d3 = new Tile.EmptyTile("d3");
        Tile e3 = new Tile.EmptyTile("e3");
        Tile f3 = new Tile.EmptyTile("f3");
        Tile g3 = new Tile.EmptyTile("g3");
        Tile h3 = new Tile.EmptyTile("h3");
        //row 4
        Tile a4 = new Tile.EmptyTile("a4");
        Tile b4 = new Tile.EmptyTile("b4");
        Tile c4 = new Tile.EmptyTile("c4");
        Tile d4 = new Tile.EmptyTile("d4");
        Tile e4 = new Tile.EmptyTile("e4");
        Tile f4 = new Tile.EmptyTile("f4");
        Tile g4 = new Tile.EmptyTile("g4");
        Tile h4 = new Tile.EmptyTile("h4");
        //row 5
        Tile a5 = new Tile.EmptyTile("a5");
        Tile b5 = new Tile.EmptyTile("b5");
        Tile c5 = new Tile.EmptyTile("c5");
        Tile d5 = new Tile.EmptyTile("d5");
        Tile e5 = new Tile.EmptyTile("e5");
        Tile f5 = new Tile.EmptyTile("f5");
        Tile g5 = new Tile.EmptyTile("g5");
        Tile h5 = new Tile.EmptyTile("h5");
        //row 6
        Tile a6 = new Tile.EmptyTile("a6");
        Tile b6 = new Tile.EmptyTile("b6");
        Tile c6 = new Tile.EmptyTile("c6");
        Tile d6 = new Tile.EmptyTile("d6");
        Tile e6 = new Tile.EmptyTile("e6");
        Tile f6 = new Tile.EmptyTile("f6");
        Tile g6 = new Tile.EmptyTile("g6");
        Tile h6 = new Tile.EmptyTile("h6");

        //create white occupied tiles
        Tile a1 = new Tile.OccupiedTile("a1",lwR);
        Tile b1 = new Tile.OccupiedTile("b1",lwN);
        Tile c1 = new Tile.OccupiedTile("c1",lwB);
        Tile d1 = new Tile.OccupiedTile("d1",wQ);
        Tile e1 = new Tile.OccupiedTile("e1",wK);
        Tile f1 = new Tile.OccupiedTile("f1",rwB);
        Tile g1 = new Tile.OccupiedTile("g1",rwN);
        Tile h1 = new Tile.OccupiedTile("h1",rwR);
        Tile a2 = new Tile.OccupiedTile("a2", wp1);
        Tile b2 = new Tile.OccupiedTile("b2", wp2);
        Tile c2 = new Tile.OccupiedTile("c2", wp3);
        Tile d2 = new Tile.OccupiedTile("d2", wp4);
        Tile e2 = new Tile.OccupiedTile("e2", wp5);
        Tile f2 = new Tile.OccupiedTile("f2", wp6);
        Tile g2 = new Tile.OccupiedTile("g2", wp7);
        Tile h2 = new Tile.OccupiedTile("h2", wp8);

        //initialize board
        //row 8
        this.board[0][0] = a8;
        this.board[0][1] = b8;
        this.board[0][2] = c8;
        this.board[0][3] = d8;
        this.board[0][4] = e8;
        this.board[0][5] = f8;
        this.board[0][6] = g8;
        this.board[0][7] = h8;
        //row 7
        this.board[1][0] = a7;
        this.board[1][1] = b7;
        this.board[1][2] = c7;
        this.board[1][3] = d7;
        this.board[1][4] = e7;
        this.board[1][5] = f7;
        this.board[1][6] = g7;
        this.board[1][7] = h7;
        //row 6
        this.board[2][0] = a6;
        this.board[2][1] = b6;
        this.board[2][2] = c6;
        this.board[2][3] = d6;
        this.board[2][4] = e6;
        this.board[2][5] = f6;
        this.board[2][6] = g6;
        this.board[2][7] = h6;
        //row 5
        this.board[3][0] = a5;
        this.board[3][1] = b5;
        this.board[3][2] = c5;
        this.board[3][3] = d5;
        this.board[3][4] = e5;
        this.board[3][5] = f5;
        this.board[3][6] = g5;
        this.board[3][7] = h5;
        //row 4
        this.board[4][0] = a4;
        this.board[4][1] = b4;
        this.board[4][2] = c4;
        this.board[4][3] = d4;
        this.board[4][4] = e4;
        this.board[4][5] = f4;
        this.board[4][6] = g4;
        this.board[4][7] = h4;
        //row 3
        this.board[5][0] = a3;
        this.board[5][1] = b3;
        this.board[5][2] = c3;
        this.board[5][3] = d3;
        this.board[5][4] = e3;
        this.board[5][5] = f3;
        this.board[5][6] = g3;
        this.board[5][7] = h3;
        //row 2
        this.board[6][0] = a2;
        this.board[6][1] = b2;
        this.board[6][2] = c2;
        this.board[6][3] = d2;
        this.board[6][4] = e2;
        this.board[6][5] = f2;
        this.board[6][6] = g2;
        this.board[6][7] = h2;
        //row 1
        this.board[7][0] = a1;
        this.board[7][1] = b1;
        this.board[7][2] = c1;
        this.board[7][3] = d1;
        this.board[7][4] = e1;
        this.board[7][5] = f1;
        this.board[7][6] = g1;
        this.board[7][7] = h1;

    }
    /**
     * Method to build the hash map for mapping a string to its column location
     * in the board.
     * @return Returns a hash map for mapping a string to its columnn location
     */
    private static Map<Character, Integer> buildColumnsMap(){
        Map<Character,Integer> columnsmap = new HashMap<Character, Integer>();
        //initialize maps
        //columns
        columnsmap.put('a', 0);
        columnsmap.put('b', 1);
        columnsmap.put('c', 2);
        columnsmap.put('d', 3);
        columnsmap.put('e', 4);
        columnsmap.put('f', 5);
        columnsmap.put('g', 6);
        columnsmap.put('h', 7);
        return columnsmap;
    }
    /**
     * Method to build the hash map for mapping a string to its row location
     * in the board
     * @return Returns a hash map for mapping a string to its row location
     */
    private static Map<Character,Integer> buildRowsMap(){
        Map<Character,Integer> rowsMap = new HashMap<Character, Integer>();
        //rows
        rowsMap.put('8',0);
        rowsMap.put('7',1);
        rowsMap.put('6',2);
        rowsMap.put('5',3);
        rowsMap.put('4',4);
        rowsMap.put('3',5);
        rowsMap.put('2',6);
        rowsMap.put('1',7);
        return rowsMap;
    }
    /**
     * Method to end one players turn and begin another's
     */
    public void toogleturns(){
        this.black.toggleTurn();
        this.white.toggleTurn();
    }
    /**
     * Method to map a two letter string to its location in the board
     * @param input This is the string location of the tile
     * @return This is an integer array with the first number being the row location
     * and the second number being the column location
     */
    public int[] map(String input){
        int x, y;
        char column = input.charAt(0);
        char row = input.charAt(1);
        y = this.columns.get(column);
        x = this.rows.get(row);
        int arr[] = {x,y};
        return arr;

    }
    /**
     * Method to check if a given on the board has a piece or not
     * @param x This is the row location of the board
     * @param y This is the column location of the board
     * @return Return true if a piece is on the tile,
     *         and false if there is no piece on the tile.
     */
    public boolean emptyCheck(int x, int y){
        if(this.board[x][y].isEmpty() == true){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Method to get a piece on a tile
     * @param x This is the row location of the tile on the board
     * @param y This is the column location of the tile on the board
     * @return Returns the piece on the tile at the location requested.
     */
    public Piece getPiece(int x, int y){
        return this.board[x][y].getPiece();
    }
    /**
     * Method to return the player a given piece on the board belongs to
     * @param x This is the row location of the piece
     * @param y This is the column location of the piece
     * @return Returns the player the piece at the location belongs to
     */
    public Player getPlayer(int x, int y){
        return this.board[x][y].getPiece().getPlayer();

    }

    /**
     * Method to set a tile of the board to a tile without a piece
     * @param loc This is the location of the piece on the board
     * @return Returns a new empty tile at the requested location
     */
    public Tile setEmptyTile(String loc){
        int[] coordinate = this.map(loc);
        return this.board[coordinate[0]][coordinate[1]] = new Tile.EmptyTile(loc);
    }

    /**
     * Method to set a tile of the board to a tile without a piece
     * @param x This is the row location of the piece
     * @param y This is the column location of the piece
     * @return Returns a new empty tile at the requested location
     */
    public Tile setEmptyTile(int x, int y){
        String c = null;
        String z = null;
        //find column it is in
        switch(x){
            case 0 :
                c = "a";
                break;
            case 1 :
                c = "b";
                break;
            case 2 :
                c = "c";
                break;
            case 3 :
                c = "d";
                break;
            case 4 :
                c = "e";
                break;
            case 5 :
                c = "f";
                break;
            case 6:
                c = "g";
                break;
            case 7:
                c = "h";
                break;
        }
        switch(y){
            case 0 :
                z = "8";
                break;
            case 1 :
                z = "7";
                break;
            case 2 :
                z = "6";
                break;
            case 3 :
                z = "5";
                break;
            case 4 :
                z = "4";
                break;
            case 5 :
                z = "3";
                break;
            case 6:
                z = "2";
                break;
            case 7:
                z = "1";
                break;
        }
        return this.board[x][y] = new Tile.EmptyTile(c+z);
    }
    /**
     * Method to set a tile at a given location to one with the given
     * piece on it.
     * @param p This is the piece to be placed on the tile
     * @param loc This is the location of the tile
     * @return Returns a new tile with the piece on at the requested location
     */
    public Tile setOccuppiedTile(Piece p, String loc){
        int[] coordinate = this.map(loc);
        return this.board[coordinate[0]][coordinate[1]] = new Tile.OccupiedTile(loc, p);
    }
    /**
     * Method to set a tile at a given location to one with the given
     * piece on it.
     * @param p This is the piece to be placed on the tile
     * @param x This is the row location of the tile on the board
     * @param y This is the column location of the tile on the board
     * @return Returns a new tile with the piece on at the requested location
     */
    public Tile setOccuppiedTile(Piece p, int x, int y){
        String c = null;
        String z = null;
        //find column it is in
        switch(x){
            case 0 :
                c = "a";
                break;
            case 1 :
                c = "b";
                break;
            case 2 :
                c = "c";
                break;
            case 3 :
                c = "d";
                break;
            case 4 :
                c = "e";
                break;
            case 5 :
                c = "f";
                break;
            case 6:
                c = "g";
                break;
            case 7:
                c = "h";
                break;
        }
        switch(y){
            case 0 :
                z = "8";
                break;
            case 1 :
                z = "7";
                break;
            case 2 :
                z = "6";
                break;
            case 3 :
                z = "5";
                break;
            case 4 :
                z = "4";
                break;
            case 5 :
                z = "3";
                break;
            case 6:
                z = "2";
                break;
            case 7:
                z = "1";
                break;
        }
        return this.board[x][y] = new Tile.OccupiedTile(c+z, p);
    }
    /**
     * Method to determine if a players king is in check.
     * @param x row location of the player king on the board
     * @param y column location of the players king on the board
     * @return Returns true if the players king is in check
     *         and false if it is not.
     */
    public boolean findCheck(int x, int y){
        //case 1: in check from below
        for(int i = x+1; i < 7; i ++){
            if(this.board[i][y] == null){
                break;
            }
            if(this.board[i][y].isEmpty()){
                continue;
            }
            if(this.board[i][y].getPiece().getPlayer() == this.board[x][y].getPiece().getPlayer()){
                break;
            }
            else if(this.board[i][y].getPiece() instanceof Queen || this.board[i][y].getPiece() instanceof Rook){
                return true;
            }
        }
        //case 2: in check from above
        for(int i = x-1; i > 0 ; i --){
            if(this.board[i][y] == null){
                break;
            }
            if(this.board[i][y].isEmpty()){
                continue;
            }
            if(this.board[i][y].getPiece().getPlayer() == this.board[x][y].getPiece().getPlayer()){
                break;
            }
            else if(this.board[i][y].getPiece() instanceof Queen || this.board[i][y].getPiece() instanceof Rook){
                return true;
            }
        }
        //case 3: in check from the right
        for(int i = y+1; i < 7 ; i ++){
            if(this.board[x][i] == null){
                break;
            }
            if(this.board[x][i].isEmpty()){
                continue;
            }
            if(this.board[x][i].getPiece().getPlayer() == this.board[x][y].getPiece().getPlayer()){
                break;
            }
            else if(this.board[x][i].getPiece() instanceof Queen || this.board[x][i].getPiece() instanceof Rook){
                return true;
            }
        }
        //case 4: in check from the left
        for(int i = y-1; i > 0 ; i --){
            if(this.board[x][i] == null){
                break;
            }
            if(this.board[x][i].isEmpty()){
                continue;
            }
            if(this.board[x][i].getPiece().getPlayer() == this.board[x][y].getPiece().getPlayer()){
                break;
            }
            else if(this.board[x][i].getPiece() instanceof Queen || this.board[x][i].getPiece() instanceof Rook){
                return true;
            }
        }
        //case 5: in check from Pawn
        //if black King
        if(this.board[x][y].getPiece().getPlayer() == this.black){
            if(!this.board[x+1][y+1].isEmpty() && this.board[x+1][y+1].getPiece().getPlayer() != this.black){
                if(this.board[x+1][y+1].getPiece() instanceof Pawn){
                    return true;
                }
            }
            if(this.board[x][y].getPiece().getPlayer() == this.black){
                if(!this.board[x+1][y-1].isEmpty() && this.board[x+1][y-1].getPiece().getPlayer() != this.black){
                    if(this.board[x+1][y-1].getPiece() instanceof Pawn){
                        return true;
                    }
                }
            }
        }
        //if white King
        if(this.board[x][y].getPiece().getPlayer() == this.white){
            if(this.board[x][y].getPiece().getPlayer() == this.black){
                if(!this.board[x-1][y-1].isEmpty() && this.board[x-1][y-1].getPiece().getPlayer() != this.black){
                    if(this.board[x-1][y-1].getPiece() instanceof Pawn){
                        return true;
                    }
                }
            }
            if(this.board[x][y].getPiece().getPlayer() == this.black){
                if(!this.board[x-1][y+1].isEmpty() && this.board[x-1][y+1].getPiece().getPlayer() != this.black){
                    if(this.board[x-1][y+1].getPiece() instanceof Pawn){
                        return true;
                    }
                }
            }
        }
        //case 6: in check diagonally and up to the left
        int i = x -1;
        int k = y -1;
        while(i > 0 && k > 0){
            if(this.board[i][k] == null){
                break;
            }
            if(this.board[i][k].isEmpty()){
                i --;
                k--;
                continue;
            }
            if(this.board[i][k].getPiece().getPlayer() == this.board[x][y].getPiece().getPlayer()){
                break;
            }
            else if(this.board[i][k].getPiece() instanceof Queen || this.board[i][k].getPiece() instanceof Bishop){
                return true;
            }
        }

        //case 7: in check diagonally and up to the right
        i = x-1;
        k = y+1;
        while(i > 0 && k < 7){
            if(this.board[i][k] == null){
                break;
            }
            if(this.board[i][k].isEmpty()){
                i --;
                k ++;
                continue;
            }
            if(this.board[i][k].getPiece().getPlayer() == this.board[x][y].getPiece().getPlayer()){
                break;
            }
            else if(this.board[i][k].getPiece() instanceof Queen || this.board[i][k].getPiece() instanceof Bishop){
                return true;
            }
        }
        //case 8: in check diagonally and down to the left
        i = x+1;
        k = y-1;
        while(i < 7 && k > 0 ){
            if(this.board[i][k] == null){
                break;
            }
            if(this.board[i][k].isEmpty()){
                i ++;
                k --;
                continue;
            }
            if(this.board[i][k].getPiece().getPlayer() == this.board[x][y].getPiece().getPlayer()){
                break;
            }
            else if(this.board[i][k].getPiece() instanceof Queen || this.board[i][k].getPiece() instanceof Bishop){
                return true;
            }
        }
        //case 9: in check diagonally and down to the right
        i = x+1;
        k = y+1;
        while(i < 7 && k < 7){
            if(this.board[i][k] == null){
                break;
            }
            if(this.board[i][k].isEmpty()){
                i ++;
                k ++;
                continue;
            }
            if(this.board[i][k].getPiece().getPlayer() == this.board[x][y].getPiece().getPlayer()){
                break;
            }
            else if(this.board[i][k].getPiece() instanceof Queen || this.board[i][k].getPiece() instanceof Bishop){
                return true;
            }
        }
        return false;
    }
    /**
     * Method to determine if a players king in is check mate
     * @param bK This is an integer array with the first value being the row location
     * of the king on the board, and the second value being the column location of the king
     * on the board
     * @return Returns true if the players king is in check mate
     *         and false if it is not
     */
    public boolean findCheckMate(int[] bK){
        boolean checkBelow = false;
        boolean checkRight = false;
        boolean checkLeft = false;
        boolean checkAbove = false;
        boolean checkSDL = false;
        boolean checkSDR = false;
        boolean checkSUL = false;
        boolean checkSUR = false;
        //check below
        if(bK[0] == 0){
            checkBelow = true;
        }

        else if(!this.board[bK[0]-1][bK[1]].isEmpty()){
            if(this.board[bK[0]-1][bK[1]].getPiece().getPlayer() == this.board[bK[0]][bK[1]].getPiece().getPlayer()){
                checkBelow = true;
            }
        }
        else if(this.board[bK[0]-1][bK[1]].isEmpty()){
            this.board[bK[0]-1][bK[1]] = this.setOccuppiedTile(this.board[bK[0]][bK[1]].getPiece(), bK[0]-1, bK[1]);
            if(findCheck(bK[0]-1, bK[1])){
                checkBelow = true;
                this.board[bK[0]-1][bK[1]] = this.setEmptyTile(bK[0]-1, bK[1]);
            }
            else{
                this.board[bK[0]-1][bK[1]] = this.setEmptyTile(bK[0]-1, bK[1]);
            }
        }
        //check to the right
        if(bK[1] == 7){
            checkRight = true;
        }
        else if(!this.board[bK[0]][bK[1]+1].isEmpty()){
            if(this.board[bK[0]][bK[1]+1].getPiece().getPlayer() == this.board[bK[0]][bK[1]].getPiece().getPlayer()){
                checkRight = true;
            }
        }
        else if(this.board[bK[0]][bK[1]+1].isEmpty()){
            this.board[bK[0]][bK[1]+1] = this.setOccuppiedTile(this.board[bK[0]][bK[1]].getPiece(), bK[0], bK[1]+1);
            if(findCheck(bK[0], bK[1]+1)){
                checkRight = true;
                this.board[bK[0]][bK[1]+1] = this.setEmptyTile(bK[0], bK[1]+1);

            }
            else{
                this.board[bK[0]][bK[1]+1] = this.setEmptyTile(bK[0], bK[1]+1);
            }
        }
        //check to the left
        if(bK[1] == 0){
            checkLeft = true;
        }

        else if(!this.board[bK[0]][bK[1]-1].isEmpty()){
            if(this.board[bK[0]][bK[1]-1].getPiece().getPlayer() == this.board[bK[0]][bK[1]].getPiece().getPlayer()){
                checkLeft = true;
            }
        }
        else if(this.board[bK[0]][bK[1]-1].isEmpty()){
            this.board[bK[0]][bK[1]-1] = this.setOccuppiedTile(this.board[bK[0]][bK[1]].getPiece(), bK[0], bK[1]-1);
            if(findCheck(bK[0], bK[1]-1)){
                checkLeft = true;
                this.board[bK[0]][bK[1]-1] = this.setEmptyTile(bK[0], bK[1]-1);
            }else{
                this.board[bK[0]][bK[1]-1] = this.setEmptyTile(bK[0], bK[1]-1);
            }

        }
        //check to the above
        if(bK[0] == 7){
            checkAbove = true;
        }

        else if(!this.board[bK[0]+1][bK[1]].isEmpty()){
            if(this.board[bK[0]+1][bK[1]].getPiece().getPlayer() == this.board[bK[0]][bK[1]].getPiece().getPlayer()){
                checkAbove = true;
            }
        }
        else if(this.board[bK[0]+1][bK[1]].isEmpty()){
            this.board[bK[0]+1][bK[1]] = this.setOccuppiedTile(this.board[bK[0]][bK[1]].getPiece(), bK[0]+1, bK[1]);
            if(findCheck(bK[0]+1, bK[1])){
                checkAbove = true;
                this.board[bK[0]+1][bK[1]] = this.setEmptyTile(bK[0]+1, bK[1]);
            }else{
                this.board[bK[0]+1][bK[1]] = this.setEmptyTile(bK[0]+1, bK[1]);
            }
        }
        //check to the SDL
        if(bK[1] == 0 || bK[0] == 0){
            checkSDL = true;
        }

        else if(!this.board[bK[0]-1][bK[1]-1].isEmpty()){
            if(this.board[bK[0]-1][bK[1]-1].getPiece().getPlayer() == this.board[bK[0]][bK[1]].getPiece().getPlayer()){
                checkSDL = true;
            }
        }
        else if(this.board[bK[0]-1][bK[1]-1].isEmpty()){
            this.board[bK[0]-1][bK[1]-1] = this.setOccuppiedTile(this.board[bK[0]][bK[1]].getPiece(), bK[0]-1, bK[1]-1);
            if(findCheck(bK[0]-1, bK[1]-1)){
                checkSDL = true;
                this.board[bK[0]-1][bK[1]-1] = this.setEmptyTile(bK[0]-1, bK[1]-1);
            }else{
                this.board[bK[0]-1][bK[1]-1] = this.setEmptyTile(bK[0]-1, bK[1]-1);
            }
        }
        //check to the SDR
        if(bK[0] == 0 || bK[1] == 7){
            checkSDR = true;
        }

        else if(!this.board[bK[0]-1][bK[1]+1].isEmpty()){
            if(this.board[bK[0]-1][bK[1]+1].getPiece().getPlayer() == this.board[bK[0]][bK[1]].getPiece().getPlayer()){
                checkSDR = true;
            }
        }
        else if(this.board[bK[0]-1][bK[1]+1].isEmpty()){
            this.board[bK[0]-1][bK[1]+1] = this.setOccuppiedTile(this.board[bK[0]][bK[1]].getPiece(), bK[0]-1, bK[1]+1);
            if(findCheck(bK[0]-1, bK[1]+1)){
                checkSDR = true;
                this.board[bK[0]-1][bK[1]+1] = this.setEmptyTile(bK[0]-1, bK[1]+1);
            }else{
                this.board[bK[0]-1][bK[1]+1] = this.setEmptyTile(bK[0]-1, bK[1]+1);
            }
        }
        //check to the SUL
        if(bK[0] == 7 || bK[1] == 0){
            checkSUL = true;
        }

        else if(!this.board[bK[0]+1][bK[1]-1].isEmpty()){
            if(this.board[bK[0]+1][bK[1]-1].getPiece().getPlayer() == this.board[bK[0]][bK[1]].getPiece().getPlayer()){
                checkSUL = true;
            }
        }
        else if(this.board[bK[0]+1][bK[1]-1].isEmpty()){
            this.board[bK[0]+1][bK[1]-1] = this.setOccuppiedTile(this.board[bK[0]][bK[1]].getPiece(), bK[0]+1, bK[1]-1);
            if(findCheck(bK[0]+1, bK[1]-1)){
                checkSUL = true;
                this.board[bK[0]+1][bK[1]-1] = this.setEmptyTile(bK[0]+1, bK[1]-1);
            }else{
                this.board[bK[0]+1][bK[1]-1] = this.setEmptyTile(bK[0]+1, bK[1]-1);
            }
        }
        //check SUR
        if(bK[0] == 7 || bK[1] == 7){
            checkSUR = true;
        }

        else if(!this.board[bK[0]+1][bK[1]+1].isEmpty()){
            if(this.board[bK[0]+1][bK[1]+1].getPiece().getPlayer() == this.board[bK[0]][bK[1]].getPiece().getPlayer()){
                checkSUR = true;
            }
        }
        else if(this.board[bK[0]+1][bK[1]+1].isEmpty()){
            this.board[bK[0]+1][bK[1]+1] = this.setOccuppiedTile(this.board[bK[0]][bK[1]].getPiece(), bK[0]+1, bK[1]+1);
            if(findCheck(bK[0]+1, bK[1]+1)){
                checkSUR = true;
                this.board[bK[0]+1][bK[1]+1] = this.setEmptyTile(bK[0]+1, bK[1]+1);
            }else{
                this.board[bK[0]+1][bK[1]+1] = this.setEmptyTile(bK[0]+1, bK[1]+1);
            }
        }
        if(checkBelow && checkAbove && checkRight && checkLeft &&checkSDL && checkSDR
                && checkSUL && checkSUR){
            return true;
        }
        return false;
    }

    /**
     * Method to print to current board according to the assignment guidelines, and the
     * location of each piece.
     */
    public void printBoard(){
        int row = 8;
        for(int i = 0; i < 8; i++){
            for(int k = 0; k < 8; k ++){
                if(this.board[i][k].isEmpty() == false){
                    System.out.print(" " + board[i][k].getPiece()+" ");
                }
                else if(i %2 == 0 && k % 2 == 0 || i % 2 != 0 && k % 2 != 0){
                    System.out.print("    ");
                }
                else if(i % 2 == 0 && k %2 != 0 || i % 2 != 0 && k % 2 == 0){
                    System.out.print(" ## ");
                }
            }
            System.out.print(" "+ row);
            row --;
            System.out.printf("\n");
        }
        System.out.println("  a   b   c   d   e   f   g   h");
    }

}




