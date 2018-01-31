package com.frafortu.trisprova;

import android.app.Application;
import android.content.Context;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by FortuF100 on 31/01/2018.
 */

public class TrisField {
    private Box[][] field;
    private Button[][] boxes;
    private boolean isPlayer1;
    private Context context;
    public TrisField(Button[][] btns, Context ctx) {
        boxes = btns;
        context = ctx;
        field = new Box[3][3];
        for(int i = 0; i < field.length; i++)
            for(int j = 0; j < field[i].length; j++)
                field[i][j] = new Box();
        isPlayer1 = false;//just for start
    }
    
    public void play() {
        for(int i = 0; i < boxes.length; i++) {
            for(int j = 0; j < boxes[i].length; j++) {
                int row = i;
                int col = j;
                boxes[i][j].setOnClickListener(event -> {
                    isPlayer1 = !isPlayer1;
                    if(! field[row][col].hasBeenPressed) {
                        if(isPlayer1) {
                            boxes[row][col].setText("X");
                        } else {
                            boxes[row][col].setText("O");
                        }
                        field[row][col].hasBeenPressed = true;
                        if(hasSomeonewon()) {
                            Toast.makeText(context, "Player 1 Wins", Toast.LENGTH_LONG).show();
                            return;
                        }
                        if(isFieldFull()) {
                            if(!hasSomeonewon()) Toast.makeText(context, "Tie", Toast.LENGTH_LONG).show();
                            return;
                        }
                        isPlayer1 = !isPlayer1;
                        opponentMove();
                        if(hasSomeonewon()) {
                            Toast.makeText(context, "Player 2 Wins", Toast.LENGTH_LONG).show();
                            return;
                        }
                        if(isFieldFull()) {
                            if(!hasSomeonewon()) Toast.makeText(context, "Tie", Toast.LENGTH_LONG).show();
                            return;
                        }
                    } else {
                        Toast.makeText(context,"Already pressed",Toast.LENGTH_LONG).show();
                    }
                });
            }
        }
    }
    
    private void opponentMove() {
        Random gen = new Random();
        int row = gen.nextInt(3);
        int col = gen.nextInt(3);
        if(field[row][col].hasBeenPressed) {
            opponentMove();
        } else {
            field[row][col].hasBeenPressed = true;
            if(isPlayer1)
                boxes[row][col].setText("X");
            else boxes[row][col].setText("O");
            return;
        }
    }
    
    private boolean isFieldFull() {
        boolean full = true;
        for (int i = 0; i < field.length; i++)  {
            for(int j = 0; j < field[i].length; j++) {
                if(! field[i][j].hasBeenPressed) {
                    full = false;
                }
            }
        }
        return full;
    }

    public boolean hasSomeonewon() {
        boolean player1Wins = true;
        boolean player2Wins = true;
        /*
        horizontal check
         */
        for(int i = 0; i < boxes[0].length; i++) {
            player1Wins = true;
            player2Wins = true;
            for (int j = 0; j < boxes[i].length; j++) {
                if (!boxes[i][j].getText().equals("X")) player1Wins = false;
            }
            if (player1Wins) return true;
            for (int j = 0; j < boxes[i].length; j++) {
                if (!boxes[i][j].getText().equals("O")) player2Wins = false;
            }
            if (player2Wins) return true;
        }
        /*
        vertical check
         */
        for(int i = 0; i < boxes[0].length; i++) {
            player1Wins = true;
            player2Wins = true;
            for (int j = 0; j < boxes[i].length; j++) {
                if (!boxes[j][i].getText().equals("X")) player1Wins = false;
            }
            if (player1Wins) return true;
            for (int j = 0; j < boxes[i].length; j++) {
                if (!boxes[j][i].getText().equals("O")) player2Wins = false;
            }
            if (player2Wins) return true;
        }
        /*
        oblique check
         */
        player1Wins = true;
        player2Wins = true;
        int i, j;
        for(i = j = 0; i < boxes[0].length && j < boxes[0].length; i++, j++) {
            if(!boxes[i][j].getText().equals("X")) player1Wins = false;
        }
        if (player1Wins) return true;
        for(i = j = 0; i < boxes[0].length && j < boxes[0].length; i++, j++) {
            if(!boxes[i][j].getText().equals("O")) player2Wins = false;
        }
        if (player2Wins) return true;
        player1Wins = true;
        player2Wins = true;
        for(i = j = boxes[0].length - 1; i >= 0 && j >= 0; i--, j--) {
            if(!boxes[i][j].getText().equals("X")) player1Wins = false;
        }
        if (player1Wins) return true;
        for(i = j = boxes[0].length - 1; i >= 0 && j >= 0; i--, j--) {
            if(!boxes[i][j].getText().equals("O")) player2Wins = false;
        }
        if (player2Wins) return true;
        return false;
    }
}
