package com.example.marco.cassaforte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView psw=findViewById(R.id.psw);

        final String PASSWORD="1425";

        verificaPassword(findViewById(R.id.uno),PASSWORD);
        verificaPassword(findViewById(R.id.due),PASSWORD);
        verificaPassword(findViewById(R.id.tre),PASSWORD);
        verificaPassword(findViewById(R.id.quattro),PASSWORD);
        verificaPassword(findViewById(R.id.cinque),PASSWORD);
        verificaPassword(findViewById(R.id.sei),PASSWORD);
        verificaPassword(findViewById(R.id.sette),PASSWORD);
        verificaPassword(findViewById(R.id.otto),PASSWORD);
        verificaPassword(findViewById(R.id.nove),PASSWORD);
        verificaPassword(findViewById(R.id.zero),PASSWORD);

        Intent i = new Intent(this,ActivityTwo.class);

        Button ok = findViewById(R.id.OK);
        ok.setOnClickListener((View view) -> {
            if(psw.getText().toString().equals(PASSWORD)) {
                Toast.makeText(this, "Password trovata", Toast.LENGTH_LONG).show();
                startActivity(i);
            } else
                Toast.makeText(this, "Password sbagliata", Toast.LENGTH_LONG).show();
        });

        Button del = findViewById(R.id.del);
        del.setOnClickListener((View view) -> {
            if(psw.getText().toString().length()!=0) {
                psw.setText(psw.getText().toString().substring(0, psw.length() - 1));
                psw.setTextColor(getResources().getColor(R.color.red));
            }
        });
    }

    public void verificaPassword(Button b,String p){

        TextView psw=findViewById(R.id.psw);

        b.setOnClickListener((View view) -> {
            psw.setText(psw.getText().toString()+b.getText());
            if(psw.getText().toString().equals(p))
                psw.setTextColor(getResources().getColor(R.color.green));
            else
                psw.setTextColor(getResources().getColor(R.color.red));
        });
    }
}
