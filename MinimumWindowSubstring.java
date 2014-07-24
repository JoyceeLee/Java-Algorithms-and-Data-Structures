/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * 
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * 
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */


public class Solution {
    public String minWindow(String S, String T) {
        if(S==null || T==null || S.length()==0 || T.length()==0) {
            return null;
        }
        
        int slen = S.length()
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        for(int i=0; i<T.length(); i++) {
            char cur = T.charAt(i);
            if(dict.containsKey(cur)) {
                dict.put(cur, dict.get(cur)+1);
            } else {
                dict.put(cur, 1);
            }
        }
        
        int minLength = slen+1;
        String ret = "";
        int left = 0;
        int count = 0;
        for(int i=0; i<slen; i++) {
            char tmp = S.charAt(i);
            if(dict.containsKey(tmp)) {
                dict.put(tmp, dict.get(tmp)-1);
                if(dict.get(tmp)>=0) {
                    count++;
                }
                while(count==T.length()) {
                    char first = S.charAt(left);
                    if(dict.contains(first)) {
                        dict.put(first, dict.get(first+1));
                        if(dict.get(first)>0) {
                            count--;
                            if(minLength>i-left+1) {
                                minLength = i-left+1;
                                ret = S.substring(left, i+1);
                            }
                        }
                    }
                    left++;
                }
            }
        }
        return ret;
    }
}
