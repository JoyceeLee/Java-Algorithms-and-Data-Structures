/**
* Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
* 
* Return all such possible sentences.
* 
* For example, given
* s = "catsanddog",
* dict = ["cat", "cats", "and", "sand", "dog"].
* 
* A solution is ["cats and dog", "cat sand dog"].
*/

/**
use the help of DP strategy. break the string from back to front to make sure we only record the breaks that we could get to the end
*/
public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> ret = new ArrayList<String>();
        if(s==null || s.length()==0)
            return ret;
            
        int len = s.length();
        ArrayList<ArrayList<Integer>> record = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<len; i++) {
            record.add(new ArrayList<Integer>());
        }
        for(int end=len; end>0; end--) {
            if(end<len && record.get(end).isEmpty())
                continue;
            for(int start=end-1; start>=0; start--) {
                String sub = s.substring(start, end);
                if(dict.contains(sub)) {
                    record.get(start).add(end);
                }
            }
        }
        
        buildSolution(ret, 0, "", s, record);
        return ret;
    }
    public void buildSolution(ArrayList<String> ret, int point, String str, String s, ArrayList<ArrayList<Integer>> record) {
        if(point==s.length()) {
            ret.add(str);
            return;
        }
        for(int i : record.get(point)) {
            String sub = point==0 ? s.substring(point, i) : str + " " + s.substring(point, i);
            buildSolution(ret, i, sub, s, record);
        }
    }
}
