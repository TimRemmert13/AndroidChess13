package pieces;

import java.util.Random;

import game.Board;
import game.Player;
import game.Tile;
/**
 * Class to represent the knight piece in a game of chess
 * @author Tim Remmert
 *
 */
public class Knight extends Piece{
    /**
     * Initializes a Knight piece the given String for a name
     * and the Player it belongs to
     * @param name String that appears on the board
     * @param p Player the piece belongs to
     */
    public Knight(String name, Player p){
        super(name, p);
    }
    /**
     * Method to get boolean moved value.
     * This will always return false because we are not concerned if the
     * knight piece has moved yet in a game.
     */
    public boolean getMoved(){
        return false;
    }
    /**
     * Method to set the boolean moved value
     */
    public void setMoved(){

    }
    /**
     * Checks to see if the users requested move is a valid move for a
     * knight piece according to the rules of chess.
     */
    @Override
    public boolean validPath(Board board,String s){
        int start[] = board.map(s.substring(0, 2));
        int dest[] = board.map(s.substring(3,5));
        //case 1: moving down and to the left
        if(dest[0] == start[0]+2 && dest[1] == start[1] -1){
            if(board.emptyCheck(dest[0], dest[1])){
                return true;
            }
            else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
                return true;
            }
        }
        //case 2: moving down and to the right
        if(dest[0] == start[0]+2 && dest[1] == start[1] +1){
            if(board.emptyCheck(dest[0], dest[1])){
                return true;
            }
            else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
                return true;
            }
        }
        //case 3: moving up and to the left
        if(dest[0] == start[0]-2 && dest[1] == start[1] -1){
            if(board.emptyCheck(dest[0], dest[1])){
                return true;
            }
            else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
                return true;
            }
        }
        //case 4: moving up and to the right
        if(dest[0] == start[0]-2 && dest[1] == start[1] +1){
            if(board.emptyCheck(dest[0], dest[1])){
                return true;
            }
            else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
                return true;
            }
        }
        //case 5: Moving to the left and down
        if(dest[0] == start[0]+1 && dest[1] == start[1] -2){
            if(board.emptyCheck(dest[0], dest[1])){
                return true;
            }
            else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
                return true;
            }
        }
        //case 6: Moving to the right and down
        if(dest[0] == start[0]+1 && dest[1] == start[1] + 2){
            if(board.emptyCheck(dest[0], dest[1])){
                return true;
            }
            else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
                return true;
            }
        }
        //case 7: Moving to the right and up
        if(dest[0] == start[0]-1 && dest[1] == start[1] +2){
            if(board.emptyCheck(dest[0], dest[1])){
                return true;
            }
            else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
                return true;
            }
        }
        //case 8: Moving to the left and up
        if(dest[0] == start[0]-1 && dest[1] == start[1] -2){
            if(board.emptyCheck(dest[0], dest[1])){
                return true;
            }
            else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
                return true;
            }
        }
        return false;
    }
    public String randomMove(int x, int y) {
        String start = findCoord(x,y);
        Random rand = new Random();
        boolean sat = true;
        while (sat) {
            int deter = rand.nextInt(9);
            if (deter == 1) {
                if (x >= 6 || y == 0) {
                    continue;
                } else {
                    x = x +2;
                    y --;
                    break;
                }
            }
            if (deter == 2) {
                if (x >= 6 || y == 7) {
                    continue;
                } else {
                    x = x+2;
                    y++;
                    break;
                }
            }
            if (deter == 3) {
                if (x <= 1 || y == 0) {
                    continue;
                }
                x = x -2;
                y --;
                break;
            }
            if (deter == 4) {
                if (x <= 1 || y ==7) {
                    continue;
                } else {
                    x = x -2;
                    y++;
                    break;
                }
            }
            if (deter == 5) {
                if (x == 7 || y <=1 ) {
                    continue;
                } else {
                    x ++;
                    y = y -2;
                    break;
                }
            }
            if (deter == 6) {
                if (x == 7 && y >=6) {
                    continue;
                } else {
                    x++;
                    y = y + 2;
                    break;
                }
            }
            if (deter == 7) {
                if (x == 0 && y >= 6) {
                    continue;
                } else {
                    x--;
                    y = y + 2;
                    break;
                }
            }
            if (deter == 8) {
                if (x == 0 && y <= 1) {
                    continue;
                } else {
                    x--;
                    y = y - 2;
                    break;
                }
            }

        }
        String dest = findCoord(x,y);
        String move = start + " " + dest;
        return move;
    }

    public String findCoord(int x, int y){
        String c = "a", z = "8";
        switch(y){
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
        switch(x){
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
        String move = c+z;
        return move;
    }
    /**
     * Method to return either bN for black's knight or
     * wN for white's knight
     */
    @Override
    public String toString(){
        return getName();
    }

}
