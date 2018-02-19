package scaggiante.federico.tris5;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity extends AppCompatActivity {
    int gameMode;
    Tris tris;
    String p1="x";
    String p2="o";
    String p;
    String pos;
    AlertDialog.Builder dlgAlert;
    int turn;
    Button bq2;
    AlertDialog a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //creo socket

        initializeGame();
    }
    private void initializeGame() {
        gameMode = getIntent().getIntExtra("gameMode", 0);
        switch(gameMode){
            case 0:
                this.setTitle(getString(R.string.easy));
                break;
            case 1:
                this.setTitle(getString(R.string.home));
                break;
            case 2:
                this.setTitle(getString(R.string.online));
                break;
            case 3:
                this.setTitle(getString(R.string.difficult));
                break;
        }
        tris=new Tris();
        refresh();
        p=p1;
        turn=0;
        //bottoni come cliccabili
        attivaBtn();
    }
    public void onClick(View view) {
        if(turn%2==0){
            p=p1;
        }else{
            p=p2;
        }
        if(((Button)findViewById(view.getId())).getText().toString().equals(" ")){
            pos=""+view.getTag();
            switch(pos){
                case "0":
                    pos="00";
                    break;
                case "1":
                    pos="01";
                    break;
                case "2":
                    pos="02";
                    break;
            }
            int ix=Integer.parseInt(pos.substring(0,1));
            int jx=Integer.parseInt(pos.substring(1,2));
            tris.set(ix, jx, p);
            refresh();
            if (tris.getWinner() == "o") {
                newAllert("o");
            }else if(tris.getWinner()=="x") {
                newAllert("x");
            } else if (tris.isFull()) {
                newAllert("d");
            } else {
                if(gameMode==0){
                    bloccaBtn();
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tris.makeEasyMove();
                            refresh();
                            if (tris.getWinner() == "o") {
                                newAllert("o");
                            } else if (tris.isFull()) {
                                newAllert("d");
                            }
                            attivaBtn();
                        }
                    }, 400);
                }
                if(gameMode==1){
                    turn++;
                }
                if(gameMode==2){

                }
                if(gameMode==3){
                    bloccaBtn();
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tris.makePerfectMove();
                            refresh();
                            if (tris.getWinner() == "o") {
                                newAllert("o");
                            } else if (tris.isFull()) {
                                newAllert("d");
                            }
                            attivaBtn();
                        }
                    }, 400);
                }
            }
        }
    }
    public void newAllert(String message){
        if(message=="x") {
            message=getString(R.string.x_wins);
        }
        if(message=="o"){
            message=getString(R.string.o_wins);
        }
        if(message=="d"){
            message=getString(R.string.draw);
        }
        dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage(R.string.restart);
        dlgAlert.setTitle(message);
        dlgAlert.setCancelable(true);
        dlgAlert.setPositiveButton("restart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                initializeGame();
            }
        });
        a=dlgAlert.create();
        a.show();
        bq2 = a.getButton(DialogInterface.BUTTON_POSITIVE);
        bq2.setTextColor(Color.BLUE);
        //blocco il tocco dei bottoni
        bloccaBtn();
    }
    public void refresh(){
        tris.getBoard();
        String[][] board =tris.getBoard();
        ((Button)findViewById(R.id.button1)).setText(board[0][0]);
        ((Button)findViewById(R.id.button2)).setText(board[0][1]);
        ((Button)findViewById(R.id.button3)).setText(board[0][2]);
        ((Button)findViewById(R.id.button4)).setText(board[1][0]);
        ((Button)findViewById(R.id.button5)).setText(board[1][1]);
        ((Button)findViewById(R.id.button6)).setText(board[1][2]);
        ((Button)findViewById(R.id.button7)).setText(board[2][0]);
        ((Button)findViewById(R.id.button8)).setText(board[2][1]);
        ((Button)findViewById(R.id.button9)).setText(board[2][2]);
    }
    public void bloccaBtn(){
        ((Button)findViewById(R.id.button1)).setClickable(false);
        ((Button)findViewById(R.id.button2)).setClickable(false);
        ((Button)findViewById(R.id.button3)).setClickable(false);
        ((Button)findViewById(R.id.button4)).setClickable(false);
        ((Button)findViewById(R.id.button5)).setClickable(false);
        ((Button)findViewById(R.id.button6)).setClickable(false);
        ((Button)findViewById(R.id.button7)).setClickable(false);
        ((Button)findViewById(R.id.button8)).setClickable(false);
        ((Button)findViewById(R.id.button9)).setClickable(false);
    }
    public void attivaBtn(){
        ((Button)findViewById(R.id.button1)).setClickable(true);
        ((Button)findViewById(R.id.button2)).setClickable(true);
        ((Button)findViewById(R.id.button3)).setClickable(true);
        ((Button)findViewById(R.id.button4)).setClickable(true);
        ((Button)findViewById(R.id.button5)).setClickable(true);
        ((Button)findViewById(R.id.button6)).setClickable(true);
        ((Button)findViewById(R.id.button7)).setClickable(true);
        ((Button)findViewById(R.id.button8)).setClickable(true);
        ((Button)findViewById(R.id.button9)).setClickable(true);
    }
}
