package com.example.timremmert.chess;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.*;
import android.widget.Toast;
import game.*;
import pieces.*;
//commit test
public class MainActivity extends AppCompatActivity {
    int sign;
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

        /*clickChangeColor((ImageButton)findViewById(R.id.zerozero));
        clickChangeColor((ImageButton)findViewById(R.id.zeroone));
        clickChangeColor((ImageButton)findViewById(R.id.zerotwo));
        clickChangeColor((ImageButton)findViewById(R.id.zerothree));
        clickChangeColor((ImageButton)findViewById(R.id.zerofour));
        clickChangeColor((ImageButton)findViewById(R.id.zerofive));
        clickChangeColor((ImageButton)findViewById(R.id.zerosix));
        clickChangeColor((ImageButton)findViewById(R.id.zeroseven));
        //second row
        clickChangeColor((ImageButton)findViewById(R.id.onezero));
        clickChangeColor((ImageButton)findViewById(R.id.oneone));
        clickChangeColor((ImageButton)findViewById(R.id.onetwo));
        clickChangeColor((ImageButton)findViewById(R.id.onethree));
        clickChangeColor((ImageButton)findViewById(R.id.onefour));
        clickChangeColor((ImageButton)findViewById(R.id.onefive));
        clickChangeColor((ImageButton)findViewById(R.id.onesix));
        clickChangeColor((ImageButton)findViewById(R.id.oneseven));
        //third row
        clickChangeColor((ImageButton)findViewById(R.id.twozero));
        clickChangeColor((ImageButton)findViewById(R.id.twoone));
        clickChangeColor((ImageButton)findViewById(R.id.twotwo));
        clickChangeColor((ImageButton)findViewById(R.id.twothree));
        clickChangeColor((ImageButton)findViewById(R.id.twofour));
        clickChangeColor((ImageButton)findViewById(R.id.twofive));
        clickChangeColor((ImageButton)findViewById(R.id.twosix));
        clickChangeColor((ImageButton)findViewById(R.id.twoseven));
        //fourth row
        clickChangeColor((ImageButton)findViewById(R.id.threezero));
        clickChangeColor((ImageButton)findViewById(R.id.threeone));
        clickChangeColor((ImageButton)findViewById(R.id.threetwo));
        clickChangeColor((ImageButton)findViewById(R.id.threethree));
        clickChangeColor((ImageButton)findViewById(R.id.threefour));
        clickChangeColor((ImageButton)findViewById(R.id.threefive));
        clickChangeColor((ImageButton)findViewById(R.id.threesix));
        clickChangeColor((ImageButton)findViewById(R.id.threeseven));
        //fifth row
        clickChangeColor((ImageButton)findViewById(R.id.fourzero));
        clickChangeColor((ImageButton)findViewById(R.id.fourone));
        clickChangeColor((ImageButton)findViewById(R.id.fourtwo));
        clickChangeColor((ImageButton)findViewById(R.id.fourthree));
        clickChangeColor((ImageButton)findViewById(R.id.fourfour));
        clickChangeColor((ImageButton)findViewById(R.id.fourfive));
        clickChangeColor((ImageButton)findViewById(R.id.foursix));
        clickChangeColor((ImageButton)findViewById(R.id.fourseven));
        //sixth row
        clickChangeColor((ImageButton)findViewById(R.id.fivezero));
        clickChangeColor((ImageButton)findViewById(R.id.fiveone));
        clickChangeColor((ImageButton)findViewById(R.id.fivetwo));
        clickChangeColor((ImageButton)findViewById(R.id.fivethree));
        clickChangeColor((ImageButton)findViewById(R.id.fivefour));
        clickChangeColor((ImageButton)findViewById(R.id.fivefive));
        clickChangeColor((ImageButton)findViewById(R.id.fivesix));
        clickChangeColor((ImageButton)findViewById(R.id.fiveseven));
        //seventh row
        clickChangeColor((ImageButton)findViewById(R.id.sixzero));
        clickChangeColor((ImageButton)findViewById(R.id.sixone));
        clickChangeColor((ImageButton)findViewById(R.id.sixtwo));
        clickChangeColor((ImageButton)findViewById(R.id.sixthree));
        clickChangeColor((ImageButton)findViewById(R.id.sixfour));
        clickChangeColor((ImageButton)findViewById(R.id.sixfive));
        clickChangeColor((ImageButton)findViewById(R.id.sixsix));
        clickChangeColor((ImageButton)findViewById(R.id.sixseven));
        //eighth row
        clickChangeColor((ImageButton)findViewById(R.id.sevenzero));
        clickChangeColor((ImageButton)findViewById(R.id.sevenone));
        clickChangeColor((ImageButton)findViewById(R.id.seventwo));
        clickChangeColor((ImageButton)findViewById(R.id.seventhree));
        clickChangeColor((ImageButton)findViewById(R.id.sevenfour));
        clickChangeColor((ImageButton)findViewById(R.id.sevenfive));
        clickChangeColor((ImageButton)findViewById(R.id.sevensix));
        clickChangeColor((ImageButton)findViewById(R.id.sevenseven));*/
       // pawnMove((ImageButton)findViewById(R.id.twozero));
        //ImageButton test = (ImageButton)findViewById(R.id.onezero);
        //clickChangeColor(test);
        //clickChangeColor((ImageButton)findViewById(R.id.twozero));

