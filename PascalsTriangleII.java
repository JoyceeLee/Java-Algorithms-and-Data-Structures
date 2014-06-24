// Given an index k, return the kth row of the Pascal's triangle.

// For example, given k = 3, Return [1,3,3,1].

// Note:
// Could you optimize your algorithm to use only O(k) extra space?


public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> cur = new ArrayList<Integer>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        cur.add(1);
        int level = 0;
        while(level<k) {
            tmp.add(1);
            int num = 0;
            while(num<level-1) {
                tmp.add(cur.get(num)+cur.get(num+1));
                num++;
            }
            tmp.add(1);
            cur.clear();
            cur.addAll(tmp);
            tmp.clear();
            level++;
        }
        return cur;
    }
}
