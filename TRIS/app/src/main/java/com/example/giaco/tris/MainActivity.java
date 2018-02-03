package com.example.giaco.tris;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Random;
public class MainActivity extends AppCompatActivity{
    private boolean plyVSpc = true;
    private boolean gameFinished = false;
    private boolean firstTime = true;
    private boolean flag = true;
    private boolean firstPlayer = true;
    private boolean secondPlayer = true;
    private int player_1;
    private int player_2;
    private boolean[][] booleanBoard = {{true, true, true},
            {true, true, true},
            {true, true, true}};
    private int[][] integerBoard = {{0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}};
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            plyVSpc = savedInstanceState.getBoolean("plyVSpc");
            ((Button)findViewById(R.id.gameMode)).setText(plyVSpc ? R.string.gameMode_1 : R.string.gameMode_2);
            gameFinished = savedInstanceState.getBoolean("gameFinished");
            firstTime = savedInstanceState.getBoolean("firstTime");
            flag = savedInstanceState.getBoolean("flag");
            firstPlayer = savedInstanceState.getBoolean("firstPlayer");
            secondPlayer = savedInstanceState.getBoolean("secondPlayer");
            player_1 = savedInstanceState.getInt("player_1");
            player_2 = savedInstanceState.getInt("player_2");
            booleanBoard[0] = savedInstanceState.getBooleanArray("booleanBoard_0");
            booleanBoard[1] = savedInstanceState.getBooleanArray("booleanBoard_1");
            booleanBoard[2] = savedInstanceState.getBooleanArray("booleanBoard_2");
            integerBoard[0] = savedInstanceState.getIntArray("integerBoard_0");
            integerBoard[1] = savedInstanceState.getIntArray("integerBoard_1");
            integerBoard[2] = savedInstanceState.getIntArray("integerBoard_2");
            rebuild();
            count = savedInstanceState.getInt("count");
        }else{
            GradientDrawable gd = getNewGradientDrawable();
            gd.setColor(getResources().getColor(R.color.defaultColor));
            for(int i=0;i<9;i++)
                findViewById(R.id.c0x0+i).setBackgroundDrawable(gd);
        }
    }
    private void rebuild(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(integerBoard[i][j] == 1 || integerBoard[i][j] == 2){
                    GradientDrawable gd = getNewGradientDrawable();
                    gd.setColor(integerBoard[i][j] == 1 ? player_1 : player_2);
                    (findViewById(getResources().getIdentifier("c" + i + "x" + j, "id",
                            this.getPackageName()))).setBackgroundDrawable(gd);
                }
            }
        }
    }
    private GradientDrawable getNewGradientDrawable(){
        GradientDrawable gd = new GradientDrawable();
        gd.setCornerRadius(80);
        gd.setStroke(8, getResources().getColor(R.color.c9));
        return gd;
    }
    public void onClick(View view){
        if(view.getId() == R.id.exitGame){
            finish();
        }else if(view.getId() == R.id.newGame){
            newGame();
        }else if(view.getId() == R.id.gameMode){
            plyVSpc = !plyVSpc;
            ((Button)findViewById(R.id.gameMode)).setText(plyVSpc ? R.string.gameMode_1 : R.string.gameMode_2);
            newGame();
        }else if(!gameFinished){
            if(plyVSpc){
                playerAction((Button)view);
                computerAction();
            }else{
                playerAction((Button)view);
            }
        }
    }
    private void playerAction(Button button){
        int row = Integer.parseInt("" + button.getResources().getResourceEntryName(button.getId()).charAt(1));
        int column = Integer.parseInt("" + button.getResources().getResourceEntryName(button.getId()).charAt(3));
        if(booleanBoard[row][column]){
            if(firstTime){
                int color = randomColor();
                if(color == player_1)
                    color = randomColor();
                if(firstPlayer){
                    player_1 = color;
                    firstPlayer = false;
                }else if(secondPlayer){
                    player_2 = color;
                    secondPlayer = false;
                    firstTime = false;
                }
            }
            GradientDrawable gd = getNewGradientDrawable();
            gd.setColor(flag ? player_1 : player_2);
            button.setBackgroundDrawable(gd);
            booleanBoard[row][column] = false;
            integerBoard[row][column] = flag ? 1 : 2;
            if(flag)
                count++;
            if(count > 2)
                checkResult(flag ? 1 : 2);
            flag = !flag;
        }
    }
    private void computerAction(){
        if(!gameFinished && !flag){
            if(firstTime){
                int color = randomColor();
                while(color == player_1)
                    color = randomColor();
                player_2 = color;
                secondPlayer = false;
                firstTime = false;
            }
            int results[] = checkRows(2);
            if(results[0] == -1){
                results = checkColumns(2);
                if(results[0] == -1){
                    results = checkDiagonal(2);
                    if(results[0] == -1){
                        results = checkRows(1);
                        if(results[0] == -1){
                            results = checkColumns(1);
                            if(results[0] == -1){
                                results = checkDiagonal(1);
                                if(results[0] == -1){
                                    results = checkSpecialCasesAndNormalMoves();
                                }
                            }
                        }
                    }
                }
            }
            GradientDrawable gd = getNewGradientDrawable();
            gd.setColor(player_2);
            findViewById(getResources().getIdentifier("c" + results[0] + "x" + results[1], "id",
                    this.getPackageName())).setBackgroundDrawable(gd);
            booleanBoard[results[0]][results[1]] = false;
            integerBoard[results[0]][results[1]] = 2;
            if(count > 2)
                checkResult(2);
            flag = !flag;
        }
    }
    private void newGame(){
        booleanBoard = new boolean[][]{{true, true, true},
                {true, true, true},
                {true, true, true}};
        integerBoard = new int[][]{{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        GradientDrawable gd = getNewGradientDrawable();
        gd.setColor(getResources().getColor(R.color.defaultColor));
        for(int i=0;i<9;i++)
            findViewById(R.id.c0x0+i).setBackgroundDrawable(gd);
        firstPlayer = true;
        secondPlayer = true;
        flag = true;
        firstTime = true;
        count = 0;
        gameFinished = false;
    }
    private int randomColor(){
        return getResources().getColor(R.color.c1 + new Random().nextInt(9));
    }
    private void checkResult(int player){
        boolean b1 = integerBoard[0][0] == player && integerBoard[0][1] == player && integerBoard[0][2] == player;
        boolean b2 = integerBoard[1][0] == player && integerBoard[1][1] == player && integerBoard[1][2] == player;
        boolean b3 = integerBoard[2][0] == player && integerBoard[2][1] == player && integerBoard[2][2] == player;
        boolean b4 = integerBoard[0][0] == player && integerBoard[1][0] == player && integerBoard[2][0] == player;
        boolean b5 = integerBoard[0][1] == player && integerBoard[1][1] == player && integerBoard[2][1] == player;
        boolean b6 = integerBoard[0][2] == player && integerBoard[1][2] == player && integerBoard[2][2] == player;
        boolean b7 = integerBoard[0][0] == player && integerBoard[1][1] == player && integerBoard[2][2] == player;
        boolean b8 = integerBoard[2][0] == player && integerBoard[1][1] == player && integerBoard[0][2] == player;
        if(b1 | b2 | b3 | b4 | b5 | b6 | b7 | b8){
            if(plyVSpc)
                Toast.makeText(this, player == 2 ? "You lost" : "You won", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "Player " + player + " won", Toast.LENGTH_LONG).show();
            gameFinished = true;
        }else{
            boolean temp = true;
            for(int[] row : integerBoard){
                for(int value : row){
                    if(value == 0)
                        temp = false;
                }
            }
            if(temp){
                Toast.makeText(this, "Draw", Toast.LENGTH_LONG).show();
                gameFinished = true;
            }
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean("plyVSpc", plyVSpc);
        savedInstanceState.putBoolean("gameFinished", gameFinished);
        savedInstanceState.putBoolean("firstTime", firstTime);
        savedInstanceState.putBoolean("flag", flag);
        savedInstanceState.putBoolean("firstPlayer", firstPlayer);
        savedInstanceState.putBoolean("secondPlayer", secondPlayer);
        savedInstanceState.putInt("player_1", player_1);
        savedInstanceState.putInt("player_2", player_2);
        savedInstanceState.putBooleanArray("booleanBoard_0", booleanBoard[0]);
        savedInstanceState.putBooleanArray("booleanBoard_1", booleanBoard[1]);
        savedInstanceState.putBooleanArray("booleanBoard_2", booleanBoard[2]);
        savedInstanceState.putIntArray("integerBoard_0", integerBoard[0]);
        savedInstanceState.putIntArray("integerBoard_1", integerBoard[1]);
        savedInstanceState.putIntArray("integerBoard_2", integerBoard[2]);
        savedInstanceState.putInt("count", count);
    }
    private int[] checkRows(int player){
        int r = -1, c = -1;
        if(integerBoard[1][1] == player && integerBoard[1][2] == player && booleanBoard[1][0]){
            r = 1;
            c = 0;
        }else if(integerBoard[1][0] == player && integerBoard[1][1] == player && booleanBoard[1][2]){
            r = 1;
            c = 2;
        }else if(integerBoard[2][1] == player && integerBoard[2][2] == player && booleanBoard[2][0]){
            r = 2;
            c = 0;
        }else if(integerBoard[2][0] == player && integerBoard[2][1] == player && booleanBoard[2][2]){
            r = 2;
            c = 2;
        }else if(integerBoard[0][1] == player && integerBoard[0][2] == player && booleanBoard[0][0]){
            r = 0;
            c = 0;
        }else if(integerBoard[0][0] == player && integerBoard[0][1] == player && booleanBoard[0][2]){
            r = 0;
            c = 2;
        }else if(integerBoard[0][0] == player && integerBoard[0][2] == player && booleanBoard[0][1]){
            r = 0;
            c = 1;
        }else if(integerBoard[2][0] == player && integerBoard[2][2] == player && booleanBoard[2][1]){
            r = 2;
            c = 1;
        }
        return new int[]{r, c};
    }
    private int[] checkColumns(int player){
        int r = -1, c = -1;
        if(integerBoard[0][0] == player && integerBoard[1][0] == player && booleanBoard[2][0]){
            r = 2;
            c = 0;
        }else if(integerBoard[2][0] == player && integerBoard[1][0] == player && booleanBoard[0][0]){
            r = 0;
            c = 0;
        }else if(integerBoard[0][2] == player && integerBoard[1][2] == player && booleanBoard[2][2]){
            r = 2;
            c = 2;
        }else if(integerBoard[2][2] == player && integerBoard[1][2] == player && booleanBoard[0][2]){
            r = 0;
            c = 2;
        }else if(integerBoard[0][1] == player && integerBoard[1][1] == player && booleanBoard[2][1]){
            r = 2;
            c = 1;
        }else if(integerBoard[2][1] == player && integerBoard[1][1] == player && booleanBoard[0][1]){
            r = 0;
            c = 1;
        }else if(integerBoard[0][0] == player && integerBoard[2][0] == player && booleanBoard[1][0]){
            r = 1;
            c = 0;
        }else if(integerBoard[0][2] == player && integerBoard[2][2] == player && booleanBoard[1][2]){
            r = 1;
            c = 2;
        }
        return new int[]{r, c};
    }
    private int[] checkDiagonal(int player){
        int r = -1, c = -1;
        if(integerBoard[2][0] == player && integerBoard[1][1] == player && booleanBoard[0][2]){
            r = 0;
            c = 2;
        }else if(integerBoard[1][1] == player && integerBoard[0][2] == player && booleanBoard[2][0]){
            r = 2;
            c = 0;
        }else if(integerBoard[0][0] == player && integerBoard[1][1] == player && booleanBoard[2][2]){
            r = 2;
            c = 2;
        }else if(integerBoard[1][1] == player && integerBoard[2][2] == player && booleanBoard[0][0]){
            r = 0;
            c = 0;
        }
        return new int[]{r, c};
    }
    private int[] checkSpecialCasesAndNormalMoves(){
        int r, c;
        if(integerBoard[0][1] == 1 && integerBoard[2][2] == 1 && booleanBoard[0][2]){
            r = 0;
            c = 2;
        }else if(integerBoard[1][1] == 1 && integerBoard[0][2] == 1 && integerBoard[2][2] == 1){
            r = 0;
            c = 1;
            if(!booleanBoard[r][c]){
                r = 2;
                c = 1;
            }
        }else if(integerBoard[1][0] == 1 && integerBoard[2][1] == 1){
            r = 0;
            c = 0;
            if(!booleanBoard[r][c]){
                r = 2;
                c = 2;
            }
        }else if(integerBoard[2][1] == 1 && integerBoard[1][2] == 1){
            r = 0;
            c = 2;
            if(!booleanBoard[r][c]){
                r = 2;
                c = 0;
            }
        }else if(integerBoard[1][0] == 1 && integerBoard[0][1] == 1){
            r = 0;
            c = 2;
            if(!booleanBoard[r][c]){
                r = 2;
                c = 0;
            }
        }else if(integerBoard[0][1] == 1 && integerBoard[1][2] == 1){
            r = 2;
            c = 2;
            if(!booleanBoard[r][c]){
                r = 0;
                c = 0;
            }
        }else if(integerBoard[2][0] == 1 && integerBoard[1][2] == 1 && booleanBoard[0][2]){
            r = 0;
            c = 2;
        }else if(integerBoard[1][0] == 1 && integerBoard[2][2] == 1 && booleanBoard[0][0]){
            r = 0;
            c = 0;
        }else if(integerBoard[0][0] == 1 && integerBoard[1][2] == 1 && booleanBoard[2][2]){
            r = 2;
            c = 2;
        }else if(integerBoard[0][1] == 1 && integerBoard[2][2] == 1 && booleanBoard[2][0]){
            r = 2;
            c = 0;
        }else if(integerBoard[0][2] == 1 && integerBoard[1][0] == 1){
            r = 0;
            c = 0;
            if(!booleanBoard[r][c]){
                r = 2;
                c = 0;
            }
        }else if(integerBoard[1][1] == 2 && integerBoard[1][2] == 0){
            r = 1;
            c = 2;
        }else{
            r = 1;
            c = 1;
            if(!booleanBoard[r][c]){
                r = 0;
                c = 0;
                if(!booleanBoard[r][c]){
                    r = 0;
                    c = 2;
                }
            }
        }
        return new int[]{r, c};
    }
}