/*
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:
Given "aacecaaa", return "aaacecaaa".
Given "abcd", return "dcbabcd".
*/

// Solution 1. KMP
public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        
        String rev = reverse(s);
        String str = s + "#" + rev; // suppose s does not contain '#'
        
        int[] table = tableKMP(str);
        
        int longestIdx = table[table.length - 1];
        return rev.substring(0, rev.length() - 1 - longestIdx) + s;
    }
    
    private String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    private int[] tableKMP(String str) {
        int[] t = new int[str.length()]; // suppose str.length() >= 2
        t[0] = -1;
        t[1] = 0;
        
        int idx = 0;
        int cur = 2;
        char[] array = str.toCharArray();
        
        // use case: ababcdababab
        while (cur < array.length) {
            if (array[idx] == array[cur-1]) {
                t[cur++] = ++idx;
            } else if (idx > 0) {
                idx = t[idx];
            } else { // idx == 0, t[0] == -1
                t[cur++] = 0;
            }
        }
        
        return t;
    }
}
