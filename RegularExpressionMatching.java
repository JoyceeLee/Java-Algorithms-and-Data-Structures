/**
* Implement regular expression matching with support for '.' and '*'.
* 
* '.' Matches any single character.
* '*' Matches zero or more of the preceding element.
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
* isMatch("aa", "a*") → true
* isMatch("aa", ".*") → true
* isMatch("ab", ".*") → true
* isMatch("aab", "c*a*b") → true
*/


/* error cases
*  1. s is longer than p can match
*  2. p is longer after match s
*  3. none match when only 1 char should be matched
*  4. none match when * match
*/

// Solution 1> Brute Force (recursion)
/* 
* Time Complexity : T(n) = O(2^n)， worst case
* T(n) = T(n-1) + ... + T(1)
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }
    public boolean helper(String s, String p, int i, int j) {
        if(j==p.length()) return i==s.length();
        
        // There must be a Character match, and only 1 compare need
        if(j==p.length()-1 || p.charAt(j+1)!='*') {
            if(i==s.length() || (s.charAt(i)!=p.charAt(j) && p.charAt(j)!='.') )
                return false;
            return helper(s, p, i+1, j+1);
        } 
        
        // P.length() >= 2 && P.charAt(1) == '*'
        while(i<s.length() && (p.charAt(j)=='.' || s.charAt(i)==p.charAt(j)) ) {
            if(helper(s, p, i, j+2)) // "x*" could match nothing at position j
                return true;
            i++;
        }
        
        return false;
    }
}

// Solution 2> Dynamic Programming
/* 
* Time Complexity : O(m*n)
* Space Complexity : O(m*n)
*/
public class Solution {
    public boolean isMatch(String s, String p) {  
        if(p.length()==0)  
            return s.length()==0;
            
        boolean[][] res = new boolean[s.length()+1][p.length()+1];  
        res[0][0] = true; 
        
        for(int j=0;j<p.length();j++) {  
            if(p.charAt(j)=='*') {  
                if(res[0][j-1]) 
                    res[0][j+1]=true;  
                if(p.charAt(j-1)!='.') {  
                    for(int i=0;i<s.length();i++) {  
                        if(res[i+1][j]
                            || res[i+1][j-1]   
                            || i>0&&res[i][j+1]&&s.charAt(i)==s.charAt(i-1)&&s.charAt(i-1)==p.charAt(j-1))  
                        res[i+1][j+1] = true;  
                    }  
                }  
                else {  
                    int i=0;  
                    while(i<s.length() && !res[i+1][j-1] && !res[i+1][j])  
                        i++;  
                    for(;i<s.length();i++) { // '.' could match any char
                        res[i+1][j+1] = true;  
                    }  
                }  
            } // p.charAt(j)=='*' --> j>0
            else {  
                for(int i=0;i<s.length();i++) {  
                    if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')  
                        res[i+1][j+1] = res[i][j];  
                }  
            }  
        }  
        return res[s.length()][p.length()];  
    }  
}
