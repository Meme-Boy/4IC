package com.example.matteo.tris;


/**
 * Created by Matteo on 01/02/2018.
 */

public class Victory {

    public static boolean VictoryHorizontal(String[][] btn,int i){
        boolean win=false;
        if(btn[i][0].equals(btn[i][1]) && btn[i][0].equals(btn[i][2]) && !(btn[i][0].equals(""))) win=true;
        return win;
    }

}
