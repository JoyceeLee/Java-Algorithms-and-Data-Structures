// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


public class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for(int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if(c=='(' || c=='{' || c=='[') {
                st.push(c);
            } else {
                if(st.isEmpty()) return false;
                Character cc = st.pop();
                switch(c) {
                    case ')' :  if(cc!='(') return false; break; 
                    case ']' :  if(cc!='[') return false; break; 
                    case '}' :  if(cc!='{') return false; break; 
                }
            }
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}
