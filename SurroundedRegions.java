// Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

// A region is captured by flipping all 'O's into 'X's in that surrounded region.

/** 
* For example,
* X X X X
* X O O X
* X X O X
* X O X X
* After running your function, the board should be:
* 
* X X X X
* X X X X
* X X X X
* X O X X
* /

public class Solution {
    public void solve(char[][] board) {
        if(board==null || board.length==0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        Queue<Integer> rowQue = new LinkedList<Integer>();
        Queue<Integer> colQue = new LinkedList<Integer>();
        for(int i=0; i<m; i++) {
            if(board[i][0]=='O') {
                rowQue.offer(i);
                colQue.offer(0);
            }
            if(board[i][n-1]=='O') {
                rowQue.offer(i);
                colQue.offer(n-1);
            }
        }
        for(int i=0; i<n; i++) {
            if(board[0][i]=='O') {
                rowQue.offer(0);
                colQue.offer(i);
            }
            if(board[m-1][i]=='O') {
                rowQue.offer(m-1);
                colQue.offer(i);
            }
        }
        while(!rowQue.isEmpty()) {
            int tmpr = rowQue.poll();
            int tmpc = colQue.poll();
            board[tmpr][tmpc] = 'M';
            if(tmpr>0 && board[tmpr-1][tmpc]=='O') {
                rowQue.offer(tmpr-1);
                colQue.offer(tmpc);
            }
            if(tmpr<m-1 && board[tmpr-1][tmpc]=='O') {
                rowQue.offer(tmpr+1);
                colQue.offer(tmpc);
            }
            if(tmpc>0 && board[tmpr][tmpc-1]=='O') {
                rowQue.offer(tmpr);
                colQue.offer(tmpc-1);
            }
            if(tmpc<n-1 && board[tmpr][tmpc+1]=='O') {
                rowQue.offer(tmpr);
                colQue.offer(tmpc+1);
            }
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = board[i][j] == 'M' ? 'O' : 'X';
            }
        }
    }
}
