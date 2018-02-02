package com.servehttp.enterprise.tris.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.servehttp.enterprise.tris.R;

public class FinishedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished);

        TextView textView = findViewById(R.id.wonTextView);
//        textView.setText(getString(R.string.player)
//                + getIntent().getCharExtra("winner",  '-')
//                + "\n" + getString(R.string.won_the_game));
        if(!getIntent().getBooleanExtra("draw", false))
            textView.setText(String.format(getString(R.string.player__won_the_game), getIntent().getCharExtra("winner",  '-')));
        else
            textView.setText(getString(R.string.draw));
    }

    public void onClick(View view){
        Intent intent = null;
        switch(view.getId()){
            case R.id.goToMainMenuButton:
                intent = new Intent(this, MainActivity.class);
                break;
            case R.id.reMatch:
                intent = new Intent(this, GameActivity.class);
                break;
        }
        intent.putExtra("game_mode", getIntent().getIntExtra("game_mode", 0));
        startActivity(intent);
        finish();
    }
}
