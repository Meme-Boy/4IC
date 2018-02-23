package com.example.federico.tris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PvE extends AppCompatActivity implements View.OnClickListener{


    public int[][] grid;
    public int current;
    public TextView showTurn;
    public String[] turn = new String[]{"Turno di X", "Turno del computer"};
    public Button button1, button2, button3, button4, button5, button6,
            button7, button8, button9, reset;
    public Button[] buttons = new Button[]{button1, button2, button3, button4, button5, button6,
            button7, button8, button9};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pve_layout);

        //matrice per controllare la partita
        grid = new int[3][3];
        //0 e 1 sono rispettivamente i due giocatori
        current = 0;

        button1 = (Button) findViewById(R.id.button1);
            button1.setOnClickListener(this);
            button1.setText("");
            button1.setClickable(true);
        button2 = (Button) findViewById(R.id.button2);
            button2.setOnClickListener(this);
            button2.setText("");
            button2.setClickable(true);
        button3 = (Button) findViewById(R.id.button3);
            button3.setOnClickListener(this);
            button3.setText("");
            button3.setClickable(true);
        button4 = (Button) findViewById(R.id.button4);
            button4.setOnClickListener(this);
            button4.setText("");
            button4.setClickable(true);
        button5 = (Button) findViewById(R.id.button5);
            button5.setOnClickListener(this);
            button5.setText("");
            button5.setClickable(true);
        button6 = (Button) findViewById(R.id.button6);
            button6.setOnClickListener(this);
            button6.setText("");
            button6.setClickable(true);
        button7 = (Button) findViewById(R.id.button7);
            button7.setOnClickListener(this);
            button7.setText("");
            button7.setClickable(true);
        button8 = (Button) findViewById(R.id.button8);
            button8.setOnClickListener(this);
            button8.setText("");
            button8.setClickable(true);
        button9 = (Button) findViewById(R.id.button9);
            button9.setOnClickListener(this);
            button9.setText("");
            button9.setClickable(true);
        reset = (Button) findViewById(R.id.reset);
            reset.setOnClickListener(this);

        showTurn = (TextView) findViewById(R.id.textView);
        showTurn.setText(turn[current]);

        for(int i = 0; i<=2; i++){
            for(int j = 0; j<=2; j++){
                grid[i][j] = 2;
            }
        }
    }

    @Override
    public void onClick(View v){

        switch (v.getId()){

            //resetta il gioco (la MainActivity) quando viene premuto il pulsante New Game
            case R.id.reset: reset(); break;

            case R.id.button1:{
                if(current == 0){
                    button1.setText("X");
                    grid[0][0] = 0;
                    button1.setClickable(false);
                    current = 1;
                    showTurn.setText(turn[current]);
                }
                if(checkBoard()){
                    reset();
                }else AImove();
                if(checkBoard()){
                    reset();
                }
            } break;

            case R.id.button2:{
                if(current == 0){
                    button2.setText("X");
                    grid[0][1] = 0;
                    button2.setClickable(false);
                    current = 1;
                    showTurn.setText(turn[current]);
                }
                if(checkBoard()){
                    reset();
                }
                else AImove();
                if(checkBoard()){
                    reset();
                }
            } break;

            case R.id.button3:{
                if(current == 0){
                    button3.setText("X");
                    grid[0][2] = 0;
                    button3.setClickable(false);
                    current = 1;
                    showTurn.setText(turn[current]);
                }
                if(checkBoard()){
                    reset();
                }else AImove();
                if(checkBoard()){
                    reset();
                }

            } break;

            case R.id.button4:{
                if(current == 0){
                    button4.setText("X");
                    grid[1][0] = 0;
                    button4.setClickable(false);
                    current = 1;
                    showTurn.setText(turn[current]);
                }
                if(checkBoard()){
                    reset();
                }else AImove();
                if(checkBoard()){
                    reset();
                }

            } break;

            case R.id.button5:{
                if(current == 0){
                    button5.setText("X");
                    grid[1][1] = 0;
                    button5.setClickable(false);
                    current = 1;
                    showTurn.setText(turn[current]);
                }
                if(checkBoard()){
                    reset();
                }else AImove();
                if(checkBoard()){
                    reset();
                }

            } break;

            case R.id.button6:{
                if(current == 0){
                    button6.setText("X");
                    grid[1][2] = 0;
                    button6.setClickable(false);
                    current = 1;
                    showTurn.setText(turn[current]);
                }
                if(checkBoard()){
                    reset();
                }else AImove();
                if(checkBoard()){
                    reset();
                }

            } break;

            case R.id.button7:{
                if(current == 0){
                    button7.setText("X");
                    grid[2][0] = 0;
                    button7.setClickable(false);
                    current = 1;
                    showTurn.setText(turn[current]);
                }
                if(checkBoard()){
                    reset();
                }else AImove();
                if(checkBoard()){
                    reset();
                }

            } break;

            case R.id.button8:{
                if(current == 0){
                    button8.setText("X");
                    grid[2][1] = 0;
                    button8.setClickable(false);
                    current = 1;
                    showTurn.setText(turn[current]);
                }
                if(checkBoard()){
                    reset();
                }else AImove();
                if(checkBoard()){
                    reset();
                }

            } break;

            case R.id.button9:{
                if(current == 0){
                    button9.setText("X");
                    grid[2][2] = 0;
                    button9.setClickable(false);
                    current = 1;
                    showTurn.setText(turn[current]);
                }
                if(checkBoard()){
                    reset();
                }else AImove();
                if(checkBoard()){
                    reset();
                }

            } break;

            default: break;
        }
    }

    public boolean checkBoard() {
        boolean gameOver = false;
        if ((grid[0][0] == 0 && grid[1][1] == 0 && grid[2][2] == 0)
                || (grid[0][2] == 0 && grid[1][1] == 0 && grid[2][0] == 0)
                || (grid[0][1] == 0 && grid[1][1] == 0 && grid[2][1] == 0)
                || (grid[0][2] == 0 && grid[1][2] == 0 && grid[2][2] == 0)
                || (grid[0][0] == 0 && grid[0][1] == 0 && grid[0][2] == 0)
                || (grid[1][0] == 0 && grid[1][1] == 0 && grid[1][2] == 0)
                || (grid[2][0] == 0 && grid[2][1] == 0 && grid[2][2] == 0)
                || (grid[0][0] == 0 && grid[1][0] == 0 && grid[2][0] == 0)) {
            Toast.makeText(getApplicationContext(), "Giocatore 1 vince!", Toast.LENGTH_SHORT).show();
            gameOver = true;
        } else if ((grid[0][0] == 1 && grid[1][1] == 1 && grid[2][2] == 1)
                || (grid[0][2] == 1 && grid[1][1] == 1 && grid[2][0] == 1)
                || (grid[0][1] == 1 && grid[1][1] == 1 && grid[2][1] == 1)
                || (grid[0][2] == 1 && grid[1][2] == 1 && grid[2][2] == 1)
                || (grid[0][0] == 1 && grid[0][1] == 1 && grid[0][2] == 1)
                || (grid[1][0] == 1 && grid[1][1] == 1 && grid[1][2] == 1)
                || (grid[2][0] == 1 && grid[2][1] == 1 && grid[2][2] == 1)
                || (grid[0][0] == 1 && grid[1][0] == 1 && grid[2][0] == 1)) {
            Toast.makeText(getApplicationContext(), "Giocatore 2 vince!", Toast.LENGTH_SHORT).show();
            gameOver = true;
        } else {
            boolean empty = false;

            for(int i=0; i<=2; i++) {
                for(int j=0; j<=2; j++) {
                    if(grid[i][j]==2) {
                        empty = true;
                        break;
                    }
                }
            }
            if(!empty) {
                gameOver = true;
                Toast.makeText(getApplicationContext(), "Pareggio!", Toast.LENGTH_LONG).show();
            }
        }
        return gameOver;
    }

    public void reset(){
        startActivity(new Intent(this, MainActivity.class));
    }

    //simula una mossa del computer
    public void AImove(){

        boolean fill = false;
        int random_box;

        while(!fill){

            random_box = new Random().nextInt(9 - 1 + 1) + 1;

            switch (random_box){
                case 1 : if(grid[0][0] == 2){
                    button1.setText("O");
                    grid[0][0] = 1;
                    button1.setClickable(false);
                    current = 0;
                    showTurn.setText(turn[current]);
                    fill = true;
                } break;

                case 2 : if(grid[0][1] == 2){
                    button2.setText("O");
                    grid[0][1] = 1;
                    button2.setClickable(false);
                    current = 0;
                    showTurn.setText(turn[current]);
                    fill = true;
                } break;

                case 3 : if(grid[0][2] == 2){
                    button3.setText("O");
                    grid[0][2] = 1;
                    button3.setClickable(false);
                    current = 0;
                    showTurn.setText(turn[current]);
                    fill = true;
                } break;

                case 4 : if(grid[1][0] == 2){
                    button4.setText("O");
                    grid[1][0] = 1;
                    button4.setClickable(false);
                    current = 0;
                    showTurn.setText(turn[current]);
                    fill = true;
                } break;

                case 5 : if(grid[1][1] == 2){
                    button5.setText("O");
                    grid[1][1] = 1;
                    button5.setClickable(false);
                    current = 0;
                    showTurn.setText(turn[current]);
                    fill = true;
                } break;

                case 6 : if(grid[1][2] == 2){
                    button6.setText("O");
                    grid[1][2] = 1;
                    button6.setClickable(false);
                    current = 0;
                    showTurn.setText(turn[current]);
                    fill = true;
                } break;

                case 7 : if(grid[2][0] == 2){
                    button7.setText("O");
                    grid[2][0] = 1;
                    button7.setClickable(false);
                    current = 0;
                    showTurn.setText(turn[current]);
                    fill = true;
                } break;

                case 8 : if(grid[2][1] == 2){
                    button8.setText("O");
                    grid[2][1] = 1;
                    button8.setClickable(false);
                    current = 0;
                    showTurn.setText(turn[current]);
                    fill = true;
                } break;

                case 9 : if(grid[2][2] == 2){
                    button9.setText("O");
                    grid[2][2] = 1;
                    button9.setClickable(false);
                    current = 0;
                    showTurn.setText(turn[current]);
                    fill = true;
                } break;

                default : break;

            }
        }
    }
}
