/** 
* Given two strings s and t, write a function to determine if t is an anagram of s.
* 
* For example,
* s = "anagram", t = "nagaram", return true.
* s = "rat", t = "car", return false.
* 
* Note:
* You may assume the string contains only lowercase alphabets.
* 
* Follow up:
* What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/

Solution 1 Hashtable
import java.util.Hashtable;
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null) {
            return (t == null);
        }
        if (s.length() != t.length()) {
            return false;
        }
        Hashtable<Character, Integer> hashtable = new Hashtable<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashtable.containsKey(c)) {
                int num = hashtable.get(c) + 1;
                hashtable.put(c, num);
            } else {
                hashtable.put(c, 1);
            }
        }
        for (int i = 0; i< t.length(); i++) {
            char c = t.charAt(i);
            if (!hashtable.containsKey(c)) {
                return false;
            }
            int num = hashtable.get(c) - 1;
            hashtable.put(c, num);
        }
        for (char key : hashtable.keySet()) {
            if (hashtable.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
}
