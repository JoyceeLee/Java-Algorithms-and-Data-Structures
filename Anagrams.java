/**
* Given an array of strings, return all groups of strings that are anagrams.
* Note: All inputs will be in lower-case.
* 题意 : 是给一个String数组，找出其中由相同字母组成的单词。
* 例如 :
* S = ["abc", "bca", "bac", "bbb", "bbca", "abcb"]
* 答案 :
* ["abc", "bca", "bac", "bbca", "abcb"]
* 只有"bbb"没有相同字母组成的单词。
* /


public class Solution {
    public List<String> anagrams(String[] strs) {
        HashMap<String, ArrayList<String>> table = new HashMap<String, ArrayList<String>>();
        for(String str : strs) {
            char[] tmpCh = str.toCharArray();
            Arrays.sort(tmpCh);
            String tmp = new String(tmpCh);
            if(!table.containsKey(tmp)) {
                table.put(tmp, new ArrayList<String>());
            }
            table.get(tmp).add(str);
        }
        ArrayList<String> ret = new ArrayList<String>();
        
        for(ArrayList<String> list:table.values()) {
            if(list.size()>1) {
                ret.addAll(list);
            }
        }
        return ret;
    }
}
