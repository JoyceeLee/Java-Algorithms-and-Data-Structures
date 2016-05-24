/**
* Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
*
* For example, Given s = “eceba”,
*
* T is "ece" which its length is 3.
*/
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) return n;

        char[] val = new char[2];
        int[] idxLast = new int[2];
        int start = 0;
    
        int i = 1;
        while (i < n && s.charAt(i) == s.charAt(0))  i++;
        if (i == n) return n;
    
        val[0] = s.charAt(0); 
        val[1] = s.charAt(i);
        idxLast[0] = i - 1; 
        idxLast[1] = i;
    
        int lenMax = i + 1;
    
        for (; i < n; i++) {
            char c = s.charAt(i);
            if (c == val[0]) {
                idxLast[0] = i;
            } else if (c == val[1]) {
                idxLast[1] = i;
            } else {
                if (i - start > lenMax) 
                    lenMax = i - start;
                if (idxLast[0] > idxLast[1]) { //replace 1
                    start = idxLast[1] + 1;
                    idxLast[1] = i;
                    val[1] = c;
                } else { // replace 0
                    start = idxLast[0] + 1;
                    idxLast[0] = i;
                    val[0] = c;
                }
            }
        }
        if (n - start > lenMax)
            lenMax = n - start;
        return lenMax;
    }
}
