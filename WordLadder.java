/**
* Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
* 
* Only one letter can be changed at a time
* Each intermediate word must exist in the dictionary
* For example,
* Given:
* start = "hit"
* end = "cog"
* dict = ["hot","dot","dog","lot","log"]
* As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
* return its length 5.
* 
* Note:
* Return 0 if there is no such transformation sequence.
* All words have the same length.
* All words contain only lowercase alphabetic characters.
* 
* ps: Classical BFS question, the same form with binary tree level traversal, different point is how to check valid children(neighbours) and put them into the next level Queue


public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<String> queCur = new LinkedList<String>();
        Queue<String> queNext = new LinkedList<String>();
        int step = 1;
        queCur.offer(start);
        while(!queCur.isEmpty() || !queNext.isEmpty()) {
            while(!queCur.isEmpty()) {
                String curString = queCur.poll();
                char[] tmpChar = curString.toCharArray();
                for(int i=0; i<tmpChar.length; i++) {
                    char org = tmpChar[i];
                    for(char j='a'; j<='z'; j++) {
                        if(j==org) continue;
                        tmpChar[i] = j;
                        String tmpStr = new String(tmpChar);
                        if(tmpStr.equals(end)) {
                            return step+1;
                        }
                        if(dict.contains(tmpStr)) {
                            queNext.offer(tmpStr);
                            dict.remove(tmpStr);
                        }
                    }
                    tmpChar[i] = org;
                }
            }
            step++;
            queCur.addAll(queNext);
            queNext.clear();
        }
        return 0;
    }
}
