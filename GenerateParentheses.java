// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:
// "((()))", "(()())", "(())()", "()(())", "()()()"


public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ret = new ArrayList<String>();
        makePair(ret, 0, 0, n, "");
    }
    public void makePair(ArrayList<String> ret, int lnum, int rnum, int n, String str) {
        if(lnum==n) {
            for(int i=0; i<n-rnum; i++) {
                str += ")";
            }
            ret.add(str);
            return;
        }
        makePair(ArrayList<String> ret, lnum+1; rnum, n, str+"(");
        if(lnum>rnum) {
            makePair(ArrayList<String> ret, lnum; rnum+1, n, str+")");
        }
    }
}
