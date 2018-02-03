package com.example.administrator.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by giacomo.ravagnan on 03/02/2018.
 */

public class TTT implements OnClickListener {

    private Activity activity;
    private boolean griglia[] = new boolean[9];
    private int vittoria[] = new int[9];
    public int turno;
    private TextView schermo;

    private Button uno;
    private Button due;
    private Button tre;
    private Button quattro;
    private Button cinque;
    private Button sei;
    private Button sette;
    private Button otto;
    private Button nove;
    private Button restart;

    public TTT(MainActivity activity) {

        turno = 0;
        this.activity = activity;
        uno = this.activity.findViewById(R.id.button0);
        due = this.activity.findViewById(R.id.button1);
        tre = this.activity.findViewById(R.id.button2);
        quattro = this.activity.findViewById(R.id.button3);
        cinque = this.activity.findViewById(R.id.button4);
        sei = this.activity.findViewById(R.id.button5);
        sette = this.activity.findViewById(R.id.button6);
        otto = this.activity.findViewById(R.id.button7);
        nove = this.activity.findViewById(R.id.button8);


        uno.setOnClickListener(this);
        due.setOnClickListener(this);
        tre.setOnClickListener(this);
        quattro.setOnClickListener(this);
        cinque.setOnClickListener(this);
        sei.setOnClickListener(this);
        sette.setOnClickListener(this);
        otto.setOnClickListener(this);
        nove.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button0:
                if(!griglia[0]) {
                    griglia[0] = true;
                    vittoria[0] = setText(uno,turno);
                    checkWin();
                    turno++;
                }
                break;


            case R.id.button1:
                if(!griglia[1]) {
                    griglia[1]=true;
                    vittoria[1] = setText(due,turno);
                    checkWin();
                    turno++;
                }
                break;



            case R.id.button2:
                if(!griglia[2]) {
                    griglia[2]=true;
                    vittoria[2] = setText(tre,turno);
                    checkWin();
                    turno++;
                }

                break;



            case R.id.button3:

                if(!griglia[3]) {
                    griglia[3]=true;
                    vittoria[3] = setText(quattro,turno);
                    checkWin();
                    turno++;
                }

                break;

            case R.id.button4:

                if(!griglia[4]) {
                    griglia[4]=true;
                    vittoria[4] = setText(cinque,turno);
                    checkWin();
                    turno++;
                }

                break;

            case R.id.button5:

                if(!griglia[5]) {
                    griglia[5]=true;
                    vittoria[5] = setText(sei,turno);
                    checkWin();
                    turno++;
                }

                break;

            case R.id.button6:

                if(!griglia[6]) {
                    griglia[6]=true;
                    vittoria[6] = setText(sette,turno);
                    checkWin();
                    turno++;
                }

                break;

            case R.id.button7:

                if(!griglia[7]) {
                    griglia[7]=true;
                    vittoria[7] = setText(otto,turno);
                    checkWin();
                    turno++;
                }

                break;

            case R.id.button8:

                if(!griglia[8]) {
                    griglia[8]=true;
                    vittoria[8] = setText(nove,turno);
                    checkWin();
                    turno++;
                }
                break;
            default:
                break;
        }
    }
    public int setText(Button b , int turno){
        int value;
        if(turno % 2 == 0){
            value=-1;
            b.setText("X");
        }else{
            value=1;
            b.setText("O");
        }
        b.setEnabled(false);

        return value;
    }
    private boolean checkDraw(){
        return ++turno==9;
    }

    private  void checkWin() {



        if (vittoria[0] == 1 && vittoria[1] == 1 && vittoria[2] == 1 ||
                vittoria[3] == 1 && vittoria[4] == 1 && vittoria[5] == 1 ||
                vittoria[6] == 1 && vittoria[7] == 1 && vittoria[8] == 1 ||
                vittoria[0] == 1 && vittoria[3] == 1 && vittoria[6] == 1 ||
                vittoria[1] == 1 && vittoria[4] == 1 && vittoria[7] == 1 ||
                vittoria[2] == 1 && vittoria[5] == 1 && vittoria[8] == 1 ||
                vittoria[0] == 1 && vittoria[4] == 1 && vittoria[8] == 1 ||
                vittoria[2] == 1 && vittoria[4] == 1 && vittoria[6] == 1) {

            String strPlayer = "Player O won!!";
            schermo.setText(strPlayer);

        } else if (vittoria[0] == -1 && vittoria[1] == -1 && vittoria[2] == -1 ||
                vittoria[3] == -1 && vittoria[4] == -1 && vittoria[5] == -1 ||
                vittoria[6] == -1 && vittoria[7] == -1 && vittoria[8] == -1 ||
                vittoria[0] == -1 && vittoria[3] == -1 && vittoria[6] == -1 ||
                vittoria[1] == -1 && vittoria[4] == -1 && vittoria[7] == -1 ||
                vittoria[2] == -1 && vittoria[5] == -1 && vittoria[8] == -1 ||
                vittoria[0] == -1 && vittoria[4] == -1 && vittoria[8] == -1 ||
                vittoria[2] == -1 && vittoria[4] == -1 && vittoria[6] == -1) {

            String strPlayer = "Player X won!!";
            schermo.setText(strPlayer);

        } else if (checkDraw()) {
            String strPlayer = "Draw... let's match again !!";
            schermo.setText(strPlayer);
        }
    }
}
