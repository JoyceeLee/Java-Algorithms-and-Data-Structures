// Write a program to solve a Sudoku puzzle by filling the empty cells.
// Empty cells are indicated by the character '.'.
// You may assume that there will be only one unique solution.


public class Solution {
    public void solveSudoku(char[][] board) {
        if(board==null || board.length==0) {
            return;
        }
        solved(board, 0, 0);
    }
    public boolean solved(char[][] board, int row, int col) {
        if(col==board[0].length) return solved(board, row+1, 0);
        if(row==board.length) return true;
        if(board[row][col]=='.') {
            for(char i='1'; i<='9'; i++) {
                if(isValid(board, row, col, i)) {
                    board[row][col]=i;
                    if(solved(board, row, col+1)) {
                        return true;
                    } else {
                        board[row][col] = '.';
                    }
                }
            }
            return false;
        } else {
            return solved(board, row, col+1);
        }
    }
    public boolean isValid(char[][] board, int i, int j, char c) {
        for(int row=0; row<board.length; row++) {
            if(board[row][j]==c) return false;
        }
        for(int col=0; col<board[0].length; col++) {
            if(board[i][col]==c) return false;
        }
        for(int row = i/3*3; row<i/3*3+3; row++) {
            for(int col = j/3*3; col<j/3*3+3; col++) {
                if(board[row][col]==c) return false;
            }
        }
        return true;
    }
}
