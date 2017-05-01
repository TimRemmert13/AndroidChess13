package pieces;

import java.util.Random;

import game.Board;
import game.Player;
import game.Tile;
/**
 * Class to represent the Rook piece in a game of chess
 * @author Tim Remmert
 *
 */
public class Rook extends Piece{
    /**
     * value to determine if the piece has moved yet
     * in the game
     */
    boolean moved = false;
    /**
     * Initializes the Rook to have the given string as it's name
     * and the player it belongs to.
     * @param name String that appears on the board
     * @param p Player that the piece belongs to
     */
    public Rook(String name, Player p){
        super(name, p);
    }
    /**
     * Method to set the boolean value moved.
     * This will always set the value to true.
     */
    public void setMoved(){
        this.moved = true;
    }
    /**
     * Method to return the current value of boolean field moved
     */
    public boolean getMoved(){
        return this.moved;
    }
    /**
     * Method to determine if the users requested move is a valid move for the Rook piece according
     * to the rules of chess for Rook movements
     */
    @Override
    public boolean validPath(Board board,String s){
        int start[] = board.map(s.substring(0, 2));
        int dest[] = board.map(s.substring(3,5));
        //case 1: Moving up
        if(start[1] == dest[1] && start[0] > dest[0]){
            int x = start[0] - 1;
            if(dest[0] == x){
                if(board.emptyCheck(x, start[1])){
                    return true;
                }
                else if(board.getPiece(x, start[1]).getPlayer() != this.getPlayer()){
                    return true;
                }
            }
            //not on desired tile yet
            while(x != dest[0]){
                if(!board.emptyCheck(x, dest[1])){
                    return false;
                }
                else{
                    x --;
                }
            }
            //check if this is the tile we want
            if(board.emptyCheck(x, dest[1])){
                return true;
            }
            else if(board.getPiece(x, dest[1]).getPlayer() != this.getPlayer()){
                return true;
            }
        }
        //case 2: Moving down
        if(start[1] == dest[1] && start[0] < dest[0]){
            int x = start[0] +1;
            if(dest[0] == x){
                if(board.emptyCheck(x, start[1])){
                    return true;
                }
                else if(board.getPiece(x, start[1]).getPlayer() != this.getPlayer()){
                    return true;
                }
            }
            //not on desired tile yet
            while(x != dest[0]){
                if(!board.emptyCheck(x, dest[1])){
                    return false;
                }
                else{
                    x ++;
                }
            }
            //check if this is the tile we want
            if(board.emptyCheck(x, dest[1])){
                return true;
            }
            else if(board.getPiece(x, dest[1]).getPlayer() != this.getPlayer()){
                return true;
            }
        }
        //case 3: Moving to the right
        if(start[1] < dest[1] && start[0] == dest[0]){
            int y = start[1] +1;
            if(dest[1] == y){
                if(board.emptyCheck(start[0], y)){
                    return true;
                }
                else if(board.getPiece(start[0], y).getPlayer() != this.getPlayer()){
                    return true;
                }
            }
            //not on desired tile yet
            while(y != dest[1]){
                if(!board.emptyCheck(dest[0], y)){
                    return false;
                }
                else{
                    y ++;
                }
            }
            //check if this is the tile we want
            if(board.emptyCheck(dest[0], y)){
                return true;
            }
            else if(board.getPiece(dest[0], y).getPlayer() != this.getPlayer()){
                return true;
            }
        }
        //case 4: Moving to the left
        if(start[1] > dest[1] && start[0] == dest[0]){
            int y = start[1] -1;
            if(dest[1] == y){
                if(board.emptyCheck(start[0], y)){
                    return true;
                }
                else if(board.getPiece(start[0], y).getPlayer() != this.getPlayer()){
                    return true;
                }
            }
            //not on desired tile yet
            while(y != dest[1]){
                if(!board.emptyCheck(dest[0], y)){
                    return false;
                }
                else{
                    y --;
                }
            }
            //check if this is the tile we want
            if(board.emptyCheck(dest[0], y)){
                return true;
            }
            else if(board.getPiece(dest[0], y).getPlayer() != this.getPlayer()){
                return true;
            }
        }
        return false;
    }

    @Override
    public String randomMove(int x, int y){
        String start = findCoord(x,y);
        Random rand = new Random();
        boolean sat = true;
        while(sat){
            int deter = rand.nextInt(5);
            if(deter == 1){
                if(x == 7){
                    continue;
                }
                else{
                    x++;
                    break;
                }
            }
            if(deter == 2){
                if(y == 7){
                    continue;
                }else{
                    y ++;
                    break;
                }
            }
            if(deter == 3){
                if(x == 0){
                    continue;
                }
                else{
                    x --;
                    break;
                }
            }
            if(deter == 4){
                if(y == 0){
                    continue;
                }
                else{
                    y --;
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
     * Method to return bR for black's rook or wR for white's rook.
     */
    @Override
    public String toString(){
        return getName();
    }

}
