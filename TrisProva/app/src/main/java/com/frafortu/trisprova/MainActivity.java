package com.frafortu.trisprova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private TableLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);

        /*Button[][] buttons = new Button[3][3];
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
        tris.play();*/
        Button[] buttons = new Button[9];
        int i = 0;
        buttons[i++] = findViewById(R.id.button0);
        buttons[i++] = findViewById(R.id.button1);
        buttons[i++] = findViewById(R.id.button2);
        buttons[i++] = findViewById(R.id.button3);
        buttons[i++] = findViewById(R.id.button4);
        buttons[i++] = findViewById(R.id.button5);
        buttons[i++] = findViewById(R.id.button6);
        buttons[i++] = findViewById(R.id.button7);
        buttons[i] = findViewById(R.id.button8);
        Tris2 tris2 = new Tris2(MainActivity.this, buttons);
        tris2.play();
        Button reset = new Button(this);
        reset.setText("Start a new match");
        reset.setGravity(2);
        reset.setOnClickListener(event -> startActivity(new Intent(MainActivity.this,MainActivity.class)));
        layout.addView(reset);
    }

}
