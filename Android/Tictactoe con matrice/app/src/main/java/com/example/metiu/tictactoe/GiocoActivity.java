package com.example.metiu.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class GiocoActivity extends AppCompatActivity {
    Button[][] bottoni;
    int [][] griglia;
    int turnoCorrente;
    TextView turnoGiocatore;
    Button rigioca;
    String[] turno=new String[]{"Turno del player X","Turno del player O"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gioco);

        bottoni = new Button[3][3];
        //matrice per controllare la partita
        griglia = new int[3][3];
        //0 e 1 sono rispettivamente i due giocatori
        turnoCorrente = 0;
        rigioca=findViewById(R.id.reset);//Bottone rigioca
        bottoni[0][0] = (Button) findViewById(R.id.button1);
        bottoni[0][1] = (Button) findViewById(R.id.button2);
        bottoni[0][2] = (Button) findViewById(R.id.button3);
        bottoni[1][0] = (Button) findViewById(R.id.button4);
        bottoni[1][1] = (Button) findViewById(R.id.button5);
        bottoni[1][2] = (Button) findViewById(R.id.button6);
        bottoni[2][0] = (Button) findViewById(R.id.button7);
        bottoni[2][1] = (Button) findViewById(R.id.button8);
        bottoni[2][2] = (Button) findViewById(R.id.button9);

        turnoGiocatore = (TextView) findViewById(R.id.textView);
        turnoGiocatore.setText(turno[turnoCorrente]);

        rigioca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                bottoni[i][j].setOnClickListener(new buttonListener(i, j));
                bottoni[i][j].setText("");
                bottoni[i][j].setClickable(true);
            }
        }

        for(int i = 0; i<=2; i++){
            for(int j = 0; j<=2; j++){
                griglia[i][j] = 2;
            }
        }

    }


    private void resetGame() {
        Intent it=new Intent(this,MainActivity.class);
        startActivity(it);
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
    private class buttonListener implements  View.OnClickListener{
        int x,y;

        public buttonListener(int x,int y) {
            this.y = y;
            this.x = x;
        }

        @Override
        public void onClick(View view) {
            if(turnoCorrente==0){
                bottoni[x][y].setText("X");
                griglia[x][y]=0;
                bottoni[x][y].setClickable(false);
                turnoCorrente=1;
                turnoGiocatore.setText(turno[turnoCorrente]);
            }
            else if(turnoCorrente==1){
                bottoni[x][y].setText("O");
                griglia[x][y]=1;
                bottoni[x][y].setClickable(false);
                turnoCorrente=0;
                turnoGiocatore.setText(turno[turnoCorrente]);
            }
            if(checkFinishGame()){
                resetGame();
            }

        }
    }
}
