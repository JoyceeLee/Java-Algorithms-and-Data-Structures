/**
 * Given two strings S and T, determine if they are both one edit distance apart.
 */
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        if (Math.abs(lens - lent) > 1)
            return false;
        int ps = 0;
        int pt = 0;
        int diff = 0;
        while (ps < lens && pt < lent) {
            if (s.charAt(ps) == t.charAt(pt)) {
                ps++;
                pt++;
            } else {
               diff++;
               if (diff > 1) {
                   return false;
               }
               if (lens > lent) {
                   ps++;
               } else if (lent > lens) {
                   pt++;
               } else {
                   ps++;
                   pt++;
               }
            }
        }
        if (ps < lens || pt < lent) {
            diff++;
        }
        return diff == 1;
    }
}
