package game;

/**
 * Created by timremmert on 5/2/17.
 */
import java.util.ArrayList;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Game implements Serializable {

    ArrayList<String> moves;

    String title;

    Date date;

    public Game(ArrayList<String> moves, String title, Date date){
        this.moves = moves;
        this.title = title;
        this.date = date;
    }

    public ArrayList<String> getMoves(){
        return moves;
    }

    public String getTitle(){
        return this.title;
    }

    public Date getDate(){
        return this.date;
    }
    public String toString(){
        return this.title;
    }

}
