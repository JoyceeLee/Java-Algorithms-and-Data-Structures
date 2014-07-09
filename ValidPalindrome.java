/**
* Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
* 
* For example,
* "A man, a plan, a canal: Panama" is a palindrome.
* "race a car" is not a palindrome.
* 
* Note:
* Have you consider that the string might be empty? This is a good question to ask during an interview.
* 
* For the purpose of this problem, we define empty string as valid palindrome.
* /


public class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j) {
            while(i<j && !isAlpha(s.charAt(i))) {
                i++;
            }
            while(i<j && !isAlpha(s.charAt(j))) {
                j--;
            }
            if(!equalCh(s.charAt(i), s.charAt(j))) {
                return false;
            }
            i++; j--;
        }
        return true;
    }
    public boolean isAlpha(char c) {
        return (('a'<=c&&'z'>=c)||('A'<=c&&'Z'>=c)||('0'<=c&&'9'>=c));
    }
    public boolean equalCh(char a, char b) {
        return ((b-a == 0) || (Math.abs(b-a)==Math.abs('A'-'a')));
    }
}
