package pieces;

import game.Player;
import game.Board;
import game.Tile;
/**
 * Class to represent the Bishop piece in a game of chess
 * @author Tim Remmert
 *
 */
public class Bishop extends Piece {
    /**
     * Initializes the piece with the given String for it's name
     * and Player for its Player
     * @param name String that appears on the board
     * @param p Player the piece belongs to
     */
    public Bishop(String name, Player p){
        super(name, p);
    }
    /**
     * Method to get the value currently for boolean moved.
     * This always returns false because we are not concerned with if the bishop
     * has moved yet in the game.
     */
    public boolean getMoved(){
        return false;
    }
    /**
     * Method to set boolean moved to a value.
     */
    public void setMoved(){
    }
    /**
     * ValidPath for bishop checks to see if the users requested move
     * follows the rules in chess for a bishop's piece possible movements
     */
    @Override
    public boolean validPath(Board board, String input){
        int start[] = board.map(input.substring(0, 2));
        int dest[] = board.map(input.substring(3,5));
        //case 1: moving diagonally up to the left
        if(start[0] > dest[0] && start[1] > dest[1]){
            int x = start[0] - 1;
            int y = start[1] - 1;
            if(dest[0] == x && dest[1] == y){
                if(board.emptyCheck(x, y)){
                    return true;
                }
                else if (board.getPiece(x, y).getPlayer() != this.getPlayer()){
                    return true;
                }
            }
            while(x != dest[0] && y != dest[1]){
                //if this is not the desired tile to move to
                if(!board.emptyCheck(x,y)){
                    return false;
                }
                else{
                    x --;
                    y --;
                }
            }
            //if this is the tile we want to move to
            if(board.emptyCheck(x, y)){
                return true;
            }
            else if (board.getPiece(x, y).getPlayer() != this.getPlayer()){
                return true;
            }
        }
        //case 2: moving diagonally down to the right
        if(start[0] < dest[0] && start[1] < dest[1]){
            int x = start[0] + 1;
            int y = start[1] + 1;
            if(dest[0] == x && dest[1] == y){
                if(board.emptyCheck(x, y)){
                    return true;
                }
                else if (board.getPiece(x, y).getPlayer() != this.getPlayer()){
                    return true;
                }
            }
            while(x != dest[0] && y != dest[1]){
                //if this is not the desired tile to move to
                if(!board.emptyCheck(x,y)){
                    return false;
                }
                else{
                    x ++;
                    y ++;
                }
            }
            //if this is the tile we want to move to
            if(board.emptyCheck(x, y)){
                return true;
            }
            else if (board.getPiece(x, y).getPlayer() != this.getPlayer()){
                return true;
            }
        }
        //case 3: moving diagonally down to the left
        if(start[0] < dest[0] && start[1] > dest[1]){
            int x = start[0] + 1;
            int y = start[1] - 1;
            if(dest[0] == x && dest[1] == y){
                if(board.emptyCheck(x, y)){
                    return true;
                }
                else if (board.getPiece(x, y).getPlayer() != this.getPlayer()){
                    return true;
                }
            }
            while(x != dest[0] && y != dest[1]){
                //if this is not the desired tile to move to
                if(!board.emptyCheck(x,y)){
                    return false;
                }
                else{
                    x ++;
                    y --;
                }
            }
            //if this is the tile we want to move to
            if(board.emptyCheck(x, y)){
                return true;
            }
            else if (board.getPiece(x, y).getPlayer() != this.getPlayer()){
                return true;
            }
        }
        //case 4: moving diagonally up to the right
        if(start[0] > dest[0] && start[1] < dest[1]){
            int x = start[0] - 1;
            int y = start[1] + 1;
            if(dest[0] == x && dest[1] == y){
                if(board.emptyCheck(x, y)){
                    return true;
                }
                else if (board.getPiece(x, y).getPlayer() != this.getPlayer()){
                    return true;
                }
            }
            while(x != dest[0] && y != dest[1]){
                //if this is not the desired tile to move to
                if(!board.emptyCheck(x,y)){
                    return false;
                }
                else{
                    x --;
                    y ++;
                }
            }
            //if this is the tile we want to move to
            if(board.emptyCheck(x, y)){
                return true;
            }
            else if (board.getPiece(x, y).getPlayer() != this.getPlayer()){
                return true;
            }
        }
        return false;
    }
    /**
     * Method to return either bB for black's bishop or
     * wB for whites bishop
     */
    @Override
    public String toString(){
        return getName();
    }

}
