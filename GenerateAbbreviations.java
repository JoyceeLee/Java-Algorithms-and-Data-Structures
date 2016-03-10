/**
Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
*/

回溯法，这里 cnt 和 str 同时参加回溯
// 4, 3d, 2r1, 2rd, 1o2, 1o1d, 1or1, 1ord, w3, w2d, w1r1, w1rd, wo2, wo1d, wor1, word

Solution 1 
public class Solution {
    public List<String> generateAbbreviations(String word) {
         List<String> list = new ArrayList<String>();
         backtrack(list, 0, word, 0, new StringBuilder());
         return list;
    }
    private void backtrack(List<String> list, int pt, String word, int cnt, StringBuilder str) {
        if (pt == word.length()) {
            if (cnt > 0) str.append(cnt);
            list.add(str.toString());
            while (cnt > 0) {
                str.deleteCharAt(str.length()-1);
                cnt = cnt / 10;
            }
            return;
        }
        
        backtrack(list, pt+1, word, cnt+1, str);
        if (cnt > 0) str.append(cnt);
        backtrack(list, pt+1, word, 0, str.append(word.charAt(pt)));
        str.deleteCharAt(str.length()-1);
        while (cnt > 0) {
            str.deleteCharAt(str.length()-1);
            cnt = cnt / 10;
        } 
    }
}

Solution 2 w/ Math.log10()
public class Solution {
    public List<String> generateAbbreviations(String word) {
         List<String> list = new ArrayList<String>();
         backtrack(list, 0, word, 0, new StringBuilder());
         return list;
    }
    private void backtrack(List<String> list, int pt, String word, int cnt, StringBuilder str) {
        if (pt == word.length()) {
            if (cnt > 0) str.append(cnt);
            list.add(str.toString());
            if (cnt > 0) str.delete(str.length()-(int)Math.log10(cnt)-1, str.length());
            return;
        }
        
        backtrack(list, pt+1, word, cnt+1, str);
        if (cnt > 0) str.append(cnt);
        backtrack(list, pt+1, word, 0, str.append(word.charAt(pt)));
        str.deleteCharAt(str.length()-1);
        if (cnt > 0) str.delete(str.length()-(int)Math.log10(cnt)-1, str.length());

    }
}
