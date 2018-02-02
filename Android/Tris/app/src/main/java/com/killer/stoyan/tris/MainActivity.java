package com.killer.stoyan.tris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    TextView textView2;

    private boolean[] condition=new boolean[9];
    private int[] playerOwns= new int[9];
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

        one= findViewById(R.id.button);
        one.setOnClickListener((View.OnClickListener) this);

        two= findViewById(R.id.button2);
        two.setOnClickListener((View.OnClickListener) this);

        three= findViewById(R.id.button3);
        three.setOnClickListener((View.OnClickListener) this);

        four= findViewById(R.id.button4);
        four.setOnClickListener((View.OnClickListener) this);

        five= findViewById(R.id.button5);
        five.setOnClickListener((View.OnClickListener) this);

        six= findViewById(R.id.button6);
        six.setOnClickListener((View.OnClickListener) this);

        seven= findViewById(R.id.button7);
        seven.setOnClickListener((View.OnClickListener) this);

        eight= findViewById(R.id.button8);
        eight.setOnClickListener((View.OnClickListener) this);

        nine= findViewById(R.id.button9);
        nine.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button:
                if(!condition[0]) {
                    if(player==true){
                        playerOwns[0]=1;
                        one.setText("X");
                    }else {
                        playerOwns[0]=-1;
                        one.setText("O");
                    }
                    condition[0] = true;
                    check();
                    player=!player;
                }
                break;

            case R.id.button2:
                if(!condition[1]) {
                    if(player==true){
                        playerOwns[1]=1;
                        two.setText("X");
                    }else {
                        playerOwns[1]=-1;
                        two.setText("O");
                    }
                    condition[1]=true;
                    check();
                    player=!player;
                }
                break;

            case R.id.button3:
                if(!condition[2]) {
                    if(player==true){
                        playerOwns[2]=1;
                        three.setText("X");
                    }else {
                        playerOwns[2]=-1;
                        three.setText("O");
                    }
                    condition[2]=true;
                    check();
                    player=!player;
                }
                break;

            case R.id.button4:
                if(!condition[3]) {
                    if (player == true) {
                        playerOwns[3] = 1;
                        four.setText("X");
                    } else {
                        playerOwns[3] = -1;
                        four.setText("O");
                    }
                    condition[3] = true;
                    check();
                    player=!player;
                }
                break;

            case R.id.button5:
                if(!condition[4]) {
                    if (player == true) {
                        playerOwns[4] = 1;
                        five.setText("X");
                    } else {
                        playerOwns[4] = -1;
                        five.setText("O");
                    }
                    condition[4] = true;
                    check();
                    player=!player;
                }
                break;

            case R.id.button6:
                if(!condition[5]) {
                    if (player == true) {
                        playerOwns[5] = 1;
                        six.setText("X");
                    } else {
                        playerOwns[5] = -1;
                        six.setText("O");
                    }
                    condition[5] = true;
                    check();
                    player=!player;
                }
                break;
            case R.id.button7:
                if(!condition[6]) {
                    if (player == true) {
                        playerOwns[6] = 1;
                        seven.setText("X");
                    } else {
                        playerOwns[6] = -1;
                        seven.setText("O");
                    }
                    condition[6] = true;
                    check();
                    player=!player;
                }
                break;
            case R.id.button8:
                if(!condition[7]) {
                    if (player == true) {
                        playerOwns[7] = 1;
                        eight.setText("X");
                    } else {
                        playerOwns[7] = -1;
                        eight.setText("O");
                    }
                    condition[7] = true;
                    check();
                    player=!player;
                }
                break;
            case R.id.button9:
                if(!condition[8]) {
                    if (player == true) {
                        playerOwns[8] = 1;
                        nine.setText("X");
                    } else {
                        playerOwns[8] = -1;
                        nine.setText("O");
                    }
                    condition[8] = true;
                    check();
                    player=!player;
                }
                break;

            default:
                break;
        }
    }

    void check() {

        if (playerOwns[0] == 1 && playerOwns[1] == 1 && playerOwns[2] == 1 ||
                playerOwns[3] == 1 && playerOwns[4] == 1 && playerOwns[5] == 1 ||
                playerOwns[6] == 1 && playerOwns[7] == 1 && playerOwns[8] == 1 ||
                playerOwns[0] == 1 && playerOwns[3] == 1 && playerOwns[6] == 1 ||
                playerOwns[1] == 1 && playerOwns[4] == 1 && playerOwns[7] == 1 ||
                playerOwns[2] == 1 && playerOwns[5] == 1 && playerOwns[8] == 1 ||
                playerOwns[0] == 1 && playerOwns[4] == 1 && playerOwns[8] == 1 ||
                playerOwns[2] == 1 && playerOwns[4] == 1 && playerOwns[6] == 1) {
            textView2.setText("player one wins!");
        }
        if (
                playerOwns[0] == -1 && playerOwns[1] == -1 && playerOwns[2] == -1 ||
                        playerOwns[3] == -1 && playerOwns[4] == -1 && playerOwns[5] == -1 ||
                        playerOwns[6] == -1 && playerOwns[7] == -1 && playerOwns[8] == -1 ||
                        playerOwns[0] == -1 && playerOwns[3] == -1 && playerOwns[6] == -1 ||
                        playerOwns[1] == -1 && playerOwns[4] == -1 && playerOwns[7] == -1 ||
                        playerOwns[2] == -1 && playerOwns[5] == -1 && playerOwns[8] == -1 ||
                        playerOwns[0] == -1 && playerOwns[4] == -1 && playerOwns[8] == -1 ||
                        playerOwns[2] == -1 && playerOwns[4] == -1 && playerOwns[6] == -1) {
            textView2.setText("player two wins!");
        }
    }
}
