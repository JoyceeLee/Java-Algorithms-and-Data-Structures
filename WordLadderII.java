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
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
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
        pre.put(start, new ArrayList<String>);
        pre.put(end, new ArrayList<String>);
        for(String str : dict) {
            pre.put(str, );
        }
    }
}
