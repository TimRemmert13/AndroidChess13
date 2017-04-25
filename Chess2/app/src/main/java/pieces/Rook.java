package pieces;

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
    /**
     * Method to return bR for black's rook or wR for white's rook.
     */
    @Override
    public String toString(){
        return getName();
    }

}
