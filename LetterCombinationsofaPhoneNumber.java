/**
* Given a digit string, return all possible letter combinations that the number could represent.
* 
* A mapping of digit to letters (just like on the telephone buttons) is given below.
* 
* Input:Digit string "23"
* Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
* /


public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> results=new ArrayList<String>();
        StringBuilder re=new StringBuilder();
        String[] board=new String[10];
        board[0]=" ";
        board[1]="1";
        board[2]="abc";
        board[3]="def";
        board[4]="ghi";
        board[5]="jkl";
        board[6]="mno";
        board[7]="pqrs";
        board[8]="tuv";
        board[9]="wxyz";
        helper(results,re,digits,board,0);
        return results;
    }
    public void helper(ArrayList<String> results, StringBuilder re, String digits, String[] board, int step){
        if(step==digits.length()){
            results.add(re.toString());
            return;
        }
        String s=board[digits.charAt(step)-'0'];
        for(int i=0;i<s.length();i++){
            re.append(s.charAt(i));
            helper(results,re,digits,board,step+1);
            re.deleteCharAt(step);
        }
    }
}
