/**
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
 */
public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        boolean equal = word1.equals(word2);
        int idx1 = -1, idx2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1)) {
                if (equal && idx1 != -1) {
                    idx2 = i;
                } else {
                    idx1 = i;
                }
            } else if (words[i].equals(word2)) {
                idx2 = i;
            }
            if (idx1!=-1 && idx2!=-1) {
                min = Math.min(min, Math.abs(idx1-idx2));
                if (equal) {
                    idx1 = idx2;
                    idx2 = -1;
                }
            }
        }
        return min;
    }
}
