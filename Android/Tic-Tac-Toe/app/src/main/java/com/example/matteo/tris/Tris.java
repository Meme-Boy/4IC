package com.example.matteo.tris;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Tris {

    private static char[][] btn;
    private static boolean victory;

    public static void set(View view,char pressed){
        Button clicked = (Button)(view);
        switch (view.getId()) {
            case R.id.uno: btn[0][0] = pressed; break;
            case R.id.due: btn[0][1] = pressed; break;
            case R.id.tre: btn[0][2] = pressed; break;
            case R.id.quattro: btn[1][0] = pressed; break;
            case R.id.cinque: btn[1][1] = pressed; break;
            case R.id.sei: btn[1][2] = pressed; break;
            case R.id.sette: btn[2][0] = pressed; break;
            case R.id.otto: btn[2][1] = pressed; break;
            case R.id.nove: btn[2][2] = pressed; break;
        }

    }

    public static boolean checkVictory(Intent i){

        victory=false;

        if(btn[0][0]==btn[0][1] && btn[0][0]==btn[0][2] && btn[0][0]!=' ') { i.putExtra("winner",btn[0][0]) ; victory=true; }
        if(btn[1][0]==btn[1][1] && btn[1][0]==btn[1][2] && btn[1][0]!=' ') { i.putExtra("winner",btn[1][0]) ; victory=true; }
        if(btn[2][0]==btn[2][1] && btn[2][0]==btn[2][2] && btn[2][0]!=' ') { i.putExtra("winner",btn[2][0]) ; victory=true; }

        if(btn[0][0]==btn[1][0] && btn[0][0]==btn[2][0] && btn[0][0]!=' ') { i.putExtra("winner",btn[0][0]) ; victory=true; }
        if(btn[0][1]==btn[1][1] && btn[0][1]==btn[2][1] && btn[0][1]!=' ') { i.putExtra("winner",btn[0][1]) ; victory=true; }
        if(btn[0][2]==btn[1][2] && btn[0][2]==btn[2][2] && btn[0][2]!=' ') { i.putExtra("winner",btn[0][2]) ; victory=true; }

        if(btn[0][0]==btn[1][1] && btn[0][0]==btn[2][2] && btn[0][0]!=' ') { i.putExtra("winner",btn[0][0]) ; victory=true; }
        if(btn[0][2]==btn[1][1] && btn[0][2]==btn[2][0] && btn[0][2]!=' ') { i.putExtra("winner",btn[0][2]) ; victory=true; }

        return victory;

    }

    public static void pareggio(Intent i){
        i.putExtra("winner",'n');
    }

    public static void clear(){
        btn= new char[][] {
                {' ',' ',' '},
                {' ',' ',' '},
                {' ',' ',' '}
        };
        victory=false;
    }

}
