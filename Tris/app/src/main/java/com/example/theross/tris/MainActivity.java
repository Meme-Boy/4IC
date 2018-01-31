package com.example.theross.tris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView[] cells = new TextView[9];
    private boolean pressed[] = new boolean[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View.OnClickListener listener = v -> {
            int pos = Integer.parseInt(String.valueOf(findViewById(v.getId()).getTag().toString().charAt(4))) - 1;
            if (!pressed[pos]) {
                pressed[pos] = true;
                cells[pos].setText("X");
                move();
                if (whoWon() == "X")
                    Toast.makeText(this, "You won", Toast.LENGTH_SHORT).show();
                if (whoWon() == "O")
                    Toast.makeText(this, "I won", Toast.LENGTH_SHORT).show();
            }
        };
        for (int i = 1; i < 10; i++) {
            pressed[i - 1] = false;
            cells[i - 1] = findViewById(getResources().getIdentifier("cell" + i, "id", getPackageName()));
            cells[i - 1].setTag("cell" + i);
            cells[i - 1].setText("");
            cells[i - 1].setOnClickListener(listener);
        }
    }




    private void move(){
        int freeCells = 0;
        for (boolean b : pressed)
            if(!b) freeCells++;
        if(freeCells > 0){
            int cell = new Random().nextInt(freeCells);
            int count = 0;
            for(int i = 0; i < 9; i++) {
                if (!pressed[i])
                    count++;
                if (count - 1 == cell) {
                    cells[i].setText("O");
                    pressed[i] = true;
                    break;
                }
            }
        }
    }

    private String whoWon(){
        if(cells[0].getText() == cells[1].getText() && cells[1].getText() == cells[2].getText() && cells[0].getText() != "")
            return cells[0].getText().toString();
        else{
            if(cells[3].getText() == cells[4].getText() && cells[4].getText() == cells[5].getText() && cells[3].getText() != "")
                return cells[3].getText().toString();
            else{
                if(cells[6].getText() == cells[7].getText() && cells[7].getText() == cells[8].getText() && cells[6].getText() != "")
                    return cells[6].getText().toString();
                else{
                    if(cells[0].getText() == cells[3].getText() && cells[3].getText() == cells[6].getText() && cells[0].getText() != "")
                        return cells[0].getText().toString();
                    else{
                        if(cells[1].getText() == cells[4].getText() && cells[4].getText() == cells[7].getText() && cells[1].getText() != "")
                            return cells[1].getText().toString();
                        else{
                            if(cells[2].getText() == cells[5].getText() && cells[5].getText() == cells[8].getText() && cells[2].getText() != "")
                                return cells[2].getText().toString();
                            else{
                                if(cells[0].getText() == cells[4].getText() && cells[4].getText() == cells[8].getText() && cells[0].getText() != "")
                                    return cells[0].getText().toString();
                                else{
                                    if(cells[2].getText() == cells[4].getText() && cells[4].getText() == cells[6].getText() && cells[2].getText() != "")
                                        return cells[2].getText().toString();
                                    else{
                                        return "";
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
