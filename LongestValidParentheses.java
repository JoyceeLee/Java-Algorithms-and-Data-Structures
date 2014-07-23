/**
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */


public class Solution {
    public int longestValidParentheses(String s) {
        if(s==null || s.length()==0)
            return 0;
        int longest = 0;
        int last = -1;
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0; i<s.length(); i++) {
            char tmp = s.charAt(i);
            if(tmp=='(') {
                st.push(i);
            } else {
                if(st.isEmpty()) {
                    last = i;
                } else{
                    st.pop();
                    if(st.isEmpty()) {
                        longest = Math.max(longest, i-last);
                    } else {
                        longest = Math.max(longest, i-st.peek());
                    }
                }
            }
        }
        return longest;
    }
}
