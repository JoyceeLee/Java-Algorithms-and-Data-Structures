/**
* Evaluate the value of an arithmetic expression in Reverse Polish Notation.
* 
* Valid operators are +, -, *, /. Each operand may be an integer or another expression.
* 
* Some examples:
*   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
*   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
* /


public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0; i<tokens.length; i++) {
            if(tokens[i].matches("-?\\d+")) {
                st.push(Integer.parseInt(tokens[i]));
            } else {
                int b = st.pop();
                int a = st.pop();
                int c = 0;
                switch(tokens[i])
                {
                    case "+":
                        c = a + b;
                        break;
                    case "-":
                        c = a - b;
                        break;
                    case "*":
                        c = a * b;
                        break;
                    case "/":
                        c = a / b;
                        break;
                }
                st.push(c);
            }
        }
        return st.pop();
    }
}
