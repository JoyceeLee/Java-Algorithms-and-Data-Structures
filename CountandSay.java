/**
* The count-and-say sequence is the sequence of integers beginning as follows:
* 1, 11, 21, 1211, 111221, ...
* 
* 1 is read off as "one 1" or 11.
* 11 is read off as "two 1s" or 21.
* 21 is read off as "one 2, then one 1" or 1211.
* Given an integer n, generate the nth sequence.
* 
* Note: The sequence of integers will be represented as a string.
* /


public class Solution {
    public String countAndSay(int n) {
        String cur = "1";
        String next = "";
        for(int i=1; i<n; i++) {
            int idx1=0;
            int idx2=idx1+1;
            int count = 1;
            while(idx2<cur.length()) {
                if(cur.charAt(idx2)==cur.charAt(idx1)) {
                    idx2++;
                    count++;
                } else {
                    next += count;
                    next += cur.charAt(idx1); // + 
                    idx1 = idx2++;
                    count = 1;
                }
            }
            next += count;
            next += cur.charAt(idx1); // +
            cur = next;
            next = "";
        }
        return cur;
    }
}
