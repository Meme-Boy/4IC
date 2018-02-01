package com.example.studente.tris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button[][] buttons;
    public int[][] grid;
    public int current;
    public TextView showTurn;
    public String[] turn = new String[]{"Turno di X", "Turno di O"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(getApplicationContext(), "Pareggio", Toast.LENGTH_LONG).show();

        buttons = new Button[3][3];
        //matrice per controllare la partita
        grid = new int[3][3];
        //0 e 1 sono rispettivamente i due giocatori
        current = 0;

        buttons[0][0] = (Button) findViewById(R.id.button1);
        buttons[0][1] = (Button) findViewById(R.id.button2);
        buttons[0][2] = (Button) findViewById(R.id.button3);
        buttons[1][0] = (Button) findViewById(R.id.button4);
        buttons[1][1] = (Button) findViewById(R.id.button5);
        buttons[1][2] = (Button) findViewById(R.id.button6);
        buttons[2][0] = (Button) findViewById(R.id.button7);
        buttons[2][1] = (Button) findViewById(R.id.button8);
        buttons[2][2] = (Button) findViewById(R.id.button9);
        Button reset = (Button) findViewById(R.id.reset);
        showTurn = (TextView) findViewById(R.id.textView);
        showTurn.setText(turn[current]);

        //ricomincia il gioco quando viene premuto New Game
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });


        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                buttons[i][j].setOnClickListener(new myListener(i, j));
                buttons[i][j].setText("");
                buttons[i][j].setClickable(true);
            }
        }

        for(int i = 0; i<=2; i++){
            for(int j = 0; j<=2; j++){
                grid[i][j] = 2;
            }
        }

    }

    //quando viene cliccato un bottone
    //cambia il background del bottone a seconda del turno
    //fai il controllo se qualcuno ha vinto

    class myListener implements View.OnClickListener{

        private int x, y;
        public myListener(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public void onClick(View view) {
            if(current == 0){
                buttons[x][y].setText("X");
                grid[x][y] = 0;
                buttons[x][y].setClickable(false);
                current = 1;
                showTurn.setText(turn[current]);
            }else{
                buttons[x][y].setText("O");
                grid[x][y] = 1;
                buttons[x][y].setClickable(false);
                current = 0;
                showTurn.setText(turn[current]);
            }
            if(checkBoard()){
                reset();
            }
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
            Toast.makeText(getApplicationContext(), "Giocatore 1 vince!", Toast.LENGTH_LONG).show();
            gameOver = true;
        } else if ((grid[0][0] == 1 && grid[1][1] == 1 && grid[2][2] == 1)
                || (grid[0][2] == 1 && grid[1][1] == 1 && grid[2][0] == 1)
                || (grid[0][1] == 1 && grid[1][1] == 1 && grid[2][1] == 1)
                || (grid[0][2] == 1 && grid[1][2] == 1 && grid[2][2] == 1)
                || (grid[0][0] == 1 && grid[0][1] == 1 && grid[0][2] == 1)
                || (grid[1][0] == 1 && grid[1][1] == 1 && grid[1][2] == 1)
                || (grid[2][0] == 1 && grid[2][1] == 1 && grid[2][2] == 1)
                || (grid[0][0] == 1 && grid[1][0] == 1 && grid[2][0] == 1)) {
            Toast.makeText(getApplicationContext(), "Giocatore 2 vince!", Toast.LENGTH_LONG).show();
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
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
