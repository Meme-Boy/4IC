package com.example.marco.tris;

import android.content.Intent;
import android.view.View;

public class Tris {

    static short[][] btn;
    static boolean vittoria;

    public static void set(View view, short sign){
        switch (view.getId()) {
            case R.id.uno:
                btn[0][0] = sign;
                break;
            case R.id.due:
                btn[0][1] = sign;
                break;
            case R.id.tre:
                btn[0][2] = sign;
                break;
            case R.id.quattro:
                btn[1][0] = sign;
                break;
            case R.id.cinque:
                btn[1][1] = sign;
                break;
            case R.id.sei:
                btn[1][2] = sign;
                break;
            case R.id.sette:
                btn[2][0] = sign;
                break;
            case R.id.otto:
                btn[2][1] = sign;
                break;
            case R.id.nove:
                btn[2][2] = sign;
                break;
        }

    }

    public static boolean verificaVittoria(Intent i){

        vittoria=false;

        if(btn[0][0]==btn[0][1] && btn[0][0]==btn[0][2] && btn[0][0]!=' ') {
            i.putExtra("winner", btn[0][0]);
            vittoria=true;
        }
        if(btn[1][0]==btn[1][1] && btn[1][0]==btn[1][2] && btn[1][0]!=' ') {
            i.putExtra("winner", btn[1][0]);
            vittoria=true;
        }
        if(btn[2][0]==btn[2][1] && btn[2][0]==btn[2][2] && btn[2][0]!=' ') {
            i.putExtra("winner", btn[2][0]);
            vittoria=true;
        }

        if(btn[0][0]==btn[1][0] && btn[0][0]==btn[2][0] && btn[0][0]!=' ') {
            i.putExtra("winner", btn[0][0]);
            vittoria=true;
        }
        if(btn[0][1]==btn[1][1] && btn[0][1]==btn[2][1] && btn[0][1]!=' ') {
            i.putExtra("winner", btn[0][1]);
            vittoria=true;
        }
        if(btn[0][2]==btn[1][2] && btn[0][2]==btn[2][2] && btn[0][2]!=' ') {
            i.putExtra("winner",btn[0][2]);
            vittoria=true;
        }

        if(btn[0][0]==btn[1][1] && btn[0][0]==btn[2][2] && btn[0][0]!=' ') {
            i.putExtra("winner",btn[0][0]);
            vittoria=true;
        }
        if(btn[0][2]==btn[1][1] && btn[0][2]==btn[2][0] && btn[0][2]!=' ') {
            i.putExtra("winner",btn[0][2]);
            vittoria=true;
        }

        return vittoria;

    }

    public static void pareggio(Intent i){
        i.putExtra("winner",'n');
    }

    public static void restart(){
        btn= new short[][] { {' ',' ',' '}, {' ',' ',' '}, {' ',' ',' '} };
        vittoria=false;
    }
}
