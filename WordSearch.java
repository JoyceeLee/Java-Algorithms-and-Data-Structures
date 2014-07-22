/**
* Given a 2D board and a word, find if the word exists in the grid.
* 
* The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
* 
* For example,
* Given board =
* 
* [
*   ["ABCE"],
*   ["SFCS"],
*   ["ADEE"]
* ]
* word = "ABCCED", -> returns true,
* word = "SEE", -> returns true,
* word = "ABCB", -> returns false.
*/


// Solution 1> brute force : time limit exceed
class coord {
    int row;
    int col;
    public coord(int r, int c) {
        row = r;
        col = c;
    }
}
public class Solution {
    public boolean exist(char[][] board, String word) {
        LinkedList<coord> point = new LinkedList<coord>();
        int cur=0;
        int next=0;
        int len = board[0].length;
        int hei = board.length;
        for(int i=0; i<hei; i++) {
            for(int j=0; j<len; j++) {
                if(board[i][j]==word.charAt(0)) {
                    point.offer(new coord(i, j));
                    cur++;
                }
            }
        }
        for(int i=1; i<word.length(); i++) {
            char goal = word.charAt(i);
            while(cur>0) {
                coord tmpcor = point.poll();
                board[tmpcor.row][tmpcor.col] = '*';
                cur--;
                if(tmpcor.row>0 && board[tmpcor.row-1][tmpcor.col]==goal) {
                    next++;
                    point.offer(new coord(tmpcor.row-1, tmpcor.col));
                }
                if(tmpcor.col>0 && board[tmpcor.row][tmpcor.col-1]==goal) {
                    next++;
                    point.offer(new coord(tmpcor.row, tmpcor.col-1));
                }
                if(tmpcor.row<hei-1 && board[tmpcor.row+1][tmpcor.col]==goal) {
                    next++;
                    point.offer(new coord(tmpcor.row+1, tmpcor.col));
                }
                if(tmpcor.col<len-1 && board[tmpcor.row][tmpcor.col+1]==goal) {
                    next++;
                    point.offer(new coord(tmpcor.row, tmpcor.col+1));
                }
            }
            if(next==0) return false;
            cur = next;
            next = 0;
        }
        return true;
    }
}