        setContentView(R.layout.activity_main);



        clickChangeColor((ImageButton)findViewById(R.id.zerozero));
        clickChangeColor((ImageButton)findViewById(R.id.zeroone));
        clickChangeColor((ImageButton)findViewById(R.id.zerotwo));
        clickChangeColor((ImageButton)findViewById(R.id.zerothree));
        clickChangeColor((ImageButton)findViewById(R.id.zerofour));
        clickChangeColor((ImageButton)findViewById(R.id.zerofive));
        clickChangeColor((ImageButton)findViewById(R.id.zerosix));
        clickChangeColor((ImageButton)findViewById(R.id.zeroseven));
        //second row
        clickChangeColor((ImageButton)findViewById(R.id.onezero));
        clickChangeColor((ImageButton)findViewById(R.id.oneone));
        clickChangeColor((ImageButton)findViewById(R.id.onetwo));
        clickChangeColor((ImageButton)findViewById(R.id.onethree));
        clickChangeColor((ImageButton)findViewById(R.id.onefour));
        clickChangeColor((ImageButton)findViewById(R.id.onefive));
        clickChangeColor((ImageButton)findViewById(R.id.onesix));
        clickChangeColor((ImageButton)findViewById(R.id.oneseven));
        //third row
        clickChangeColor((ImageButton)findViewById(R.id.twozero));
        clickChangeColor((ImageButton)findViewById(R.id.twoone));
        clickChangeColor((ImageButton)findViewById(R.id.twotwo));
        clickChangeColor((ImageButton)findViewById(R.id.twothree));
        clickChangeColor((ImageButton)findViewById(R.id.twofour));
        clickChangeColor((ImageButton)findViewById(R.id.twofive));
        clickChangeColor((ImageButton)findViewById(R.id.twosix));
        clickChangeColor((ImageButton)findViewById(R.id.twoseven));
        //fourth row
        clickChangeColor((ImageButton)findViewById(R.id.threezero));
        clickChangeColor((ImageButton)findViewById(R.id.threeone));
        clickChangeColor((ImageButton)findViewById(R.id.threetwo));
        clickChangeColor((ImageButton)findViewById(R.id.threethree));
        clickChangeColor((ImageButton)findViewById(R.id.threefour));
        clickChangeColor((ImageButton)findViewById(R.id.threefive));
        clickChangeColor((ImageButton)findViewById(R.id.threesix));
        clickChangeColor((ImageButton)findViewById(R.id.threeseven));
        //fifth row
        clickChangeColor((ImageButton)findViewById(R.id.fourzero));
        clickChangeColor((ImageButton)findViewById(R.id.fourone));
        clickChangeColor((ImageButton)findViewById(R.id.fourtwo));
        clickChangeColor((ImageButton)findViewById(R.id.fourthree));
        clickChangeColor((ImageButton)findViewById(R.id.fourfour));
        clickChangeColor((ImageButton)findViewById(R.id.fourfive));
        clickChangeColor((ImageButton)findViewById(R.id.foursix));
        clickChangeColor((ImageButton)findViewById(R.id.fourseven));
        //sixth row
        clickChangeColor((ImageButton)findViewById(R.id.fivezero));
        clickChangeColor((ImageButton)findViewById(R.id.fiveone));
        clickChangeColor((ImageButton)findViewById(R.id.fivetwo));
        clickChangeColor((ImageButton)findViewById(R.id.fivethree));
        clickChangeColor((ImageButton)findViewById(R.id.fivefour));
        clickChangeColor((ImageButton)findViewById(R.id.fivefive));
        clickChangeColor((ImageButton)findViewById(R.id.fivesix));
        clickChangeColor((ImageButton)findViewById(R.id.fiveseven));
        //seventh row
        clickChangeColor((ImageButton)findViewById(R.id.sixzero));
        clickChangeColor((ImageButton)findViewById(R.id.sixone));
        clickChangeColor((ImageButton)findViewById(R.id.sixtwo));
        clickChangeColor((ImageButton)findViewById(R.id.sixthree));
        clickChangeColor((ImageButton)findViewById(R.id.sixfour));
        clickChangeColor((ImageButton)findViewById(R.id.sixfive));
        clickChangeColor((ImageButton)findViewById(R.id.sixsix));
        clickChangeColor((ImageButton)findViewById(R.id.sixseven));
        //eighth row
        clickChangeColor((ImageButton)findViewById(R.id.sevenzero));
        clickChangeColor((ImageButton)findViewById(R.id.sevenone));
        clickChangeColor((ImageButton)findViewById(R.id.seventwo));
        clickChangeColor((ImageButton)findViewById(R.id.seventhree));
        clickChangeColor((ImageButton)findViewById(R.id.sevenfour));
        clickChangeColor((ImageButton)findViewById(R.id.sevenfive));
        clickChangeColor((ImageButton)findViewById(R.id.sevensix));
        clickChangeColor((ImageButton)findViewById(R.id.sevenseven));

