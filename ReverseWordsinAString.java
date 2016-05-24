/**
 * Given an input string, reverse the string word by word.
 * 
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * 
 * click to show clarification.
 * 
 * Clarification:
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 */


/**
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 */
public class Solution {
    public String reverseWords(String s) {
        if(s==null) return s;
        s = s.trim();
        if(s.length()==0) return s;
        String[] strs = s.split("\\s+");
        String ret = "";
        for(int i=strs.length-1; i>=0; i--) {
            ret += strs[i]+" ";
        }
        ret = ret.substring(0, ret.length()-1);
        return ret;
    }
}
