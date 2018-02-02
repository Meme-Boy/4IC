package gq.francescorossato.tictactoe;

import android.content.Intent;
import android.os.Handler;
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
        if(hasMoved) {
            Button b = findViewById(v.getId());
            b.setText("X");
            String moved = "button"+String.valueOf(ticTacToe.move());
            Button pressed = findViewById(getResources().getIdentifier(moved, "id", getPackageName()));
            if(pressed != null)
                pressed.setText("O");
            winner();
        }
    }

    private void winner(){
        Intent i;
        switch (ticTacToe.whoWon()){
            case 'd':
                i = new Intent(this, EndGame.class);
                i.putExtra("result", "draft");
                startActivity(i);
                flush();
                break;
            case 'X':
                i = new Intent(this, EndGame.class);
                i.putExtra("result", "X");
                startActivity(i);
                flush();
                break;
            case 'O':
                new Handler().postDelayed(() -> {
                    Intent intent = new Intent(TicTacToe.this, EndGame.class);
                    intent.putExtra("result", "O");
                    startActivity(intent);
                    flush();
                }, 1000);
                break;
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
