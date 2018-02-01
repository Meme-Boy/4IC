package com.example.metiu.tictactoe;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class GiocoActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    int [][] griglia;
    int turnoCorrente;
    TextView turnoGiocatore;
    Button rigioca;
    String[] turno=new String[]{"Turno del player X","Turno del player O"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gioco);


        //matrice per controllare la partita
        griglia = new int[3][3];
        //0 e 1 sono iturni dei due giocatori
        turnoCorrente = 0;
        rigioca=findViewById(R.id.reset);//Bottone rigioca
        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(this);
        b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(this);
        b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(this);
        b5 = (Button) findViewById(R.id.button5);
        b5.setOnClickListener(this);
        b6 = (Button) findViewById(R.id.button6);
        b6.setOnClickListener(this);
        b7 = (Button) findViewById(R.id.button7);
        b7.setOnClickListener(this);
        b8 = (Button) findViewById(R.id.button8);
        b8.setOnClickListener(this);
        b9 = (Button) findViewById(R.id.button9);
        b9.setOnClickListener(this);

        turnoGiocatore = (TextView) findViewById(R.id.textView);
        turnoGiocatore.setText(turno[turnoCorrente]);

        rigioca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame(true);
            }
        });


        for(int i = 0; i<=2; i++){
            for(int j = 0; j<=2; j++){
                griglia[i][j] = 2;
            }
        }

    }


    private void resetGame(boolean b) {
        if(b) {
            Intent it = new Intent(this, GiocoActivity.class);
            startActivity(it);
        }
    }
    private boolean checkFinishGame(){
        boolean cond=false;
        if((griglia[0][0] == 0 && griglia[1][1] == 0 && griglia[2][2] == 0)
                || (griglia[0][2] == 0 && griglia[1][1] == 0 && griglia[2][0] == 0)
                || (griglia[0][1] == 0 && griglia[1][1] == 0 && griglia[2][1] == 0)
                || (griglia[0][2] == 0 && griglia[1][2] == 0 && griglia[2][2] == 0)
                || (griglia[0][0] == 0 && griglia[0][1] == 0 && griglia[0][2] == 0)
                || (griglia[1][0] == 0 && griglia[1][1] == 0 && griglia[1][2] == 0)
                || (griglia[2][0] == 0 && griglia[2][1] == 0 && griglia[2][2] == 0)
                || (griglia[0][0] == 0 && griglia[1][0] == 0 && griglia[2][0] == 0)){
            Toast.makeText(getApplicationContext(), "Giocatore con la Croce vince!", Toast.LENGTH_LONG).show();
            cond = true;
        }else if ((griglia[0][0] == 1 && griglia[1][1] == 1 && griglia[2][2] == 1)
                || (griglia[0][2] == 1 && griglia[1][1] == 1 && griglia[2][0] == 1)
                || (griglia[0][1] == 1 && griglia[1][1] == 1 && griglia[2][1] == 1)
                || (griglia[0][2] == 1 && griglia[1][2] == 1 && griglia[2][2] == 1)
                || (griglia[0][0] == 1 && griglia[0][1] == 1 && griglia[0][2] == 1)
                || (griglia[1][0] == 1 && griglia[1][1] == 1 && griglia[1][2] == 1)
                || (griglia[2][0] == 1 && griglia[2][1] == 1 && griglia[2][2] == 1)
                || (griglia[0][0] == 1 && griglia[1][0] == 1 && griglia[2][0] == 1)) {
            Toast.makeText(getApplicationContext(), "Giocatore con il Cerchio vince!", Toast.LENGTH_LONG).show();
            cond = true;
        }else{
            boolean vuoto=false;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if (griglia[i][j] == 2) {
                        vuoto=true;
                        break;
                    }
                }
            }
            if(!vuoto){
                cond=true;
                Toast.makeText(getApplicationContext(), "Pareggio!", Toast.LENGTH_LONG).show();
            }
        }
        return cond;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button1:
                if(turnoCorrente==0){
                    b1.setText("X");
                    griglia[0][0]=0;
                }else{
                    b1.setText("O");
                    griglia[0][0]=1;
                }
                b1.setClickable(false);
                changeTurn();
                resetGame(checkFinishGame());
                break;
            case R.id.button2:
                if(turnoCorrente==0){
                    b2.setText("X");
                    griglia[0][1]=0;
                }else{
                    b2.setText("O");
                    griglia[0][1]=1;
                }
                b2.setClickable(false);
                changeTurn();
                resetGame(checkFinishGame());
                break;
            case R.id.button3:
                if(turnoCorrente==0){
                    b3.setText("X");
                    griglia[0][2]=0;
                }else{
                    b3.setText("O");
                    griglia[0][2]=1;
                }
                b3.setClickable(false);
                changeTurn();
                resetGame(checkFinishGame());
                break;
            case R.id.button4:
                if(turnoCorrente==0){
                    b4.setText("X");
                    griglia[1][0]=0;
                }else{
                    b4.setText("O");
                    griglia[1][0]=1;
                }
                b4.setClickable(false);
                changeTurn();
                resetGame(checkFinishGame());
                break;
            case R.id.button5:
                if(turnoCorrente==0){
                    b5.setText("X");
                    griglia[1][1]=0;
                }else{
                    b5.setText("O");
                    griglia[1][1]=1;
                }
                b5.setClickable(false);
                changeTurn();
                resetGame(checkFinishGame());
                break;
            case R.id.button6:
                if(turnoCorrente==0){
                    b6.setText("X");
                    griglia[1][2]=0;
                }else{
                    b6.setText("O");
                    griglia[1][2]=1;
                }
                b6.setClickable(false);
                changeTurn();
                resetGame(checkFinishGame());
                break;
            case R.id.button7:
                if(turnoCorrente==0){
                    b7.setText("X");
                    griglia[2][0]=0;
                }else{
                    b7.setText("O");
                    griglia[2][0]=1;
                }
                b7.setClickable(false);
                changeTurn();
                resetGame(checkFinishGame());
                break;
            case R.id.button8:
                if(turnoCorrente==0){
                    b8.setText("X");
                    griglia[2][1]=0;
                }else{
                    b8.setText("O");
                    griglia[2][1]=1;
                }
                b8.setClickable(false);
                changeTurn();
                resetGame(checkFinishGame());
                break;
            case R.id.button9:
                if(turnoCorrente==0){
                    b9.setText("X");
                    griglia[2][2]=0;
                }else{
                    b9.setText("O");
                    griglia[2][2]=1;
                }
                b9.setClickable(false);
                changeTurn();
                resetGame(checkFinishGame());
                break;
        }
    }


    private void changeTurn(){
        if(turnoCorrente==0){
            turnoCorrente=1;
            turnoGiocatore.setText(turno[1]);
        }else{
            turnoCorrente=0;
            turnoGiocatore.setText(turno[0]);
        }
    }
}
