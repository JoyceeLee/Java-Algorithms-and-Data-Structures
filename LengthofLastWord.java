// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

// If the last word does not exist, return 0.

// Note: A word is defined as a character sequence consists of non-space characters only.

// For example,
// Given s = "Hello World", return 5.


public class Solution {
    public int lengthOfLastWord(String s) {
        int ret = 0;
        int len = s.length()-1;
        for(int i=len; i>=0; i--) {
            if(s.charAt(i)==' ' && ret==0) {}
            else if(s.charAt(i)!=' ') {
                ret++;
            }
            else if(s.charAt(i)==' ' && ret!=0) {
                return ret;
            }
        }
        return ret;
    }
}
