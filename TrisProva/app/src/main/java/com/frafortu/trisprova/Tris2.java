package com.frafortu.trisprova;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by FortuF100 on 02/02/2018.
 */

public class Tris2 {
    private boolean[] field;
    private Button[] boxes;
    private boolean isPlayer1;
    private Context context;
    public Tris2(Context ctx, Button[] btns) {
        context = ctx;
        boxes = btns;
        field = new boolean[9];
        isPlayer1 = true;//just for start
    }

    public void play() {
        for(int i = 0; i < boxes.length; i++) {
                int pos = i;
                boxes[i].setOnClickListener(event -> {
                    if(! field[pos]) {
                        if(isPlayer1) {
                            boxes[pos].setText("X");
                        } else {
                            boxes[pos].setText("O");
                        }
                        field[pos] = true;
                        if(hasSomeonewon()) {
                            Toast.makeText(context, "Player 1 Wins", Toast.LENGTH_LONG).show();
                            return;
                        }
                        if(isFieldFull()) {
                            Toast.makeText(context, "Tie", Toast.LENGTH_LONG).show();
                            return;
                        }
                        isPlayer1 = !isPlayer1;
                        opponentMove();
                        if(hasSomeonewon()) {
                            Toast.makeText(context, "Player 2 Wins", Toast.LENGTH_LONG).show();
                            return;
                        }
                        if(isFieldFull()) {
                            Toast.makeText(context, "Tie", Toast.LENGTH_LONG).show();
                            return;
                        }
                        isPlayer1 = !isPlayer1;
                    } else {
                        Toast.makeText(context,"Already pressed",Toast.LENGTH_LONG).show();
                    }
                });
        }
    }

    private void opponentMove() {
        Random gen = new Random();
        int pos = gen.nextInt(9);
        if(field[pos]) {
            opponentMove();
        } else {
            field[pos] = true;
            if(isPlayer1)
                boxes[pos].setText("X");
            else boxes[pos].setText("O");
            return;
        }
    }

    private boolean isFieldFull() {
        boolean full = true;
        for (int i = 0; i < field.length; i++)  {
                if(! field[i]) {
                    full = false;
                }
        }
        return full;
    }

    public boolean hasSomeonewon() {
        boolean player1Wins, player2Wins;
        /*
        vertical check
         */
        for(int j = 0; j < 3; j++) {
            player1Wins = true;
            player2Wins = true;
            for (int i = j; i < boxes.length; i += 3) {
                if (!boxes[i].getText().equals("X")) player1Wins = false;
                if (!boxes[i].getText().equals("O")) player2Wins = false;
            }
            if (player1Wins) return true;
            if (player2Wins) return true;
        }
        /*
        horizontal check
         */
        for(int j = 0; j < boxes.length; j+=3) {
            player1Wins = true;
            player2Wins = true;
            for (int i = 0; i < boxes.length; i++) {
                if (!boxes[i].getText().equals("X")) player1Wins = false;
                if (!boxes[i].getText().equals("O")) player2Wins = false;
            }
            if (player1Wins) return true;
            if (player2Wins) return true;
        }
        /*
        oblique check
         */
        player1Wins = true;
        player2Wins = true;
        int i;
        for(i = 0; i < boxes.length; i += 4) {
            if(!boxes[i].getText().equals("X")) player1Wins = false;
            if(!boxes[i].getText().equals("O")) player2Wins = false;
        }
        if (player1Wins) return true;
        if (player2Wins) return true;
        player1Wins = true;
        player2Wins = true;
        for(i = 2; i < boxes.length - 2; i += 2) {
            if(!boxes[i].getText().equals("X")) player1Wins = false;
            if(!boxes[i].getText().equals("O")) player2Wins = false;
        }
        if (player1Wins) return true;
        if (player2Wins) return true;
        return false;
    }
    /*public void setOnClickListener(View event) {
        String mark = isPlayer1 ? "X" : "O"; 
        if(event.getId() == R.id.button0) {
            if()
        } else if(event.getId() ==  R.id.button1) {
            if()
        } else if(event.getId() ==  R.id.button2) {
            
        } else if(event.getId() ==  R.id.button3) {
            
        } else if(event.getId() ==  R.id.button4) {
            
        } else if(event.getId() ==  R.id.button5) {
            
        } else if(event.getId() ==  R.id.button6) {
            
        } else if(event.getId() ==  R.id.button7) {
            
        } else if(event.getId() ==  R.id.button8) {
        }
    }*/
}
