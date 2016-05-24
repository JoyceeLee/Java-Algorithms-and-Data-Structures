/**
* Given a string s, partition s such that every substring of the partition is a palindrome.
* 
* Return all possible palindrome partitioning of s.
* 
* For example, given s = "aab",
* Return
* 
*   [
*     ["aa","b"],
*     ["a","a","b"]
*   ]
* /


public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<List<String>>();
        List<String> cur = new ArrayList<String>();
        buildPartition(s, 0, ret, cur);
        return ret;
    }
    public void buildPartition(String s, int start, List<List<String>> ret, List<String> cur) {
        if(start==s.length()) {
            ret.add(new ArrayList<String>(cur));
            return;
        }
        for(int i=start+1; i<=s.length(); i++) {
            String subString =  s.substring(start, i);
            if(isPalindrome(subString)) {
                cur.add(subString);
                buildPartition(s, i, ret, cur);
                cur.remove(cur.size()-1);
            }
        }
    }
    public boolean isPalindrome(String subString) {
        int p=0;
        int q=subString.length()-1;
        while(p<q) {
            if(subString.charAt(p)!=subString.charAt(q))
                return false;
            p++;
            q--;
        }
        return true;
    }
}
