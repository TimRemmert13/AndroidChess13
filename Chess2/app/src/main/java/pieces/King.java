package pieces;

import game.Player;
import game.Board;
/**
 * Class to represent the King piece in a game of chess
 * @author Tim Remmert
 *
 */
public class King extends Piece{
    /**
     * boolean value to determine if the king has moved yet in the game.
     * moved is false if it has not and true if it has.
     * This is of interest to us because of the rules for castling in chess
     */
    boolean moved = false;
    /**
     * Initializes a King piece with a given String for a name
     * to the given player
     * @param name String that appears on the board
     * @param p Player the piece belongs to
     */
    public King(String name, Player p){
        super(name, p);
    }
    /**
     * Method to set the moved boolean value.
     * This will always set the moved value to true.
     */
    public void setMoved(){
        this.moved = true;
    }
    /**
     * Method to get the current value for the boolean moved
     * field
     */
    public boolean getMoved(){
        return this.moved;
    }
    /**
     * Method to see if a user requested move is a valid move according to the
     * rules of chess for a King piece. This also takes into account the possibility of castling
     */
    @Override
    public boolean validPath(Board board, String s){
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
        }
        //case 5: moving up and to the right
        if(dest[0] == start[0]+1 && dest[1] == start[1] +1){
            if(board.emptyCheck(dest[0], dest[1])){
                return true;
            }
            else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
                return true;
            }
        }
        //case 6: moving up and to the left
        if(dest[0] == start[0]+1 && dest[1] == start[1] -1){
            if(board.emptyCheck(dest[0], dest[1])){
                return true;
            }
            else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
                return true;
            }
        }
        //case 7: moving down and to the right
        if(dest[0] == start[0]-1 && dest[1] == start[1] +1){
            if(board.emptyCheck(dest[0], dest[1])){
                return true;
            }
            else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
                return true;
            }
        }
        //case 8: moving down and to the left
        if(dest[0] == start[0]-1 && dest[1] == start[1] -1){
            if(board.emptyCheck(dest[0], dest[1])){
                return true;
            }
            else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
                return true;
            }
        }
        //case 9: castling request
        if(dest[1] == start[1] +2 || dest[1] == start[1]-2){
            if(!board.findCheck(start[0], start[1])){
                //for black King
                if(start[0] == 0 && start[1] == 4 && this.moved == false){
                    //check moving to the right
                    //check if the tiles are empty
                    if(board.emptyCheck(0, 5) && board.emptyCheck(0, 6)){
                        board.setOccuppiedTile(board.getPiece(start[0], start[1]), "g8");
                        if(!board.findCheck(0, 6)){
                            if(!board.emptyCheck(0, 7)){
                                if(board.getPiece(0, 7) instanceof Rook){
                                    if(board.getPiece(0, 7).getMoved() == false){
                                        board.setOccuppiedTile(board.getPiece(0, 7), "f8");
                                        board.setEmptyTile(0, 7);
                                        return true;
                                    }
                                    else{
                                        board.setEmptyTile("g8");
                                    }
                                }
                                else{
                                    board.setEmptyTile("g8");
                                }
                            }
                            else{
                                board.setEmptyTile("g8");
                            }
                        }
                        else{
                            board.setEmptyTile("g8");
                        }
                    }
                    //check moving to the left
                    if(board.emptyCheck(0, 3) && board.emptyCheck(0, 2) && board.emptyCheck(0, 1)){
                        board.setOccuppiedTile(board.getPiece(start[0], start[1]), "c8");
                        if(!board.findCheck(0, 2)){
                            if(!board.emptyCheck(0, 0)){
                                if(board.getPiece(0, 0) instanceof Rook){
                                    if(board.getPiece(0, 0).getMoved() == false){
                                        board.setOccuppiedTile(board.getPiece(0, 0), "d8");
                                        board.setEmptyTile(0, 0);
                                        return true;
                                    }
                                    else{
                                        board.setEmptyTile("c8");
                                    }
                                }
                                else{
                                    board.setEmptyTile("c8");
                                }
                            }
                            else{
                                board.setEmptyTile("c8");
                            }
                        }
                        else{
                            board.setEmptyTile("c8");
                        }
                    }
                }
                //for white king
                if(start[0] == 7 && start[1] == 4 && this.moved == false){
                    //check moving to the right
                    //check if the tiles are empty
                    if(board.emptyCheck(7, 5) && board.emptyCheck(7, 6)){
                        board.setOccuppiedTile(board.getPiece(start[0], start[1]), "g1");
                        if(!board.findCheck(7, 6)){
                            if(!board.emptyCheck(7, 7)){
                                if(board.getPiece(7, 7) instanceof Rook){
                                    if(board.getPiece(7, 7).getMoved() == false){
                                        board.setOccuppiedTile(board.getPiece(7, 7), "f1");
                                        board.setEmptyTile(7, 7);
                                        return true;
                                    }
                                    else{
                                        board.setEmptyTile("g1");
                                    }
                                }
                                else{
                                    board.setEmptyTile("g1");
                                }
                            }
                            else{
                                board.setEmptyTile("g1");
                            }
                        }
                        else{
                            board.setEmptyTile("g1");
                        }
                    }
                    //check moving to the left
                    if(board.emptyCheck(7, 3) && board.emptyCheck(7, 2) && board.emptyCheck(7, 1)){
                        board.setOccuppiedTile(board.getPiece(start[0], start[1]), "c1");
                        if(!board.findCheck(7, 2)){
                            if(!board.emptyCheck(7, 0)){
                                if(board.getPiece(7, 0) instanceof Rook){
                                    if(board.getPiece(7, 0).getMoved() == false){
                                        board.setOccuppiedTile(board.getPiece(7, 0), "d1");
                                        board.setEmptyTile(7, 0);
                                        return true;
                                    }
                                    else{
                                        board.setEmptyTile("c1");
                                    }
                                }
                                else{
                                    board.setEmptyTile("c1");
                                }
                            }
                            else{
                                board.setEmptyTile("c1");
                            }
                        }
                        else{
                            board.setEmptyTile("c1");
                        }
                    }
                }
            }
        }
        return false;
    }
    /**
     * Method to return either bK for black's king or
     * wK for white's king
     */
    @Override
    public String toString(){
        return getName();
    }

}
