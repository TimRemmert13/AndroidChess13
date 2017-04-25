package pieces;

import game.Board;
import game.Player;
import game.Tile;
/**
 * Class to represent the Queen piece in a game of chess
 * @author Tim Remmert
 *
 */
public class Queen extends Piece{
    /**
     * Initializes the piece to have the given string name and
     * which player it belongs to.
     * @param name String that appears on the board
     * @param p Player the piece belongs to
     */
    public Queen(String name, Player p){
        super(name, p);
    }
    /**
     * Method to set the boolean value moved.
     */
    public void setMoved(){

    }
    /**
     * Method to get the current boolean value for moved.
     * This will always return false because we are not concerned with if the
     * queen has moved yet in the game
     */
    public boolean getMoved(){
        return false;
    }
    /**
     * Method to determine is the users requested move is a valid move for a queen piece
     * according to the rules of chess for queen movements.
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
        //case 5: moving diagonally up to the left
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
        //case 6: moving diagonally down to the right
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
        //case 7: moving diagonally down to the left
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
        //case 8: moving diagonally up to the right
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
     * Method return wQ for white's queen and bQ for blacks queen
     */
    @Override
    public String toString(){
        return getName();
    }

}
