package com.example.miche.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView winLose;
    private int round=0;
    private String pos[][]={{" ", " ", " "},{" ", " ", " "},{" ", " ", " "}};
    private String x;
    private String o;
    private String p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x="Player X won";
        o="Player O won";
        p="Draw";

        winLose=findViewById(R.id.winLose);

        Button b1=findViewById(R.id.b1);
        onClick(b1);
        Button b2=findViewById(R.id.b2);
        onClick(b2);
        Button b3=findViewById(R.id.b3);
        onClick(b3);
        Button b4=findViewById(R.id.b4);
        onClick(b4);
        Button b5=findViewById(R.id.b5);
        onClick(b5);
        Button b6=findViewById(R.id.b6);
        onClick(b6);
        Button b7=findViewById(R.id.b7);
        onClick(b7);
        Button b8=findViewById(R.id.b8);
        onClick(b8);
        Button b9=findViewById(R.id.b9);
        onClick(b9);

        winner();

    }

    public void onClick(Button b){
        b.setOnClickListener((View view)->{
            if(b.getText().equals(" ")){
                if(round==0){
                    b.setText("X");
                    round=1;
                }else{
                    b.setText("O");
                    round=0;
                }
            }
        });

        switch (R.id.all){
            case R.id.b1:
                if(b.getText().equals("X"))
                    pos[1][1]="X";
                else
                    pos[1][1]="0";
            case R.id.b2:
                if(b.getText().equals("X"))
                    pos[1][2]="X";
                else
                    pos[1][2]="0";
            case R.id.b3:
                if(b.getText().equals("X"))
                    pos[1][3]="X";
                else
                    pos[1][3]="0";
            case R.id.b4:
                if(b.getText().equals("X"))
                    pos[2][1]="X";
                else
                    pos[2][1]="0";
            case R.id.b5:
                if(b.getText().equals("X"))
                    pos[2][2]="X";
                else
                    pos[2][2]="0";
            case R.id.b6:
                if(b.getText().equals("X"))
                    pos[2][3]="X";
                else
                    pos[2][3]="0";
            case R.id.b7:
                if(b.getText().equals("X"))
                    pos[3][1]="X";
                else
                    pos[3][1]="0";
            case R.id.b8:
                if(b.getText().equals("X"))
                    pos[3][2]="X";
                else
                    pos[3][2]="0";
            case R.id.b9:
                if(b.getText().equals("X"))
                    pos[3][3]="X";
                else
                    pos[3][3]="0";
        }

    }

    public void winner (){
        if((!pos[1][1].equals(" "))&&(!pos[1][2].equals(" "))&&(!pos[1][3].equals(" "))&&(!pos[2][1].equals(" "))&&(!pos[2][2].equals(" "))&&(!pos[2][3].equals(" "))&&(!pos[3][1].equals(" "))&&(!pos[3][2].equals(" "))&&(!pos[3][3].equals(" "))){
            if (((pos[1][1].equals("X"))&&(pos[1][2].equals("X"))&&(pos[1][3].equals("X")))||((pos[2][1].equals("X"))&&(pos[2][2].equals("X"))&&(pos[2][3].equals("X")))||((pos[3][1].equals("X"))&&(pos[3][2].equals("X"))&&(pos[3][3].equals("X")))||((pos[1][1].equals("X"))&&(pos[2][1].equals("X"))&&(pos[3][1].equals("X")))||((pos[1][2].equals("X"))&&(pos[2][2].equals("X"))&&(pos[3][2].equals("X")))||((pos[1][3].equals("X"))&&(pos[2][3].equals("X"))&&(pos[3][3].equals("X")))||((pos[1][1].equals("X"))&&(pos[2][2].equals("X"))&&(pos[3][3].equals("X")))||((pos[1][3].equals("X"))&&(pos[2][2].equals("X"))&&(pos[3][1].equals("X")))){
                winLose.setText(x);
            }if (((pos[1][1].equals("O"))&&(pos[1][2].equals("O"))&&(pos[1][3].equals("O")))||((pos[2][1].equals("O"))&&(pos[2][2].equals("O"))&&(pos[2][3].equals("O")))||((pos[3][1].equals("O"))&&(pos[3][2].equals("O"))&&(pos[3][3].equals("O")))||((pos[1][1].equals("O"))&&(pos[2][1].equals("O"))&&(pos[3][1].equals("O")))||((pos[1][2].equals("O"))&&(pos[2][2].equals("O"))&&(pos[3][2].equals("O")))||((pos[1][3].equals("O"))&&(pos[2][3].equals("O"))&&(pos[3][3].equals("O")))||((pos[1][1].equals("O"))&&(pos[2][2].equals("O"))&&(pos[3][3].equals("O")))||((pos[1][3].equals("O"))&&(pos[2][2].equals("O"))&&(pos[3][1].equals("O")))){
                winLose.setText(o);
            }else{
                winLose.setText(p);
                //Coming soon the rest button
            }
        }
    }

}
