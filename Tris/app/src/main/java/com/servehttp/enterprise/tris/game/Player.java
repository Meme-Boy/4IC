package com.servehttp.enterprise.tris.game;

/**
 * Created by davide on 31/01/18.
 */

public class Player {
    private boolean human;
    private char symbol;
    private Tris game;

    public Player(boolean human, char symbol, Tris game){
        this.human = human;
        this.symbol = symbol;
        this.game = game;
    }
    public boolean move(int x, int y){
        return game.move(this, x, y);
    }
    public char getSymbol(){return symbol;}
//    public void setGame(Tris game){
//        this.game = game;
//    }
}
