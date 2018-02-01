package gq.francescorossato.tictactoe;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TicTacToe extends AppCompatActivity {
    private TTTGame ticTacToe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        ticTacToe = new TTTGame();

    }


    public void listener(View v){
        boolean hasMoved = ticTacToe.move(Integer.parseInt((String)(v.getTag())));
        if(hasMoved){
            Intent i = new Intent(this, EndGame.class);
            switch (ticTacToe.whoWon()){
                case 'd':
                    i.putExtra("result", "draft");
                    startActivity(i);
                    flush();
                    break;
                case 'X':
                    i.putExtra("result", "X");
                    startActivity(i);
                    flush();
                    break;
                case 'O':
                    i.putExtra("result", "O");
                    startActivity(i);
                    flush();
                    break;
                default:
                    Button b = findViewById(v.getId());
                    b.setText("X");
                    String moved = "button"+String.valueOf(ticTacToe.move());
                    Button pressed = findViewById(getResources().getIdentifier(moved, "id", getPackageName()));
                    pressed.setText("O");
            }
        }
    }

    private void flush(){
        ticTacToe = new TTTGame();
        for(int i = 0; i < 9; i++){
            String buttonName = "button"+String.valueOf(i);
            ((Button)findViewById(getResources().getIdentifier(buttonName, "id", getPackageName()))).setText(" ");
        }
    }
}
