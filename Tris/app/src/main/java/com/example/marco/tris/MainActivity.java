package com.example.marco.tris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int j=0;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i = new Intent(this,ActivityTwo.class);
        Tris.restart();

    }


    public void clickListener(View view){

        Button clicked = (Button)view;
        char sign;

        if (j % 2 == 0) {
            clicked.setText("X");
            sign='X';
        } else {
            clicked.setText("O");
            sign='O';
        }

        clicked.setEnabled(false);
        j++;

        switch (view.getId()) {
            case R.id.uno:
                Tris.set(view, sign);
                break;
            case R.id.due:
                Tris.set(view, sign);
                break;
            case R.id.tre:
                Tris.set(view, sign);
                break;
            case R.id.quattro:
                Tris.set(view, sign);
                break;
            case R.id.cinque:
                Tris.set(view, sign);
                break;
            case R.id.sei:
                Tris.set(view, sign);
                break;
            case R.id.sette:
                Tris.set(view, sign);
                break;
            case R.id.otto:
                Tris.set(view, sign);
                break;
            case R.id.nove:
                Tris.set(view, sign);
                break;
        }

        if((j<9 || j==9) && Tris.verificaVittoria(i)) {
            startActivity(i);
            finish();
        }

        if(j==9 && !Tris.verificaVittoria(i)) {
            Tris.pareggio(i);
            startActivity(i);
            finish();
        }
    }
}
