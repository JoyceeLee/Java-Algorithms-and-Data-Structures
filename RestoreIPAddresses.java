/**
* Given a string containing only digits, restore it by returning all possible valid IP address combinations.
*
* For example:
* Given "25525511135",
* 
* return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/


public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> ret = new ArrayList<String>();
        if(s==null)
            return ret;
        buildIP(s, 0, "", 0, ret);
        return ret;
    }
    public void buildIP(String s, int i, String ip, int part, ArrayList<String> ret) {
        int len = s.length();
        if(i==len && part==4) {
            ip = ip.substring(0, ip.length()-1);
            ret.add(ip);
            return;
        }
        if( (len-i)>3*(4-part) || (len-i)<(4-part))
            return;
            
        int num = 0;
        for(int j=i; j<i+3 && j<len; j++) {
            num = num*10+(s.charAt(j)-'0');
            if(num<256) {
                ip+=s.charAt(j);
                buildIP(s, j+1, ip+".", part+1, ret);
            }
            if(num==0) break;
        }
    }
}
