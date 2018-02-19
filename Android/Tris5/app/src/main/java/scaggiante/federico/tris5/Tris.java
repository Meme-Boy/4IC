package scaggiante.federico.tris5;

import java.util.Arrays;
import java.util.Random;

public class Tris {
    private String[][] board;
    private static final int rows = 3;
    private static final int columns = 3;
    private int INT_MIN=-2147483647-1;
    private int INT_MAX=2147483647;
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
    public void makeEasyMove(){
        Random r=new Random();
        int i;
        int j;
        do{
            i=r.nextInt(3);
            j=r.nextInt(3);
        }while(set(i,j,"o")==false);
        set(i,j,"o");
    }
    //metodo che restituisce board sotto forma di stringa
    @Override
    public String toString() {
        return "Tris{" +
                "board=" + Arrays.toString(board) +
                '}';
    }
    //MiniMax
    public boolean psble(int i, int j)
    {
        return board[i][j]==" ";
    }
    boolean endgame() {
        int i,j;
        for(i=0;i<3;i++)
            for(j=0;j<3;j++)
                if(psble(i,j))return false;
        return true;
    }
    public void makePerfectMove(){
        int i,j;
        int max=INT_MIN,mi=1,mj=1,t;
        for(i=0;i<3;i++)
            for(j=0;j<3;j++)
                if(psble(i,j))
                {
                    board[i][j]="o";
                    t=valutamossa("x", 20);
                    if(t>max)
                    {
                        max=t;
                        mi=i;
                        mj=j;
                    }
                    board[i][j]=" ";
                }

        board[mi][mj]="o";
    }
    int valutamossa(String wnr, int deep){
        if(getWinner()=="o")
            return INT_MAX;
        if(endgame())
            return 0;
        int i, j, res, tmp;
        if(wnr=="x")
        {
            res=1;
            for(i=0;i<3;i++)
                for(j=0;j<3;j++)
                {
                    if(psble(i,j))
                    {
                        board[i][j]="x";
                        if(getWinner()=="x")
                            if(deep==20)
                            {
                                board[i][j]=" ";
                                return INT_MIN;
                            }
                            else
                                res-=2;
                        else if((tmp=valutamossa("o", deep - 1))<res)
                            res=tmp;
                        board[i][j]=" ";
                    }
                }
        }
        else
        {
            res=-1;
            for(i=0;i<3;i++)
                for(j=0;j<3;j++)
                {
                    if(psble(i,j))
                    {
                        board[i][j]="o";
                        if(getWinner()=="o")
                            res+=2;
                        else if((tmp=valutamossa("x", deep - 1))>res)
                            res=tmp;
                        board[i][j]=" ";
                    }
                }
        }
        return res;
    }
}
