package com.example.timremmert.chess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.*;
import game.*;
import pieces.*;
//commit test
public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //create board
        Board board = new Board(8,8);

        //connect image button to tiles on the board
        //first row
        board.setImage((ImageButton)findViewById(R.id.zerozero),0,0);
        board.setImage((ImageButton)findViewById(R.id.zeroone),0,1);
        board.setImage((ImageButton)findViewById(R.id.zerotwo),0,2);
        board.setImage((ImageButton)findViewById(R.id.zerothree),0,3);
        board.setImage((ImageButton)findViewById(R.id.zerofour),0,4);
        board.setImage((ImageButton)findViewById(R.id.zerofive),0,5);
        board.setImage((ImageButton)findViewById(R.id.zerosix),0,6);
        board.setImage((ImageButton)findViewById(R.id.zeroseven),0,7);
        //second row
        board.setImage((ImageButton)findViewById(R.id.onezero),1,0);
        board.setImage((ImageButton)findViewById(R.id.oneone),1,1);
        board.setImage((ImageButton)findViewById(R.id.onetwo),1,2);
        board.setImage((ImageButton)findViewById(R.id.onethree),1,3);
        board.setImage((ImageButton)findViewById(R.id.onefour),1,4);
        board.setImage((ImageButton)findViewById(R.id.onefive),1,5);
        board.setImage((ImageButton)findViewById(R.id.onesix),1,6);
        board.setImage((ImageButton)findViewById(R.id.oneseven),1,7);
        //third row
        board.setImage((ImageButton)findViewById(R.id.twozero),2,0);
        board.setImage((ImageButton)findViewById(R.id.twoone),2,1);
        board.setImage((ImageButton)findViewById(R.id.twotwo),2,2);
        board.setImage((ImageButton)findViewById(R.id.twothree),2,3);
        board.setImage((ImageButton)findViewById(R.id.twofour),2,4);
        board.setImage((ImageButton)findViewById(R.id.twofive),2,5);
        board.setImage((ImageButton)findViewById(R.id.twosix),2,6);
        board.setImage((ImageButton)findViewById(R.id.twoseven),2,7);
        //fourth row
        board.setImage((ImageButton)findViewById(R.id.threezero),3,0);
        board.setImage((ImageButton)findViewById(R.id.threeone),3,1);
        board.setImage((ImageButton)findViewById(R.id.threetwo),3,2);
        board.setImage((ImageButton)findViewById(R.id.threethree),3,3);
        board.setImage((ImageButton)findViewById(R.id.threefour),3,4);
        board.setImage((ImageButton)findViewById(R.id.threefive),3,5);
        board.setImage((ImageButton)findViewById(R.id.threesix),3,6);
        board.setImage((ImageButton)findViewById(R.id.threeseven),3,7);
        //fifth row
        board.setImage((ImageButton)findViewById(R.id.fourzero),4,0);
        board.setImage((ImageButton)findViewById(R.id.fourone),4,1);
        board.setImage((ImageButton)findViewById(R.id.fourtwo),4,2);
        board.setImage((ImageButton)findViewById(R.id.fourthree),4,3);
        board.setImage((ImageButton)findViewById(R.id.fourfour),4,4);
        board.setImage((ImageButton)findViewById(R.id.fourfive),4,5);
        board.setImage((ImageButton)findViewById(R.id.foursix),4,6);
        board.setImage((ImageButton)findViewById(R.id.fourseven),4,7);
        //sixth row
        board.setImage((ImageButton)findViewById(R.id.fivezero),5,0);
        board.setImage((ImageButton)findViewById(R.id.fiveone),5,1);
        board.setImage((ImageButton)findViewById(R.id.fivetwo),5,2);
        board.setImage((ImageButton)findViewById(R.id.fivethree),5,3);
        board.setImage((ImageButton)findViewById(R.id.fivefour),5,4);
        board.setImage((ImageButton)findViewById(R.id.fivefive),5,5);
        board.setImage((ImageButton)findViewById(R.id.fivesix),5,6);
        board.setImage((ImageButton)findViewById(R.id.fiveseven),5,7);
        //seventh row
        board.setImage((ImageButton)findViewById(R.id.sixzero),6,0);
        board.setImage((ImageButton)findViewById(R.id.sixone),6,1);
        board.setImage((ImageButton)findViewById(R.id.sixtwo),6,2);
        board.setImage((ImageButton)findViewById(R.id.sixthree),6,3);
        board.setImage((ImageButton)findViewById(R.id.sixfour),6,4);
        board.setImage((ImageButton)findViewById(R.id.sixfive),6,5);
        board.setImage((ImageButton)findViewById(R.id.sixsix),6,6);
        board.setImage((ImageButton)findViewById(R.id.sixseven),6,7);
        //eighth row
        board.setImage((ImageButton)findViewById(R.id.sevenzero),7,0);
        board.setImage((ImageButton)findViewById(R.id.sevenone),7,1);
        board.setImage((ImageButton)findViewById(R.id.seventwo),7,2);
        board.setImage((ImageButton)findViewById(R.id.seventhree),7,3);
        board.setImage((ImageButton)findViewById(R.id.sevenfour),7,4);
        board.setImage((ImageButton)findViewById(R.id.sevenfive),7,5);
        board.setImage((ImageButton)findViewById(R.id.sevensix),7,6);
        board.setImage((ImageButton)findViewById(R.id.sevenseven),7,7);

        setContentView(R.layout.activity_main);
    }

    public View.OnClickListener selected= new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            view.setBackgroundResource(R.color.blue);

        }
    };
}
