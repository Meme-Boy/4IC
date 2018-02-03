package gq.francescorossato.tictactoe;


import java.util.Random;

/**
 * Created by TheRoss on 01/02/2018.
 */

public class TTTGame {
    private final int ROWS = 3, COLS = 3;
    private char[][] board = new char[ROWS][COLS];

    public TTTGame() {
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                board[i][j] = ' ';
    }

    private char checkHorizontal(){
        if(board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] != ' ')
            return board [0][0];
        else {
            if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] != ' ')
                return board[1][0];
            else {
                if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] != ' ')
                    return board[2][0];
                else return ' ';
            }
        }
    }
    private char checkVertical(){
        if(board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] != ' ')
            return board [0][0];
        else {
            if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] != ' ')
                return board[0][1];
            else {
                if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] != ' ')
                    return board[0][2];
                return ' ';
            }
        }
    }
    private char checkDiagonal(){
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')
            return board [0][0];
        else
            if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')
                return board[0][2];
        return ' ';
    }
    private char checkDraft(){
        for (char[] cells : board)
            for (char cell : cells)
                if (cell == ' ')
                    return ' ';
        return 'd';
    }

    public char whoWon(){
        if(checkHorizontal() != ' ')
            return checkHorizontal();
        if(checkVertical() != ' ')
            return checkVertical();
        if(checkDiagonal() != ' ')
            return checkDiagonal();
        return checkDraft();
    }

    private int[] checkTwoHorizontal(){
        //first row
        if(board[0][0] != ' ' && board[0][1] == board[0][0] && board[0][2] == ' ')
            return new int[]{0, 2};
        if(board[0][2] != ' ' && board[0][1] == board[0][2] && board[0][0] == ' ')
            return new int[]{0, 0};
        if(board[0][0] != ' ' && board[0][2] == board[0][0] && board[0][1] == ' ')
            return new int[]{0, 1};
        //second row
        if(board[1][0] != ' ' && board[1][1] == board[1][0] && board[1][2] == ' ')
            return new int[]{1, 2};
        if(board[1][2] != ' ' && board[1][1] == board[1][2] && board[1][0] == ' ')
            return new int[]{1, 0};
        if(board[1][0] != ' ' && board[1][2] == board[1][0] && board[1][1] == ' ')
            return new int[]{1, 1};
        //third row
        if(board[2][0] != ' ' && board[2][1] == board[2][0] && board[2][2] == ' ')
            return new int[]{2, 2};
        if(board[2][2] != ' ' && board[2][1] == board[2][2] && board[2][0] == ' ')
            return new int[]{2, 0};
        if(board[2][0] != ' ' && board[2][2] == board[2][0] && board[2][1] == ' ')
            return new int[]{2, 1};
        return null;
    }
    private int[] checkTwoVertical(){
        //first column
        if(board[0][0] != ' ' && board[1][0] == board[0][0] && board[2][0] == ' ')
            return new int[]{2, 0};
        if(board[2][0] != ' ' && board[1][0] == board[2][0] && board[0][0] == ' ')
            return new int[]{0, 0};
        if(board[0][0] != ' ' && board[2][0] == board[0][0] && board[1][0] == ' ')
            return new int[]{1, 0};
        //second column
        if(board[0][1] != ' ' && board[1][1] == board[0][1] && board[2][1] == ' ')
            return new int[]{2, 1};
        if(board[2][1] != ' ' && board[1][1] == board[2][1] && board[0][1] == ' ')
            return new int[]{0, 1};
        if(board[0][1] != ' ' && board[2][1] == board[0][1] && board[1][1] == ' ')
            return new int[]{1, 1};
        //third column
        if(board[0][2] != ' ' && board[1][2] == board[0][2] && board[2][2] == ' ')
            return new int[]{2, 2};
        if(board[2][2] != ' ' && board[1][2] == board[2][2] && board[0][2] == ' ')
            return new int[]{0, 2};
        if(board[0][2] != ' ' && board[2][2] == board[0][2] && board[1][2] == ' ')
            return new int[]{1, 2};
        return null;
    }
    private int[] checkTwoDiagonal(){
        //'\' diagonal
        if(board[0][0] != ' ' && board[1][1] == board[0][0] && board[2][2] == ' ')
            return new int[]{2, 2};
        if(board[2][2] != ' ' && board[1][1] == board[2][2] && board[0][0] == ' ')
            return new int[]{0, 0};
        if(board[0][0] != ' ' && board[2][2] == board[0][0] && board[1][1] == ' ')
            return new int[]{1, 1};
        //'/' diagonal
        if(board[0][2] != ' ' && board[1][1] == board[0][2] && board[2][0] == ' ')
            return new int[]{2, 0};
        if(board[2][0] != ' ' && board[1][1] == board[2][0] && board[0][2] == ' ')
            return new int[]{0, 2};
        if(board[0][2] != ' ' && board[2][0] == board[0][2] && board[1][1] == ' ')
            return new int[]{1, 1};
        return null;
    }

    public int move(){
        if(checkTwoHorizontal() != null){
            int[] pos = checkTwoHorizontal();
            board[pos[0]][pos[1]] = 'O';
            return pos[0]*3+pos[1];
        }
        else{
            if(checkTwoVertical() != null){
                int[] pos = checkTwoVertical();
                board[pos[0]][pos[1]] = 'O';
                return pos[0]*3+pos[1];
            }
            else{
                if(checkTwoDiagonal() != null){
                    int[] pos = checkTwoDiagonal();
                    board[pos[0]][pos[1]] = 'O';
                    return pos[0]*3+pos[1];
                }
                else return moveRandom();
            }
        }
    }
    public boolean move(int cellPos){
        for(int i = 0; i < ROWS; i++)
            for(int j = 0; j < COLS; j++)
                if (i * 3 + j == cellPos && board[i][j] == ' ') {
                    board[i][j] = 'X';
                    return true;
                }
        return false;
    }
    private int moveRandom() {
        int freeCells = 0;
        for (char[] cells : board)
            for (char c : cells)
                if (c == ' ')
                    freeCells++;
        if (freeCells > 0) {
            int cellNumber = new Random().nextInt(freeCells)+1;
            int count = 0;
            for (int i = 0; i < ROWS; i++)
                for (int j = 0; j < COLS; j++) {
                    if (board[i][j] == ' ')
                        count++;
                    if (count == cellNumber) {
                        board[i][j] = 'O';
                        return i*3+j;
                    }
                }
        }
        return -1;
    }

    public String toString(){
        String s = "";
        for (char[] row : board)
            for (char c : row)
                s+= c;
        return s;
    }
}


