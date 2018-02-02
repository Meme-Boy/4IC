package com.servehttp.enterprise.tris.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.servehttp.enterprise.tris.R;
import com.servehttp.enterprise.tris.game.Player;
import com.servehttp.enterprise.tris.game.Tris;

public class GameActivity extends AppCompatActivity {
    private boolean round;
    private Tris game;
    private Player player1;
    private Player player2;
    private int gameMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initializeGame();
    }

    private void initializeGame() {
        game = new Tris();
        player1  = new Player(true, 'X', game);
        player2  = new Player(true, 'O', game);
        round = true;
        gameMode = getIntent().getIntExtra("game_mode", 0);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.button00:
                if(move(round ?player1:player2, 0, 0))
                    if(gameMode == Tris.HUMAN_VS_MACHINE){
                        int randomPosition = game.getRandomValidPosition();
                        int x = randomPosition/3;
                        int y = randomPosition%3;
//                        Toast.makeText(getApplicationContext(), "x: " + x + " y: " + y, Toast.LENGTH_SHORT).show();
                        move(round ?player1:player2, x, y);
                    }
                break;
            case R.id.button01:
                if(move(round ?player1:player2, 0, 1))
                    if(gameMode == Tris.HUMAN_VS_MACHINE){
                        int randomPosition = game.getRandomValidPosition();
                        int x = randomPosition/3;
                        int y = randomPosition%3;
//                        Toast.makeText(getApplicationContext(), "x: " + x + " y: " + y, Toast.LENGTH_SHORT).show();
                        move(round ?player1:player2, x, y);
                    }
                break;
            case R.id.button02:
                if(move(round ?player1:player2, 0, 2))
                    if(gameMode == Tris.HUMAN_VS_MACHINE){
                        int randomPosition = game.getRandomValidPosition();
                        int x = randomPosition/3;
                        int y = randomPosition%3;
//                        Toast.makeText(getApplicationContext(), "x: " + x + " y: " + y, Toast.LENGTH_SHORT).show();
                        move(round ?player1:player2, x, y);
                    }
                break;
            case R.id.button10:
                if(move(round ?player1:player2, 1, 0))
                    if(gameMode == Tris.HUMAN_VS_MACHINE){
                        int randomPosition = game.getRandomValidPosition();
                        int x = randomPosition/3;
                        int y = randomPosition%3;
//                        Toast.makeText(getApplicationContext(), "x: " + x + " y: " + y, Toast.LENGTH_SHORT).show();
                        move(round ?player1:player2, x, y);
                    }
                break;
            case R.id.button11:
                if(move(round ?player1:player2, 1, 1))
                    if(gameMode == Tris.HUMAN_VS_MACHINE){
                        int randomPosition = game.getRandomValidPosition();
                        int x = randomPosition/3;
                        int y = randomPosition%3;
//                        Toast.makeText(getApplicationContext(), "x: " + x + " y: " + y, Toast.LENGTH_SHORT).show();
                        move(round ?player1:player2, x, y);
                    }
                break;
            case R.id.button12:
                if(move(round ?player1:player2, 1, 2))
                    if(gameMode == Tris.HUMAN_VS_MACHINE){
                        int randomPosition = game.getRandomValidPosition();
                        int x = randomPosition/3;
                        int y = randomPosition%3;
//                        Toast.makeText(getApplicationContext(), "x: " + x + " y: " + y, Toast.LENGTH_SHORT).show();
                        move(round ?player1:player2, x, y);
                    }
                break;
            case R.id.button20:
                if(move(round ?player1:player2, 2, 0))
                    if(gameMode == Tris.HUMAN_VS_MACHINE){
                        int randomPosition = game.getRandomValidPosition();
                        int x = randomPosition/3;
                        int y = randomPosition%3;
//                        Toast.makeText(getApplicationContext(), "x: " + x + " y: " + y, Toast.LENGTH_SHORT).show();
                        move(round ?player1:player2, x, y);
                    }
                break;
            case R.id.button21:
                if(move(round ?player1:player2, 2, 1))
                    if(gameMode == Tris.HUMAN_VS_MACHINE){
                        int randomPosition = game.getRandomValidPosition();
                        int x = randomPosition/3;
                        int y = randomPosition%3;
//                        Toast.makeText(getApplicationContext(), "x: " + x + " y: " + y, Toast.LENGTH_SHORT).show();
                        move(round ?player1:player2, x, y);
                    }
                break;
            case R.id.button22:
                if(move(round ?player1:player2, 2, 2))
                    if(gameMode == Tris.HUMAN_VS_MACHINE){
                        int randomPosition = game.getRandomValidPosition();
                        int x = randomPosition/3;
                        int y = randomPosition%3;
//                        Toast.makeText(getApplicationContext(), "x: " + x + " y: " + y, Toast.LENGTH_SHORT).show();
                        move(round ?player1:player2, x, y);
                    }
                break;
            default:
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();

        }
    }

    private void casualMove(){
        if(gameMode == Tris.HUMAN_VS_MACHINE){
            int randomPosition = game.getRandomValidPosition();
            int x = randomPosition/3;
            int y = randomPosition%3;
//                        Toast.makeText(getApplicationContext(), "x: " + x + " y: " + y, Toast.LENGTH_SHORT).show();
            move(round ?player1:player2, x, y);
        }
    }
    private boolean move(Player player, int x, int y){
        if(player.move(x, y)){
            moved(player.getSymbol(), x, y);
            round = !round;
            if(game.hasWinner()){
                won(game.getWinner());
            }
            if(game.isFilled()){
                draw();
            }
            return true;
        }
        return false;
    }
    private void moved(char character, int x, int y){
            TableLayout tableLayout = findViewById(R.id.tableLayout);
            TableRow tableRow = (TableRow)tableLayout.getChildAt(y);
            Button button = (Button)tableRow.getChildAt(x);
            button.setText(String.valueOf(character));
    }

    private void won(Player player){
//        Toast.makeText(getApplicationContext(), player.getSymbol() + " win", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, FinishedActivity.class);
        intent.putExtra("winner", game.getWinner().getSymbol());
        finished(intent);
    }
    private void draw(){
//        Toast.makeText(getApplicationContext(), game.getWinner().getSymbol() + " win", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, FinishedActivity.class);
        intent.putExtra("draw", true);
        finished(intent);
    }
    private void finished(Intent intent){
        intent.putExtra("game_mode", gameMode);
        startActivity(intent);
        finish();
    }
}
