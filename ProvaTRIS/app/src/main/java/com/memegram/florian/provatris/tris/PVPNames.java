package com.memegram.florian.provatris.tris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.memegram.florian.provatris.R;

public class PVPNames extends AppCompatActivity {


    private EditText player1 ;
    private EditText player2;
    private Button startGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pvpnames);

        player1 = (EditText) findViewById(R.id.player1Field);
        player2 = (EditText) findViewById(R.id.player2Field);
        startGame = (Button) findViewById(R.id.startGameButton);

        player1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                startGame.setEnabled(!(player1.getText().toString().isEmpty() || player2.getText().toString().isEmpty()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        player2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                startGame.setEnabled(!(player2.getText().toString().isEmpty() || player1.getText().toString().isEmpty()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public void startGame(View v){

        String p1 = player1.getText().toString();
        String p2 = player2.getText().toString();

      //  if(!vaBene(p1,p2)){
        //    Toast.makeText(this,"I nomi non mi piacciono :/",Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, PVPGame.class);
            i.putExtra("pallina", p1);
            i.putExtra("ics", p2);
            startActivity(i);


    }

    private boolean vaBene(String p1, String p2) {

        int cur;
        // 65 90
        // 97 122
        //48 57
        for (int i=0;i<p1.length();i++){
            cur = (int)p1.charAt(i);
            if      (
                    (cur>=65 && cur<=90) ||     // lettere maiuscole
                            (cur>=97 && cur<=122) ||    // lettere minuscole
                            (cur>=48 && cur<=57)    // numeri
                    );
            else
                return false;
        }

        for (int i=0;i<p2.length();i++){
            cur = (int)p2.charAt(i);
            if      (
                    (cur>=65 && cur<=90) ||     // lettere maiuscole
                            (cur>=97 && cur<=122) ||    // lettere minuscole
                            (cur>=48 && cur<=57)    // numeri
                    );
            else
                return false;
        }

        return p1.equals(p2);
    }
}
