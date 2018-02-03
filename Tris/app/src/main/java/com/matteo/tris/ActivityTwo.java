package com.matteo.tris;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Matteo on 02/02/2018.
 */

public class ActivityTwo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        TextView text =findViewById(R.id.textView);
        Button restart = findViewById(R.id.restart);
        restart.setOnClickListener((View view) -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        });

        if(getIntent().getCharExtra("vincitore",' ')=='v') text.setText("Pareggio"!!);
        else text.setText(getIntent().getCharExtra("vincitore",' ')+" Vince!!!!");
    }
}
