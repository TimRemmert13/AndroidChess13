package game;
/**
 * Class to represent a player in the chess game
 * @author Tim Remmert
 *
 */
public class Player {
    /**
     * String to show whether a player has the black pieces or
     * the white pieces
     */
    private String color;
    /**
     * Boolean value to show if it is currently
     * a players turn.
     */
    private boolean turn = false;
    /**
     * Initializes a player to have the given color pieces
     * @param color
     */
    public Player(String color){
        this.color = color;
    }
    /**
     * Method to set the players color
     * @param color This should be either "black" or "white"
     */
    public void setColor(String color){
        this.color = color;
    }
    /**
     * Method to return the color of the player
     * @return Should return either "black" or "white"
     */
    public String getColor(){
        return this.color;
    }
    /**
     * Method to see if it is currently the player's turn
     * @return Returns true if its the players turn and false if it is not
     */
    public boolean getTurn(){
        return this.turn;
    }
    /**
     * Method to set the end of one players turn
     * and the beginning of another
     */
    public void toggleTurn(){
        if(this.turn == false){
            this.turn = true;
        }
        else{
            this.turn = false;
        }
    }
    /**
     * Method to return either "black" or "white" depending on the
     * players color of pieces
     */
    public String toString(){
        return this.color;
    }

}

