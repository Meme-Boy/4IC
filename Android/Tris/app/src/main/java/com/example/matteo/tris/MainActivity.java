package com.example.matteo.tris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int j=0;
    String[][] btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = new String[][] {
                {"","",""},
                {"","",""},
                {"","",""}
        };

    public void clickListener(Button b) {
        b.setOnClickListener((View view) -> {
            if (b.getText().equals("")) {
                if (j % 2 == 0) b.setText("X");
                else b.setText("O");
                j++;
            }

            Intent i = new Intent(this,ActivityTwo.class);
            if(j<9) checkVictory(i);
            else { i.putExtra("winner","none"); startActivity(i);}
        });
    }

    */

    public void clickListener(View view){

        Button premuto = (Button)(view);

        if(premuto.getText().equals("")) {
            if (j % 2 == 0) premuto.setText("X");
            else premuto.setText("O");
            j++;
            switch (premuto.getId()) {
                case R.id.uno: btn[0][0] = premuto.getText().toString();
                case R.id.due: btn[0][1] = premuto.getText().toString();
                case R.id.tre: btn[0][2] = premuto.getText().toString();
                case R.id.quattro: btn[1][0] = premuto.getText().toString();
                case R.id.cinque: btn[1][1] = premuto.getText().toString();
                case R.id.sei: btn[1][2] = premuto.getText().toString();
                case R.id.sette: btn[2][0] = premuto.getText().toString();
                case R.id.otto: btn[2][1] = premuto.getText().toString();
                case R.id.nove: btn[2][2] = premuto.getText().toString();
            }
        }

        Intent i = new Intent(this,ActivityTwo.class);
        if(j<9) controlloVittoria(i);
        else { i.putExtra("winner","none"); startActivity(i);}

    }

    public void controlloVittoria(Intent i){
        if(btn[0][0].equals(btn[0][1]) && btn[0][0].equals(btn[0][2]) && !btn[0][0].equals("")) { i.putExtra("winner",btn[0][0]) ; startActivity(i); finish(); }
        if(btn[1][0].equals(btn[1][1]) && btn[1][0].equals(btn[2][2]) && !btn[1][0].equals("")) { i.putExtra("winner",btn[0][0]) ; startActivity(i); finish(); }
        if(btn[2][0].equals(btn[2][1]) && btn[2][0].equals(btn[2][2]) && !btn[2][0].equals("")) { i.putExtra("winner",btn[0][0]) ; startActivity(i); finish(); }

        if(btn[0][0].equals(btn[1][0]) && btn[0][0].equals(btn[2][0]) && !btn[0][0].equals("")) { i.putExtra("winner",btn[0][0]) ; startActivity(i); finish(); }
        if(btn[0][1].equals(btn[1][1]) && btn[0][1].equals(btn[2][1]) && !btn[0][1].equals("")) { i.putExtra("winner",btn[0][0]) ; startActivity(i); finish(); }
        if(btn[0][2].equals(btn[1][2]) && btn[0][2].equals(btn[2][2]) && !btn[0][2].equals("")) { i.putExtra("winner",btn[0][0]) ; startActivity(i); finish(); }

        if(btn[0][0].equals(btn[1][1]) && btn[0][0].equals(btn[2][2]) && !btn[0][0].equals("")) { i.putExtra("winner",btn[0][0]) ; startActivity(i); finish(); }
        if(btn[0][2].equals(btn[1][1]) && btn[0][0].equals(btn[2][0]) && !btn[0][2].equals("")) { i.putExtra("winner",btn[0][0]) ; startActivity(i); finish(); }

    }

}
