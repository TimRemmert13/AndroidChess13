package pieces;

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
    /**
     * Method to return either bN for black's knight or
     * wN for white's knight
     */
    @Override
    public String toString(){
        return getName();
    }

}
