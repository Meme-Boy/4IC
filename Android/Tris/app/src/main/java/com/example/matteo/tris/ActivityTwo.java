package com.example.matteo.tris;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        TextView testo =findViewById(R.id.textView);
        Button riavvia = findViewById(R.id.restart);

        riavvia.setOnClickListener((View view) -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        });

        if(getIntent().getStringExtra("winner").equals("none")) testo.setText("Pareggio");
        else testo.setText("Ha Vinto il Giocatore "+getIntent().getStringExtra("winner"));
    }
}
