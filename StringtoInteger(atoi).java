// Implement atoi to convert a string to an integer.


public class Solution {
    public int atoi(String str) {
        if(str==null)
            return 0;
        str = str.trim();
        if(str.length()==0)
            return 0;
            
        int res = 0;
        boolean isNeg = false;
        int i = 0;
        int len = str.length();
        
        if(str.charAt(i)=='-' || str.charAt(i)=='+') {
            isNeg = str.charAt(i)=='-' ? true : false;
            i++;
        }
        while(i<len && str.charAt(i)-'0'==0) {
            i++;
        }
        while(i<len) {
            int tmp = (int)(str.charAt(i)-'0');
            if(tmp<0 || tmp>9) break; // ignore following words
            if(isNeg && res>-((Integer.MIN_VALUE+tmp)/10)) return Integer.MIN_VALUE; // never forget parenthesis
            if(!isNeg && res>((Integer.MAX_VALUE-tmp)/10)) return Integer.MAX_VALUE;
            res = res * 10 + tmp;
            i++;
        }
        return isNeg ? -res : res;
    }
}
