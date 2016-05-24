/**
* Given two binary strings, return their sum (also a binary string).
* 
* For example,
* a = "11"
* b = "1"
* Return "100".
*/


public class Solution {
    public String addBinary(String a, String b) {
        int idx1 = a.length()-1;
        int idx2 = b.length()-1;
        int carray = 0;
        StringBuilder ret = new StringBuilder();
        while(idx1>=0 || idx2>=0 || carray>0) {
            int tmp = carray;
            if(idx1>=0) {
                tmp += (int)(a.charAt(idx1)-'0');
                idx1--;
            }
            if(idx2>=0) {
                tmp += (int)(b.charAt(idx2)-'0');
                idx2--;
            }
            ret.insert(0, tmp % 2);
            carray = tmp/2;
        }
        return ret.toString();
    }
}
