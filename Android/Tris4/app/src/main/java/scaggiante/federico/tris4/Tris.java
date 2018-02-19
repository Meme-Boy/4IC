package scaggiante.federico.tris4;

import android.util.Log;

import java.util.Random;

public class Tris {
    private String[][] board;
    private static final int rows = 3;
    private static final int columns = 3;
    // Metodo Costruttore
    // Creo una matrice 3*3 vuota
    public Tris() {
        board = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = " ";
            }
        }
    }
    // Metodo che restituisce lo stato della matrice
    public String tostring() {
        String r = "";
        for (int i = 0; i < rows; i++) {
            r = r + "|";
            for (int j = 0; j < columns; j++) {
                r = r + board[i][j];
            }
            r = r + "|\n";
        }
        return r;
    }
    // Metodo che permette di inserire una giocata
    public boolean set(int i, int j, String player) {
        if (board[i][j] != " ") {
            return false;
        }
        board[i][j] = player;
        return true;
    }
    // Metodo che restituisce il nome del giocatore vincitore
    public String getWinner() {
        int k = 0;
        int h = 0;
        int i;
        // Verifico se il tris è presente in una riga
        for (i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == "x") {
                    k++;
                    if (k == 3) {
                        return "x";
                    }
                } else {
                    if (board[i][j] == "o") {
                        h++;
                        if (h == 3) {
                            return "o";
                        }
                    }
                }
            }
            k = 0;
            h = 0;
        }
        // Verifico se il tris è presente in una colonna
        for (i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (board[j][i] == "x") {
                    k++;
                    if (k == 3) {
                        return "x";
                    }
                } else {
                    if (board[j][i] == "o") {
                        h++;
                        if (h == 3) {
                            return "o";
                        }
                    }
                }
            }
            k = 0;
            h = 0;
        }
        // Verifico se il tris è presente in una diagonale
        for (i = 0; i < rows; i++) {
            int j = i;
            if (board[i][j] == "x") {
                k++;
                if (k == 3) {
                    return "x";
                }
            } else {
                if (board[i][j] == "o") {
                    h++;
                    if (h == 3) {
                        return "o";
                    }
                }
            }
        }
        k = 0;
        h = 0;
        int j = 2;
        for (i = 0; i < rows; i++) {
            if (board[i][j] == "x") {
                k++;
                if (k == 3) {
                    return "x";
                }
            } else {
                if (board[i][j] == "o") {
                    h++;
                    if (h == 3) {
                        return "o";
                    }
                }
            }
            j--;
        }
        return "";
    }
    public boolean isFull(){
        boolean f=true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(board[i][j]==" "){
                    f=false;
                }
            }
        }
        return f;
    }
    public String[][] getBoard(){
        return board;
    }
    public void makeMove(){
        Random r=new Random();
        int i;
        int j;
        do{
            i=r.nextInt(3);
            j=r.nextInt(3);
        }while(set(i,j,"o")==false);
        set(i,j,"o");
    }
}
