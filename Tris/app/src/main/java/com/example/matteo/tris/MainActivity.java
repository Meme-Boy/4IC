package com.example.matteo.tris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int j=0;
    char[][] btn;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = new char[][] {
                {' ',' ',' '},
                {' ',' ',' '},
                {' ',' ',' '}
        };

        i = new Intent(this,ActivityTwo.class);

    }


    public void clickListener(View view){

        Button clicked = (Button)(view);
        char pressed;

        if(clicked.getText().equals("")) {
            if (j % 2 == 0) { clicked.setText("X"); pressed='X'; }
            else { clicked.setText("O"); pressed='O'; }
            j++;
            switch (view.getId()) {
                case R.id.uno: btn[0][0] = pressed; break;
                case R.id.due: btn[0][1] = pressed; break;
                case R.id.tre: btn[0][2] = pressed; break;
                case R.id.quattro: btn[1][0] = pressed; break;
                case R.id.cinque: btn[1][1] = pressed; break;
                case R.id.sei: btn[1][2] = pressed; break;
                case R.id.sette: btn[2][0] = pressed; break;
                case R.id.otto: btn[2][1] = pressed; break;
                case R.id.nove: btn[2][2] = pressed; break;
            }
        }

        if(j<9) checkVictory(i);
        else { i.putExtra("winner",'n'); startActivity(i); finish();}
    }

    public void checkVictory(Intent i){
        if(btn[0][0]==btn[0][1] && btn[0][0]==btn[0][2] && btn[0][0]!=' ') { i.putExtra("winner",btn[0][0]) ; startActivity(i); finish(); }
        if(btn[1][0]==btn[1][1] && btn[1][0]==btn[1][2] && btn[1][0]!=' ') { i.putExtra("winner",btn[1][0]) ; startActivity(i); finish(); }
        if(btn[2][0]==btn[2][1] && btn[2][0]==btn[2][2] && btn[2][0]!=' ') { i.putExtra("winner",btn[2][0]) ; startActivity(i); finish(); }

        if(btn[0][0]==btn[1][0] && btn[0][0]==btn[2][0] && btn[0][0]!=' ') { i.putExtra("winner",btn[0][0]) ; startActivity(i); finish(); }
        if(btn[0][1]==btn[1][1] && btn[0][1]==btn[2][1] && btn[0][1]!=' ') { i.putExtra("winner",btn[0][1]) ; startActivity(i); finish(); }
        if(btn[0][2]==btn[1][2] && btn[0][2]==btn[2][2] && btn[0][2]!=' ') { i.putExtra("winner",btn[0][2]) ; startActivity(i); finish(); }

        if(btn[0][0]==btn[1][1] && btn[0][0]==btn[2][2] && btn[0][0]!=' ') { i.putExtra("winner",btn[0][0]) ; startActivity(i); finish(); }
        if(btn[0][2]==btn[1][1] && btn[0][2]==btn[2][0] && btn[0][2]!=' ') { i.putExtra("winner",btn[0][2]) ; startActivity(i); finish(); }

    }

}
