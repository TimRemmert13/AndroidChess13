package pieces;

import java.util.Random;

import game.Player;
import game.Board;
import game.Tile;
/**
 * Class to represent the Pawn piece in a game of chess
 * @author Tim Remmert
 *
 */
public class Pawn extends Piece{
    /**
     * Initializes a pawn piece with the given string as a name
     * and the player it belongs to.
     * @param name String that appears on the board
     * @param p Player the piece belongs to
     */
    public Pawn(String name, Player p){
        super(name, p);
    }
    /**
     * Method to set the boolean moved value of the piece
     */
    public void setMoved(){

    }
    /**
     * Method to get the current moved value for the piece.
     * This will always return false because we are not concerned with if the
     * pawn has moved yet in the game.
     */
    public boolean getMoved(){
        return false;
    }
    /**
     * Method to determine if the users requested move is a valid move for the pawn piece
     * according to the rules of chess for a pawns movement.
     */
    @Override
    public boolean validPath(Board board, String input){
        int start[] = board.map(input.substring(0, 2));
        int dest[] = board.map(input.substring(3,5));
        if(this.getPlayer().getColor() == "black"){
            //starting position pawn can jump a space
            if(start[0] == 1){
                if(dest[0] == start[0] +1){
                    if(board.emptyCheck(start[0]+1, start[1])){
                        return true;
                    }
                }
                if(dest[0] == start[0] +2){
                    if(board.emptyCheck(start[0]+1, start[1]) && board.emptyCheck(start[0] +2,  start[1])){
                        return true;
                    }
                    else if(!board.emptyCheck(start[0]+1, start[1]) && board.getPiece(start[0]+1, start[1]).getPlayer()
                            != this.getPlayer()){
                        board.setEmptyTile(start[0] +1, start[1]);
                        return true;
                    }
                }
            }

            // not starting position pawn
            else if (dest[0] == start[0] +1){
                if(board.emptyCheck(start[0]+1, start[1])){
                    return true;
                }
            }
            // taking another players piece
            if(dest[0] == start[0] +1 && dest[1] == start[1]+1){
                if(board.getPlayer(dest[0], dest[1]) != this.getPlayer()){
                    return true;
                }
                else{
                    return false;
                }
            }
            if(dest[0] == start[0] +1 && dest[1] == start[1]-1){
                if(board.getPlayer(dest[0], dest[1]) != this.getPlayer()){
                    return true;
                }
            }

        }
        if(this.getPlayer().getColor() == "white"){
            //starting position pawn can jump a space
            if(start[0] == 6){
                if(dest[0] == start[0] -1){
                    if(board.emptyCheck(start[0]-1, start[1])){
                        return true;
                    }
                }
                else if(dest[0] == start[0] -2){
                    if(board.emptyCheck(start[0]-1, start[1]) && board.emptyCheck(start[0] -2,  start[1])){
                        return true;
                    }
                    else if(!board.emptyCheck(start[0]-1,start[1]) && board.getPiece(start[0] -1, start[1]).getPlayer()
                            != this.getPlayer()){
                        board.setEmptyTile(start[0]-1, start[1]);
                        return true;
                    }
                }
            }
            // not starting position pawn
            else if (dest[0] == start[0] -1){
                if(board.emptyCheck(start[0]-1, start[1])){
                    return true;
                }
            }
            // taking another players piece
            if(dest[0] == start[0] -1 && dest[1] == start[1]-1){
                if(board.getPlayer(dest[0], dest[1]) != this.getPlayer()){
                    return true;
                }
            }
            if(dest[0] == start[0] -1 && dest[1] == start[1]+1){
                if(board.getPlayer(dest[0], dest[1]) != this.getPlayer()){
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public String randomMove(int x, int y){
        String start = findCoord(x,y);
        if(this.getPlayer().getColor() == "black") {
            x ++;
        }
        if(this.getPlayer().getColor() == "white"){
            x --;
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
     * Method returns either bp for black's pawn or wp for whites pawn
     */
    @Override
    public String toString(){
        return getName();
    }

}
