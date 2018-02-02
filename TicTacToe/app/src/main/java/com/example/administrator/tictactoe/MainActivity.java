package com.example.administrator.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView vittoria;
    private char[][] campo;
    public int turno=0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campo= new char[][] {
                {' ',' ',' '},{' ',' ',' '},{' ',' ',' '}
        };
        Button reset = findViewById(R.id.resetB);
        button1 = findViewById(R.id.button0);
        button2 = findViewById(R.id.button1);
        button3 = findViewById(R.id.button2);
        button4 = findViewById(R.id.button3);
        button5 = findViewById(R.id.button4);
        button6 = findViewById(R.id.button5);
        button7 = findViewById(R.id.button6);
        button8 = findViewById(R.id.button7);
        button9 = findViewById(R.id.button8);

        setButtonAction(button1);
        setButtonAction(button2);
        setButtonAction(button3);
        setButtonAction(button4);
        setButtonAction(button5);
        setButtonAction(button6);
        setButtonAction(button7);
        setButtonAction(button8);
        setButtonAction(button9);


    }

    public void setButtonAction(Button b){
        b.setOnClickListener((View view) -> {
            if (b.getText().equals(" ")) {
                if (turno % 2 == 0) b.setText("X");
                else b.setText("O");
                b.setEnabled(false);
                turno++;
            }
            if(turno<9) checkVictory();
    });
    }

    private void checkVictory() {
        if(button1.getText().equals(button2.getText()) && button2.getText().equals(button3.getText()) && !(button3.getText().equals(" "))) { vittoria.setText("player "+button1.getText().toString()+" win");}
        if(button4.getText().equals(button5.getText()) && button5.getText().equals(button6.getText()) && !(button6.getText().equals(" "))) { vittoria.setText("player "+button1.getText().toString()+" win");}
        if(button7.getText().equals(button8.getText()) && button8.getText().equals(button9.getText()) && !(button9.getText().equals(" "))) { vittoria.setText("player "+button1.getText().toString()+" win");}


        if(button1.getText().equals(button4.getText()) && button4.getText().equals(button7.getText()) && !(button7.getText().equals(" "))) { vittoria.setText("player "+button1.getText().toString()+" win");}
        if(button2.getText().equals(button5.getText()) && button5.getText().equals(button8.getText()) && !(button8.getText().equals(" "))) { vittoria.setText("player "+button1.getText().toString()+" win");}
        if(button3.getText().equals(button6.getText()) && button6.getText().equals(button9.getText()) && !(button9.getText().equals(" "))) { vittoria.setText("player "+button1.getText().toString()+" win");}

        if(button1.getText().equals(button5.getText()) && button5.getText().equals(button9.getText()) && !(button9.getText().equals(" "))) { vittoria.setText("player "+button1.getText().toString()+" win");}
        if(button3.getText().equals(button5.getText()) && button5.getText().equals(button7.getText()) && !(button7.getText().equals(" "))) { vittoria.setText("player "+button1.getText().toString()+" win");}

    }


    public void reset(View view) {
        Toast.makeText(this, "funziona", Toast.LENGTH_LONG).show();
        button1.setText(" ");
        button2.setText(" ");
        button3.setText(" ");
        button4.setText(" ");
        button5.setText(" ");
        button6.setText(" ");
        button7.setText(" ");
        button8.setText(" ");
        button9.setText(" ");
        enableAll();
        turno=0;
        for(int i =0;i <3;i++){
                for(int j = 0; j<3 ; j++){
                    campo[i][j]=' ';

                }
        }

    }

    public void enableAll(){
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
        button7.setEnabled(true);
        button8.setEnabled(true);
        button9.setEnabled(true);
    }
}
