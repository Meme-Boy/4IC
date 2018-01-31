package com.example.theross.tris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class EndGame extends AppCompatActivity {
    private TextView greet, description;
    private Button endGame, playAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        greet = findViewById(R.id.greet);
        description = findViewById(R.id.description);
        endGame = findViewById(R.id.exitGame);
        playAgain = findViewById(R.id.playAgain);
        endGame.setOnClickListener( v -> finishAffinity());
        playAgain.setOnClickListener(v -> finish());

        if(this.getIntent().getStringExtra("winner").equals("X")){
            greet.setText(R.string.congratulations);
            description.setText(R.string.winner);
        }
        if(this.getIntent().getStringExtra("winner").equals("O")){
            greet.setText(R.string.laugh);
            description.setText(R.string.looser);
        }
    }
}
