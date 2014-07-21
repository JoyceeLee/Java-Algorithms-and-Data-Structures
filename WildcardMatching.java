/*
* Implement wildcard pattern matching with support for '?' and '*'.
* 
* '?' Matches any single character.
* '*' Matches any sequence of characters (including the empty sequence).
* 
* The matching should cover the entire input string (not partial).
* 
* The function prototype should be:
* bool isMatch(const char *s, const char *p)
* 
* Some examples:
* isMatch("aa","a") → false
* isMatch("aa","aa") → true
* isMatch("aaa","aa") → false
* isMatch("aa", "*") → true
* isMatch("aa", "a*") → true
* isMatch("ab", "?*") → true
* isMatch("aab", "c*a*b") → false
*/

// Solution 1> brute force (time limit exceed)
public class Solution {
	public static boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }
    public static boolean helper(String s, String p, int i, int j) {
        if(j==p.length())
    		return i==s.length();
 
        if(p.charAt(j)!='*') {
            if(i==s.length() || p.charAt(j)!='?'&&s.charAt(i)!=p.charAt(j))
            	return false;   
            return helper(s, p, i+1, j+1);
        }
        
        while(i<=s.length()) {
            if(helper(s, p, i, j+1))
                return true;
            i++;
        }
        return false;
    }
}


// Solution 2> Dynamic Programming
/* res[i] means if the former i characters if s could match the former j characters of p
*  as we only have to know if the former i characters match former j-1 chars when calculate 'i with j',
*  so 1 dim array is enough
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length()==0)
            return s.length()==0;
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for(int j=0; j<p.length(); j++) {
            if(p.charAt(j)!='*') {
                for(int i=s.length()-1; i>=0; i--) {
                    res[i+1] = res[i]&&(p.charAt(j)=='?'||s.charAt(i)==p.charAt(j));
                }
            } else {
                int i = 0;
                while(i<=s.length() && !res[i])
                    i++;
                while(i<=s.length()) {
                    res[i] = true;
                    i++;
                }
            }
            res[0] = res[0]&&p.charAt(j)=='*';
        }
        return res[s.length()];
    }
}

// Solution 3>
public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int star = -1;
        int last = 0;
        while(i<s.length()) {
            if(j<p.length() && (p.charAt(j)=='?'||p.charAt(j)==s.charAt(i))) {
                i++;
                j++;
                continue;
            }
            if(j<p.length() && p.charAt(j)=='*') {
                star = j;
                j++;
                last = i;
                continue;
            }
            if(star>=0) {
                j = star+1;
                i = ++last;
                continue;
            }
            return false;
        }
        while(j<p.length() && p.charAt(j)=='*') {
            j++;
        }
        return j==p.length();
    }
}
    }
