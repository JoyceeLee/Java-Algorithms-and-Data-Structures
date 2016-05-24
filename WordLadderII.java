/**
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * 
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 * [
 *  ["hit","hot","dot","dog","cog"],
 *  ["hit","hot","lot","log","cog"]
 * ]
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
 

public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> ret = new ArrayList<List<String>>();
        List<String> tmp = new ArrayList<String>();
        if(start==null || end==null || start.length()!=end.length()) return ret;
        if(start.equals(end)) {
            tmp.add(start);
            tmp.add(end);
            ret.add(tmp);
            return ret;
        }
        HashMap<String, ArrayList<String>> pre = new HashMap<String, ArrayList<String>>();
        pre.put(start, new ArrayList<String>());
        pre.put(end, new ArrayList<String>());
        for(String str : dict) {
            pre.put(str, new ArrayList<String>());
        }
        Queue<String> que = new LinkedList<String>();
        que.add(start);
        ArrayList<String> curLevel = new ArrayList<String>();
        int levelSize = 0;
        while(!que.isEmpty()) {
            curLevel.clear();
            levelSize = que.size();
            for(int i=0; i<levelSize; i++) {
                String top = que.poll();
                if(dict.contains(top))
                    dict.remove(top);
                curLevel.add(top);
            }
            for(String str : curLevel) {
                char[] curStr = str.toCharArray();
                for(int i=0; i<str.length(); i++) {
                    char org = curStr[i];
                    for(char j='a'; j<='z'; j++) {
                        if(j==org) continue;
                        curStr[i] = j;
                        String tmpStr = new String(curStr);
                        if(!str.equals(start) && tmpStr.equals(end)) {
                            que.add(tmpStr);
                            pre.get(tmpStr).add(str);
                        } else {
                            if(dict.contains(tmpStr)) {
                                if(!que.contains(tmpStr))
                                    que.add(tmpStr);
                                pre.get(tmpStr).add(str);
                            }
                        }
                    }
                    curStr[i] = org;
                }
            }
            if(que.contains(end))
                break;
        }
        tmp.add(end);
        buildLadder(ret, tmp, pre, start, end);
        return ret;
    }
    public void buildLadder(List<List<String>> ret, List<String> tmp, HashMap<String, ArrayList<String>> pre,
                            String start, String end) {
        if(end.equals(start)) {
            List<String> tmp2 = new ArrayList<String>(tmp);
            Collections.reverse(tmp2);
            ret.add(tmp2);
            return;
        }
        for(String str : pre.get(end)) {
            tmp.add(str);
            buildLadder(ret, tmp, pre, start, str);
            tmp.remove(tmp.size()-1);
        }
    }
}
