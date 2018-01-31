package com.frafortu.trisprova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button[][] buttons = new Button[3][3];
        int row = 0;
        int column = 0;
        buttons[row][column++] = findViewById(R.id.button0);
        buttons[row][column++] = findViewById(R.id.button1);
        buttons[row++][column] = findViewById(R.id.button2);
        column = 0;
        buttons[row][column++] = findViewById(R.id.button3);
        buttons[row][column++] = findViewById(R.id.button4);
        buttons[row++][column] = findViewById(R.id.button5);
        column = 0;
        buttons[row][column++] = findViewById(R.id.button6);
        buttons[row][column++] = findViewById(R.id.button7);
        buttons[row][column] = findViewById(R.id.button8);
        TrisField tris = new TrisField(buttons,MainActivity.this);
        tris.play();
    }
}
