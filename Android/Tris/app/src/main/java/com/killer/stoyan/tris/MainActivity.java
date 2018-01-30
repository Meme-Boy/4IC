package com.killer.stoyan.tris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private boolean player = true;
    //true=X false=O
    private int[] data= new int[9];
    /*data prseo da Florian
     *   0   1   2
     *   3   4   5
     *   6   7   8
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    Button btn =findViewById(R.id.button);

    public void onClick(View view) {
        //da aggiungere blocco bottone dopo schiacciato
        if(player==true)btn.setText("X");
        else btn.setText("O");
        player=!player;
    }
    //da aggiungere condizionde vittoria usando blocco bottone true+activity victory
}
