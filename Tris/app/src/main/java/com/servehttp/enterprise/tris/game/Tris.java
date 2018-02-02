package com.servehttp.enterprise.tris.game;

import java.util.Random;

/**
 * Created by davide on 31/01/18.
 */

public class Tris {
    public static int HUMAN_VS_MACHINE = 2;//"hvm";
    public static int HUMAN_VS_HUMAN= 1;//"hvm";

    private Player[][] board;
//    protected Player[][] board;
    private Player winner;

    public Tris(){
        board = new Player[3][3];
    }

    public boolean move(Player player, int x, int y){
        if(!verifyMove(x, y)) return false;
        board[y][x] = player;
        return true;
    }
    public boolean verifyMove(int x, int y){
        return board[y][x] == null;
    }
    public boolean hasWinner(){
        if((board[0][0]!=null && board[0][0]==board[0][1] && board[0][0]==board[0][2])
                ||(board[0][0]!=null && board[0][0]==board[1][0] && board[2][0]==board[0][0])
                ||(board[0][0]!=null && board[0][0]==board[1][1] && board[0][0]==board[2][2])){
            winner = board[0][0];
            return true;
        }
        if((board[2][2]!=null && board[2][2]==board[2][1] && board[2][2]==board[2][0])
                ||(board[2][2]!=null && board[2][2]==board[1][2] && board[2][2]==board[0][2])){
            winner = board[2][2];
            return true;
        }
        if((board[2][0]!=null && board[2][0]==board[1][1] && board[2][0]==board[0][2])){
            winner = board[2][0];
            return true;
        }
        if(board[1][0]!=null && board[1][0]==board[1][1] && board[1][0]==board[1][2]){
            winner = board[1][0];
            return true;
        }
        if(board[0][1]!=null && board[0][1]==board[1][1] && board[0][1]==board[2][1]){
            winner = board[0][1];
            return true;
        }
        return false;
    }
    public Player getWinner(){
        return winner;
    }

    public boolean isFilled() {
        for(Player[] row : board){
            for(Player cell : row){
                if(cell == null) return false;
            }
        }
        return true;
    }

    public int getRandomValidPosition(){
        int x=0, y=0;
        int random = new Random(System.currentTimeMillis()).nextInt(9) +1;
        while(random > 0){
            x++;
            y+=(x/3);
            y%=3;
            x%=3;
            if(board[y][x] == null) random--;
        }
        return x*3+y;
    }
}
