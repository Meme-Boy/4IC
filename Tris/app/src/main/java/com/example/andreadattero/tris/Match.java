package com.example.andreadattero.tris;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class Match extends AppCompatActivity {
    ImageButton[][] buttons;
    TextView vittoria;
    int[][] matricePosizoni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        vittoria=findViewById(R.id.testo);
        buttons = new ImageButton[][]{
                {findViewById(R.id.button0), findViewById(R.id.button1), findViewById(R.id.button2)},
                {findViewById(R.id.button3), findViewById(R.id.button4), findViewById(R.id.button5)},
                {findViewById(R.id.button6), findViewById(R.id.button7), findViewById(R.id.button8)}
        };
        matricePosizoni= new int[][] {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        Button home = findViewById(R.id.home);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void buttonTris(View view){
        int button= Integer.parseInt(((ImageButton) view).getTransitionName()+"");
        if(!checkComputerVictory() && !checkPlayerVictory()) {
            disableButton(button);
        }
        if(!checkPlayerVictory() && !checkComputerVictory()) {
            computerStrikes();
        }

    }

    private boolean checkComputerVictory() {
        if(matricePosizoni[0][0]==-1 &&matricePosizoni[1][1]==-1  &&matricePosizoni[2][2]==-1 ){
            vittoria.setText("Computer Ha Vinto BUUUUUU!");
            return true;
        }
        else if(matricePosizoni[2][0]==-1  &&matricePosizoni[1][1]==-1  &&matricePosizoni[0][2]==-1 ){
            vittoria.setText("Computer Ha Vinto BUUUUUU!");
            return true;
        }
        else if(matricePosizoni[0][1]==-1  &&matricePosizoni[1][1]==-1  &&matricePosizoni[2][1]==-1 ){
            vittoria.setText("Computer Ha Vinto BUUUUUU!");
            return true;
        }else if(matricePosizoni[1][0]==-1  &&matricePosizoni[1][1]==-1  &&matricePosizoni[1][2]==-1 ){
            vittoria.setText("Computer Ha Vinto BUUUUUU!");
            return true;
        }
        else if(matricePosizoni[0][2]==-1  &&matricePosizoni[1][2]==-1  && matricePosizoni[2][2]==-1 ){
            vittoria.setText("Computer Ha Vinto BUUUUUU!");
            return true;
        }
        else if(matricePosizoni[0][0]==-1  &&matricePosizoni[1][0]==-1 &&matricePosizoni[2][0]==-1 ){
            vittoria.setText("Computer Ha Vinto BUUUUUU!");
            return true;
        }
        else if(matricePosizoni[0][0]==-1  &&matricePosizoni[0][1]==-1  &&matricePosizoni[0][2]==-1 ){
            vittoria.setText("Computer Ha Vinto BUUUUUU!");
            return true;
        }
        else if(matricePosizoni[2][0]==-1  &&matricePosizoni[2][1]==-1  &&matricePosizoni[2][2]==-1 ){
            vittoria.setText("Computer Ha Vinto BUUUUUU!");
            return true;
        }
        return false;
    }

    private boolean checkPlayerVictory() {
        if(matricePosizoni[0][0]==1 &&matricePosizoni[1][1]==1 &&matricePosizoni[2][2]==1){
            vittoria.setText("Player Ha Vinto SEEEEHHH!");
            return true;
        }
        else if(matricePosizoni[2][0]==1 &&matricePosizoni[1][1]==1 &&matricePosizoni[0][2]==1){
            vittoria.setText("Player Ha Vinto SEEEEHHH!");
            return true;
        }
        else if(matricePosizoni[0][1]==1 &&matricePosizoni[1][1]==1 &&matricePosizoni[2][1]==1){
            vittoria.setText("Player Ha Vinto SEEEEHHH!");
            return true;
        }else if(matricePosizoni[1][0]==1 &&matricePosizoni[1][1]==1 &&matricePosizoni[1][2]==1){
            vittoria.setText("Player Ha Vinto SEEEEHHH!");
            return true;
        }
        else if(matricePosizoni[0][2]==1 &&matricePosizoni[1][2]==1 && matricePosizoni[2][2]==1){
            vittoria.setText("Player Ha Vinto SEEEEHHH!");
            return true;
        }
        else if(matricePosizoni[0][0]==1 &&matricePosizoni[1][0]==1&&matricePosizoni[2][0]==1){
            vittoria.setText("Player Ha Vinto SEEEEHHH!");
            return true;
        }
        else if(matricePosizoni[0][0]==1 &&matricePosizoni[0][1]==1 &&matricePosizoni[0][2]==1){
            vittoria.setText("Player Ha Vinto SEEEEHHH!");
            return true;
        }
        else if(matricePosizoni[2][0]==1 &&matricePosizoni[2][1]==1 &&matricePosizoni[2][2]==1){
            vittoria.setText("Player Ha Vinto SEEEEHHH!");
            return true;
        }
        return false;
    }

    public void disableButton(int button){

        if(button<=3){
            matricePosizoni[0][button-1]=1;
            buttons[0][button-1].setEnabled(false);
            buttons[0][button-1].setImageResource(R.drawable.circle);
        }
        else if(button>3 && button<=6){
            matricePosizoni[1][button-4]=1;
            buttons[1][button-4].setEnabled(false);
            buttons[1][button-4].setImageResource(R.drawable.circle);
        }
        else if(button>6 && button<=9){
            matricePosizoni[2][button-7]=1;
            buttons[2][button-7].setEnabled(false);
            buttons[2][button-7].setImageResource(R.drawable.circle);
        }
    }

    public void computerStrikes(){
        boolean isClicked=false;
        while(!isClicked) {
            int x = new Random().nextInt(3);
            int y = new Random().nextInt(3);
            System.out.println("ciao");
            if(checkIfRemainOnlyOneButton()) {
                if (buttons[x][y].isEnabled()) {
                    matricePosizoni[x][y] = -1;
                    buttons[x][y].setEnabled(false);
                    buttons[x][y].setImageResource(R.drawable.x);
                    isClicked = true;
                }
                checkComputerVictory();
            }else{
                break;
            }
        }
    }

    public boolean checkIfRemainOnlyOneButton(){
        int x=-1,y=-1;
        int counter=0;
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if(matricePosizoni[i][j]==0){
                    counter++;
                    x=i;
                    y=j;
                }

            }
        }
        return counter>1;
    }

    public int[] getLastButtonCoords(){
        int x=0,y=0;
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if(matricePosizoni[i][j]==0){
                    x=i;
                    y=j;
                }

            }
        }
        return new int[]{x,y};
    }

    public void home(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
}
