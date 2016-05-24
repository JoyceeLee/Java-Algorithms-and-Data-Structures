// Implement atoi to convert a string to an integer.


public class Solution {
    public int atoi(String str) {
        if(str==null) return 0;
        
        str = str.trim();
        if(str.length()==0) return 0;
            
        int result = 0;
        int i = 0;
        boolean isNeg = false;
        
        if(str.charAt(i)=='-' || str.charAt(i)=='+') {
            isNeg = str.charAt(i)=='-' ? true : false;
            i++;
        }
        
        for (; i < str.length(); i++) {
            char a = str.charAt(i);
            if (a < '0' || a > '9') break;
            
            int tmp = (int)(a - '0');
            if ((Integer.MAX_VALUE - tmp) / 10 < result) {
                if (neg) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            result = result * 10 + tmp;
        }
        
        return neg ? -result : result;
    }
}
