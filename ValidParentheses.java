// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


public class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c); 
            } else {
                if(stack.isEmpty()) return false;
                char cc = stack.pop();
                switch(c) {
                    case ')' :  if(cc!='(') return false; break; // Do not forget break
                    case ']' :  if(cc!='[') return false; break; 
                    case '}' :  if(cc!='{') return false; break; 
                }
            }
        }
        return stack.isEmpty();
    }
}
