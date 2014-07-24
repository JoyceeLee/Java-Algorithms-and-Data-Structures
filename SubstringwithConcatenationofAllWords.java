/**
 * You are given a string, S, and a list of words, L, that are all of the same length. 
 * Find all starting indices of substring(s) in S that is a concatenation of each word in L 
 * exactly once and without any intervening characters.
 * 
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9].
 * (order does not matter).
 */

/**
 * Time Complexity : 每次扫描的时间复杂度是O(2*n/l) (每个单词不会被访问多于两次，一次是窗口右端，一次是窗口左端)，
 * 总共扫描l次（i=0, ..., l-1)，所以总复杂度是O(2*n/l*l)=O(n)
 * Space Complexity : O(m*l), m 是字典中单词数量
 */
public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(S==null || S.length()==0 || L==null || L.length==0)
            return ret;
        int len = L[0].length();
        int total = L.length;
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for(int i=0; i<L.length; i++) {
            if(dict.containsKey(L[i])) {
                dict.put(L[i], dict.get(L[i])+1);
            } else {
                dict.put(L[i], 1);
            }
        }
        for(int i=0; i<len; i++) {
            HashMap<String, Integer> curDict = new HashMap<String, Integer>();
            int count = 0;
            int left = i;
            for(int j=i; j<=S.length()-len; j+=len) {
                
                String str = S.substring(j, j+len);
                
                if(dict.containsKey(str)) {
                    
                    if(curDict.containsKey(str))  
                        curDict.put(str,curDict.get(str)+1);  
                    else  
                        curDict.put(str,1);  
                    
                    if(curDict.get(str)<=dict.get(str))  
                        count++;  
                    else {  
                        while(curDict.get(str)>dict.get(str)) {  
                            String temp = S.substring(left,left+L[0].length());  
                            curDict.put(temp,curDict.get(temp)-1);  
                            if(curDict.get(temp)<dict.get(temp))  
                                count--;  
                            left += L[0].length();  
                        }  
                    }
                    
                    if(count == L.length) {  
                        ret.add(left);
                        String temp = S.substring(left,left+len);  
                        curDict.put(temp,curDict.get(temp)-1);  
                        count--;  
                        left += len;  
                    }  
                }  
                else {  
                    curDict.clear();  
                    count = 0;  
                    left = j+len;  
                }  
            }  
        }  
        return ret;  
    }
}
