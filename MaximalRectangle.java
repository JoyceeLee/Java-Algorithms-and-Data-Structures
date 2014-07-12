// Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.


public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] height = new int[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                height[i][j] = matrix[i][j]=='0' ? 0 : (i==0 ? 1 : height[i-1][j]+1);
            }
        }
        int max = 0;
        for(int i=0; i<row; i++) {
            max = Math.max(max, maxRec(height[i]));
        }
        return max;
    }
    public int maxRec(int[] h) {
        Stack<Integer> st = new Stack<Integer>();
        int j=0;
        int max = 0;
        while(j<h.length) {
            if(st.isEmpty() || h[st.peek()]<=h[j]) {
                st.push(j);
                j++;
            } else {
                int height = h[st.pop()];
                int width = st.isEmpty() ? j : j-st.peek()-1;
                max = Math.max(max, height*width);
            }
        }
        while(!st.isEmpty()) {
            int height = h[st.pop()];
            int width = st.isEmpty() ? j : j-st.peek()-1;
            max = Math.max(max, height*width);
        }
        return max;
    }
}
