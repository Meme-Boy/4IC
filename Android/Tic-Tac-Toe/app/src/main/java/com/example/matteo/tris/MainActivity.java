package com.example.matteo.tris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int j=0;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i = new Intent(this,ActivityTwo.class);
        Tris.clear();

    }


    public void clickListener(View view){

        Button clicked = (Button)(view);
        char pressed;

            if (j % 2 == 0) { clicked.setText("X"); pressed='X'; }
            else { clicked.setText("O"); pressed='O'; }
            clicked.setEnabled(false);
            j++;
            switch (view.getId()) {
                case R.id.uno: Tris.set(view,pressed); break;
                case R.id.due: Tris.set(view,pressed); break;
                case R.id.tre: Tris.set(view,pressed); break;
                case R.id.quattro: Tris.set(view,pressed); break;
                case R.id.cinque: Tris.set(view,pressed); break;
                case R.id.sei: Tris.set(view,pressed); break;
                case R.id.sette: Tris.set(view,pressed); break;
                case R.id.otto: Tris.set(view,pressed); break;
                case R.id.nove: Tris.set(view,pressed); break;
            }

        if(j<9 && Tris.checkVictory(i)) { startActivity(i); finish(); }
        if(j==9) { Tris.pareggio(i); startActivity(i); finish();}
    }


}
