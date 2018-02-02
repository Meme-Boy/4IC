package com.servehttp.enterprise.tris.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.servehttp.enterprise.tris.R;
import com.servehttp.enterprise.tris.game.Tris;

public class MainActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, GameActivity.class);
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.hvmButton:
                intent.putExtra("game_mode", Tris.HUMAN_VS_MACHINE);
                break;
            case R.id.hvhButton:
                intent.putExtra("game_mode", Tris.HUMAN_VS_HUMAN);
                break;
        }
        startActivity(intent);
//        finish();
    }
}
