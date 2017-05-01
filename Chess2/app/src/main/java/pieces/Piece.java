package pieces;

import game.Player;

import game.Tile;
import game.Board;
/**
 * Piece is an abstract class representing a piece on the chess board. It is
 * implemented by other classes that are types of pieces such
 * as King, Queen, etc.
 * @author Tim Remmert
 *
 */
public abstract class Piece {

    /**
     * String that appears when printing the board to represent the piece.
     * For example, bK represents black's King
     */
    private String name;

    /**
     * The player that the piece belongs to.
     * The player can be either black or white.
     */
    private Player player;

    /**
     * Initializes Piece with a given String for its name
     * and a Player that it belongs to.
     * @param name This is the String to be the Piece's name
     *             it should only be two characters.
     * @param p    This is the Player the piece belong's to, it should
     *             only be either black or white.
     */
    public Piece(String name, Player p){
        this.name = name;
        this.player = p;
    }
    /**
     * Method to set a given piece name to the string parameter
     * @param s This should only be two Characters long denoting the player and
     *          the piece type.
     */
    public void setName(String s){
        this.name = s;
    }
    /**
     * Method to set a given piece Player to the Player parameter
     * @param p - This is the player which the piece belongs to.
     *            It should either be black or white.
     */
    public void setPlayer(Player p){
        this.player = p;
    }
    /**
     * Method to get the name of a Piece
     * @return name This is the name of the Piece
     */
    public String getName(){
        return this.name;
    }
    /**
     * Method to get the Player which the piece belongs to
     * @return player The Player the piece belongs to
     */
    public Player getPlayer(){
        return this.player;
    }
    /**
     * Abstract method to get a boolean value to tell if a piece was moved yet
     * or not in the game.
     * @return Method returns false if the piece has not been moved and true if it has.
     */
    public abstract boolean getMoved();
    /**
     * Method to set the moved value of a piece. If the value if false,
     * it is set to true, and if the value is true it is set to true.
     */
    public abstract void setMoved();
    /**
     * Method to determine if a users requested move is a valid move
     * according to the rules of chess for that given piece
     * @param board This is the board the piece is currently playing on
     * @param input This is the users requested move for the piece
     * @return Returns true if the move is valid or false if it is not
     */
    public abstract boolean validPath(Board board, String input);
    /**
     * Method to set what is returned when a get method is
     * called on the object.
     */
    public abstract String toString();

    public abstract String randomMove(int x, int y);

}