        //pawnMove((ImageButton)findViewById(R.id.onezero),(ImageButton)findViewById(R.id.twozero));


        //System.out.println((ImageButton)findViewById(R.id.onezero).getDrawable());
        //System.out.println(R.drawable.chess_bpawn);
    }

    public void pawnMove(ImageButton b1, ImageButton b2){
        if(b1.getDrawable() != null) {
            if ((b1.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.chess_bpawn).getConstantState()))) {
                b2.setImageResource(R.drawable.chess_bpawn);
                b1.setImageResource(android.R.color.transparent);
            } else if ((b1.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.chess_wpawn).getConstantState()))) {
                b2.setImageResource(R.drawable.chess_wpawn);
                b1.setImageResource(android.R.color.transparent);
            }
            System.out.println(getResources().getDrawable(R.drawable.chess_bpawn).getConstantState());
            System.out.println(getResources().getDrawable(R.drawable.chess_bking).getConstantState());
        }

    }

    /*public View.OnClickListener selected= new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            view.setBackgroundResource(R.color.blue);

        }
    };*/
    public void clickChangeColor(final ImageButton currentButton) {

        currentButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Toast.makeText(MainActivity.this, "it works",Toast.LENGTH_LONG).show();
                ColorDrawable buttonColor = (ColorDrawable) currentButton.getBackground();
                int colorId = buttonColor.getColor();
                if(colorId == getResources().getColor(R.color.orange)) {
                    sign = 1;
                    currentButton.setBackgroundColor(Color.BLUE);
                }else if(colorId == getResources().getColor(R.color.darkgreen)){
                    sign = 2;
                    currentButton.setBackgroundColor(Color.BLUE);
                }else if(sign == 1) {
                    sign = 0;
                    currentButton.setBackgroundColor(getColor(R.color.orange));
                }else if(sign == 2){
                    sign = 0;
                    currentButton.setBackgroundColor(getColor(R.color.darkgreen));
                }
            }
        });
    }



}
