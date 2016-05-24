/**
* Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
* 
* The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
* 
* A partially filled sudoku which is valid.
* 
* Note:
* A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
* /


public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];
        for(int i=0; i<9; i++)
            for(int j=0; j<9; j++) {
                row[i][j] = false;
                col[i][j] = false;
                block[i][j] = false;
            }
        for(int i=0; i<9; i++)
            for(int j=0; j<9; j++) {
                if(board[i][j]=='.')
                    continue;
                int tmp = board[i][j]-'1';
                if(row[i][tmp] || col[j][tmp] || block[i/3*3+j/3][tmp])
                    return false;
                row[i][tmp]=true;
                col[j][tmp]=true;
                block[i/3*3+j/3][tmp]=true;
            }
        return true;
    }
}
