package game;

/**
 * Created by timremmert on 5/2/17.
 */
import java.util.ArrayList;
import java.io.Serializable;

public class Game implements Serializable {

    ArrayList<String> moves;

    String title;

    public Game(ArrayList<String> moves, String title){
        this.moves = moves;
        this.title = title;
    }

    public ArrayList<String> getMoves(){
        return moves;
    }

    public String getTitle(){
        return this.title;
    }
    public String toString(){
        return this.title;
    }

}
